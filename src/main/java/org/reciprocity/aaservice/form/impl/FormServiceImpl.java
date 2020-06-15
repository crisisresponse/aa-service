package org.reciprocity.aaservice.form.impl;

import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.form.FormService;
import org.reciprocity.aaservice.model.MemberDTO;
import org.reciprocity.aaservice.repository.*;
import org.reciprocity.aaservice.model.CommunityMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FormServiceImpl implements FormService {

    private NamesRepository namesRepository;
    private AddressRepository addressRepository;
    private MemberRepository memberRepository;

    @Autowired
    private FormServiceImpl(NamesRepository namesRepository, AddressRepository addressRepository,
                            MemberRepository memberRepository) {
        this.namesRepository = namesRepository;
        this.addressRepository = addressRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void saveForm(CommunityMemberRequest request) {
        MemberDTO memberDTO = request.getMember();
        Name name = FormMapper.MAPPER.nameToEntity(memberDTO.getName());
        Address address = FormMapper.MAPPER.addressToEntity(memberDTO.getAddress());

        Optional nameResult = namesRepository.findById(name.getNamesId());
        Optional addressResult = addressRepository.findById(address.getAddressId());

        if(!nameResult.isPresent()) {
            namesRepository.save(name);
        }
        if(!addressResult.isPresent()) {
            addressRepository.save(address);
        }
        Member member = FormMapper.MAPPER.memberToEntity(memberDTO, name, address);

        memberRepository.save(member);

    }
}
