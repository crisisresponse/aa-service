package org.reciprocity.aaservice.form.impl;

import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.form.FormService;
import org.reciprocity.aaservice.model.*;
import org.reciprocity.aaservice.repository.householdmember.*;
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
        for (AdditionalHouseMember addMember : headHhMember.getAdditionalHouseMembers()) {
            Name additionalName = FormMapper.MAPPER.nameToEntity(addMember.getAdditionalMemberName());
            Optional nameAdditionalResult = namesRepository.findById(additionalName.getNamesId());
            if (!nameAdditionalResult.isPresent()) {
                namesRepository.save(additionalName);
            }
            Member additionalMemberEntity = memberRepository.save(FormMapper.MAPPER.additionalMemberToEntity(
                    addMember,
                    additionalName,
                    address));
            peopleRepository.save(FormMapper.MAPPER.additionalPeopleToEntity(
                    addMember, additionalMemberEntity,
                    savedPerson));
        }
    }
}
