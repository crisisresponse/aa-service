package org.reciprocity.aaservice.form;

import org.apache.commons.codec.digest.DigestUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.*;
import org.reciprocity.aaservice.repository.Address;
import org.reciprocity.aaservice.repository.Member;
import org.reciprocity.aaservice.repository.Name;
import org.reciprocity.aaservice.repository.People;

@Mapper
public abstract class FormMapper {

    public static FormMapper MAPPER = Mappers.getMapper(FormMapper.class);

    public Name nameToEntity(MemberName memberName) {
        Name namesEntity = new Name();
        namesEntity.setFirstName(memberName.getFirstName());
        namesEntity.setLastName(memberName.getLastName());
        namesEntity.setNamesId(hashFullName(memberName));

        return namesEntity;
    }

    public Address addressToEntity(HeadHhAddress headHhAddress) {
        Address addressEntity = new Address();
        addressEntity.setStreetAddress(headHhAddress.getStreetAddress());
        addressEntity.setCity(headHhAddress.getCity());
        addressEntity.setState(headHhAddress.getState());
        addressEntity.setZipCode(headHhAddress.getZipCode());
        addressEntity.setAddressSurrKey(hashAddress(headHhAddress));

        return addressEntity;
    }

    public Member memberToEntity(HeadHhMember headHhMember, Name name, Address address) {
        Member memberEntity = new Member();
        memberEntity.setName(name);
        memberEntity.setAddress(address);
        memberEntity.setEmail(headHhMember.getEmail());
        memberEntity.setMemberType(headHhMember.getMemberType());
        memberEntity.setPhoneNumber(headHhMember.getPhoneNumber());
        return memberEntity;
    }

    public People peopleDtoToEntity(PersonalInfo personalInfo, Member member) {
        People peopleEntity = new People();
        peopleEntity.setMember(member);

        peopleEntity.setBirthdate(personalInfo.getBirthdate());
        peopleEntity.setGender(personalInfo.getGender());
        peopleEntity.setEmploymentStatus(personalInfo.getEmploymentStatus());
        peopleEntity.setTransportAvail(personalInfo.getTransportAvailability());
        peopleEntity.setLanguageSpoken(personalInfo.getLanguageSpoken());
        peopleEntity.setQualifications(personalInfo.getQualifications());
        peopleEntity.setFieldOfWork(personalInfo.getFieldOfWork());

        return peopleEntity;
    }

    public Member additionalMemberToEntity(AdultMember adultMember, Name name, Address address) {
        Member memberEntity = new Member();
        memberEntity.setName(name);
        memberEntity.setAddress(address);
        memberEntity.setEmail(adultMember.getEmail());
        memberEntity.setPhoneNumber(adultMember.getPhoneNumber());

        return memberEntity;
    }

    public People additionalPeopleToEntity(AdultMember adultMember, Member memberEntity, People headHousehold) {
        People peopleEntity = new People();

        peopleEntity.setMember(memberEntity);
        peopleEntity.setPrimaryContact(headHousehold.getMemberId());
        peopleEntity.setBirthdate(adultMember.getBirthDate());
        peopleEntity.setGender(adultMember.getGender());

        return peopleEntity;
    }

    public abstract MemberName entityToName(Name name);

    private String hashFullName(MemberName memberName) {
        StringBuilder str = new StringBuilder();
        str.append(memberName.getFirstName());
        str.append(" ");
        str.append(memberName.getLastName());
        return DigestUtils.md5Hex(str.toString());
    }

    private String hashAddress(HeadHhAddress headHhAddress) {
        StringBuilder str = new StringBuilder();
        str.append(headHhAddress.getStreetAddress());
        str.append(" ");
        str.append(headHhAddress.getZipCode());
        return DigestUtils.md5Hex(str.toString());
    }


}
