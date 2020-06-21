package org.reciprocity.aaservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdultMember.class, name = "ADULT"),
        @JsonSubTypes.Type(value = ChildMember.class, name = "CHILD")
})
public class AdditionalHouseMember {

    private AdditionalMemberType type;
    private MemberName additionalMemberName;
    private String memberType;
    private LocalDate birthDate;
    private String gender;
    private String specificNeeds;
}
