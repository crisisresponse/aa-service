package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.AdditionalHouseMemberRequest;
import org.reciprocity.aaservice.repository.householdmember.People;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class HouseholdMemberController {

    private HouseholdMemberService householdMemberService;

    private HouseholdMemberController(HouseholdMemberService householdMemberService) {
        this.householdMemberService = householdMemberService;
    }

    @GetMapping(value="/householdmembers/{headHouseholdId}")
    public ResponseEntity<List<People>> retrieveHouseMembers(@PathVariable UUID headHouseholdId) {
        return new ResponseEntity<>(householdMemberService.getAllHouseholdMembers(headHouseholdId), HttpStatus.OK);
    }


    @PostMapping(value="/householdmember")
    public ResponseEntity<String> addAdditionalHouseholdMember(@RequestBody AdditionalHouseMemberRequest request) {
        householdMemberService.saveHouseholdMember(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/householdmember/{memberId}")
    public ResponseEntity<String> updateHouseholdMember(@PathVariable UUID memberId,
                                                        @RequestBody AdditionalHouseMemberRequest request) {
        householdMemberService.updateHouseholdMember(memberId, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
