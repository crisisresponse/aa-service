package org.reciprocity.aaservice.communitymember;

import org.reciprocity.aaservice.model.NameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityMemberInfoController {

    @PutMapping(value="/name")
    public ResponseEntity<String> updateCommunityMemberName(@RequestBody NameRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
