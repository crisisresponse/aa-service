package org.reciprocity.aaservice.form;

import org.apache.commons.codec.digest.DigestUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.AddressDTO;
import org.reciprocity.aaservice.model.MemberDTO;
import org.reciprocity.aaservice.model.NameDTO;
import org.reciprocity.aaservice.repository.Address;
import org.reciprocity.aaservice.repository.Member;
import org.reciprocity.aaservice.repository.Name;

@Mapper
public abstract class FormMapper {

    public static FormMapper MAPPER = Mappers.getMapper(FormMapper.class);

    public Name nameToEntity(NameDTO nameDTO) {
        Name namesEntity = new Name();

        namesEntity.setFirstName(nameDTO.getFirstName());
        namesEntity.setLastName(nameDTO.getLastName());
        namesEntity.setNamesId(hashFullName(nameDTO));

        return namesEntity;
    }

    public Address addressToEntity(AddressDTO addressDTO) {
        Address addressEntity = new Address();
        addressEntity.setStreetAddress(addressDTO.getStreetAddress());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setState(addressDTO.getState());
        addressEntity.setZipCode(addressDTO.getZipCode());
        addressEntity.setAddressId(hashAddress(addressDTO));

        return addressEntity;
    }

    public Member memberToEntity(MemberDTO memberDTO, Name name, Address address) {
        Member memberEntity = new Member();
        memberEntity.setNameId(name);
        memberEntity.setAddressId(address);
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setMemberType(memberDTO.getMemberType());
        memberEntity.setPhoneNumber(memberDTO.getPhoneNumber());
        return memberEntity;
    }

    public abstract NameDTO entityToName(Name name);

    private String hashFullName(NameDTO nameDTO) {
        StringBuilder str = new StringBuilder();
        str.append(nameDTO.getFirstName());
        str.append(" ");
        str.append(nameDTO.getLastName());
        return DigestUtils.md5Hex(str.toString());
    }

    private String hashAddress(AddressDTO addressDTO) {
        StringBuilder str = new StringBuilder();
        str.append(addressDTO.getStreetAddress());
        str.append(" ");
        str.append(addressDTO.getZipCode());
        return DigestUtils.md5Hex(str.toString());
    }


}
