package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.member.Name;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
public class AdditionalHouseMemberRequest {

    private UUID headOfHouseId;
    private AdditionalHouseMember additionalHouseMember;
}
