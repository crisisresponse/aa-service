package org.reciprocity.aaservice.form;

import org.apache.commons.codec.digest.DigestUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.model.*;
import org.reciprocity.aaservice.repository.member.Address;
import org.reciprocity.aaservice.repository.member.Member;
import org.reciprocity.aaservice.repository.member.Name;
import org.reciprocity.aaservice.repository.member.People;

import java.util.ArrayList;
import java.util.List;

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
        peopleEntity.setHouseholdSize(personalInfo.getHouseholdSize());

        return peopleEntity;
    }

    public Member additionalMemberToEntity(AdditionalHouseMember member, Name name, Address address) {
        Member memberEntity = new Member();
        memberEntity.setName(name);
        memberEntity.setAddress(address);
        memberEntity.setMemberType(member.getMemberType());

        if(member.getType().displayName.equalsIgnoreCase(AdditionalMemberType.ADULT.displayName)) {
            AdultMember adultMember = (AdultMember) member;
            memberEntity.setEmail(adultMember.getEmail());
            memberEntity.setPhoneNumber(adultMember.getPhoneNumber());
        }

        return memberEntity;
    }

    public People additionalPeopleToEntity(AdditionalHouseMember additionalMember, Member memberEntity, People headHousehold) {
        People peopleEntity = new People();

        peopleEntity.setMember(memberEntity);
        peopleEntity.setPrimaryContact(headHousehold);
        peopleEntity.setBirthdate(additionalMember.getBirthDate());
        peopleEntity.setGender(additionalMember.getGender());
        peopleEntity.setLanguageSpoken((List) new ArrayList<String>());

        if(additionalMember.getType().displayName.equalsIgnoreCase(AdditionalMemberType.CHILD.displayName)) {
            ChildMember childMember = (ChildMember) additionalMember;
            peopleEntity.setGrade(childMember.getGrade());
            peopleEntity.setSchool(childMember.getSchool());
        }


        return peopleEntity;
    }

    public Member additionalChildMemberToEntity(ChildMember childMember, Name name, Address address) {
        Member memberEntity = new Member();
        memberEntity.setName(name);
        memberEntity.setAddress(address);
        memberEntity.setMemberType(childMember.getMemberType());

        return memberEntity;
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
