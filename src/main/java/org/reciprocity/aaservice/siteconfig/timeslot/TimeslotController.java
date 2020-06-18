package org.reciprocity.aaservice.siteconfig.timeslot;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.reciprocity.aaservice.model.TimeSlot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeslotController {

    @GetMapping(value="/timeslots")
    public ResponseEntity<List<TimeSlot>> getAllTimeSlots() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/timeslot")
    public ResponseEntity<String> createTimeSlot(@RequestBody TimeSlotRequest request) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
