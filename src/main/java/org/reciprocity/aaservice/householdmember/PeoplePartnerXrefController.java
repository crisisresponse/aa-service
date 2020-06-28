package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.PeoplePartnerXrefRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeoplePartnerXrefController {

    @PostMapping(value="/people/partner_xref")
    public ResponseEntity<String> createPeopleAndOrgRelationship(@RequestBody PeoplePartnerXrefRequest request) {
        return null;
    }
}
