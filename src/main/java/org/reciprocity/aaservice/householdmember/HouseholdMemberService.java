package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.AdditionalHouseMemberRequest;
import org.reciprocity.aaservice.repository.householdmember.People;

import java.util.List;
import java.util.UUID;


public interface HouseholdMemberService {

    List<People> getAllHouseholdMembers(UUID headHouseholdId);
    void saveHouseholdMember(AdditionalHouseMemberRequest request);
    void updateHouseholdMember(UUID memberId, AdditionalHouseMemberRequest request);
}
