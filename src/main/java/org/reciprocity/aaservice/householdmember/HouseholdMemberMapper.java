package org.reciprocity.aaservice.householdmember;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.model.PeoplePartnerXrefRequest;
import org.reciprocity.aaservice.repository.householdmember.People;
import org.reciprocity.aaservice.repository.householdmember.PeoplesPartnerXref;

@Mapper
public abstract class HouseholdMemberMapper {


    public static HouseholdMemberMapper MAPPER = Mappers.getMapper(HouseholdMemberMapper.class);

    public  PeoplesPartnerXref peoplesPartnerXrefToEntity(PeoplePartnerXrefRequest request, People person) {
        PeoplesPartnerXref peoplesPartnerXref = new PeoplesPartnerXref();

        peoplesPartnerXref.setPeople(person);
        peoplesPartnerXref.setOrgKey(request.getOrgKey());
        peoplesPartnerXref.setPrimaryPartnerFlag(request.getPrimaryOrg());

        return peoplesPartnerXref;
    };


}
