package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.AdditionalAdultHouseMemberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseholdMemberController {

    private HouseholdMemberService householdMemberService;

    private HouseholdMemberController(HouseholdMemberService householdMemberService) {
        this.householdMemberService = householdMemberService;
    }


    @PostMapping(value="/householdmember")
    public ResponseEntity<String> addAdditionalHouseholdMember(@RequestBody AdditionalAdultHouseMemberRequest request) {
        householdMemberService.saveHouseholdMember(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
