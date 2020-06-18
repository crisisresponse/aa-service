package org.reciprocity.aaservice.form.impl;

import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.form.FormService;
import org.reciprocity.aaservice.model.AdditionalHouseMember;
import org.reciprocity.aaservice.model.AdultMember;
import org.reciprocity.aaservice.model.HeadHhMember;
import org.reciprocity.aaservice.model.CommunityMemberRequest;
import org.reciprocity.aaservice.repository.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {

    private NamesRepository namesRepository;
    private AddressRepository addressRepository;
    private MemberRepository memberRepository;
    private PeopleRepository peopleRepository;

    @Autowired
    private FormServiceImpl(NamesRepository namesRepository, AddressRepository addressRepository,
                            MemberRepository memberRepository, PeopleRepository peopleRepository) {
        this.namesRepository = namesRepository;
        this.addressRepository = addressRepository;
        this.memberRepository = memberRepository;
        this.peopleRepository = peopleRepository;
    }

    @Override
    public void saveForm(CommunityMemberRequest request) {
        HeadHhMember headHhMember = request.getMember();
        Name name = FormMapper.MAPPER.nameToEntity(headHhMember.getName());
        Address address = FormMapper.MAPPER.addressToEntity(headHhMember.getAddress());

        Optional nameResult = namesRepository.findById(name.getNamesId());
        Optional addressResult = addressRepository.findById(address.getAddressSurrKey());

        if (!nameResult.isPresent()) {
            namesRepository.save(name);
        }
        if (!addressResult.isPresent()) {
            addressRepository.save(address);
        }
        Member member = FormMapper.MAPPER.memberToEntity(headHhMember, name, address);

        Member savedMember = memberRepository.save(member);
        People people = FormMapper.MAPPER.peopleDtoToEntity(headHhMember.getPersonalInfo(), savedMember);
        People savedPerson = peopleRepository.save(people);
        if (headHhMember.getAdditionalHouseMembers().size() > 0) {
            for (AdditionalHouseMember addMember : headHhMember.getAdditionalHouseMembers()) {
                Name additionalName = FormMapper.MAPPER.nameToEntity(addMember.getAdditionalMemberName());
                Optional nameAdditionalResult = namesRepository.findById(name.getNamesId());
                if (!nameAdditionalResult.isPresent()) {
                    namesRepository.save(name);
                }

                if (addMember.getType().displayName.equalsIgnoreCase("child")) {
                    //figure out mapping of child

                } else {
                    Member additionalMemberEntity = memberRepository.save(FormMapper.MAPPER.additionalMemberToEntity(
                            (AdultMember) addMember,
                            additionalName,
                            address));
                    peopleRepository.save(FormMapper.MAPPER.additionalPeopleToEntity(
                            (AdultMember) addMember, additionalMemberEntity,
                            savedPerson));
                }
            }
        }

    }

}
