package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.AdditionalHouseMemberRequest;
import org.reciprocity.aaservice.model.AdditionalHouseMemberResponse;
import org.reciprocity.aaservice.repository.member.People;

import java.util.List;
import java.util.UUID;


public interface HouseholdMemberService {

    List<People> getAllHouseholdMembers(UUID headHouseholdId);
    void saveHouseholdMember(AdditionalHouseMemberRequest request);
}
