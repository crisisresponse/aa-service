package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.HeadOfHouseHoldRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class HeadOfHouseholdController {

    @GetMapping(value="/headOfHousehold/{orgId}")
    public ResponseEntity<List<String>> getHeadOfHouseholds(@PathVariable UUID orgId) {
        return null;
    }

    @PutMapping(value="/headOfHousehold")
    public ResponseEntity<String> updateHeadOfHousehold(@RequestBody HeadOfHouseHoldRequest request ) {
        return null;
    }
}
