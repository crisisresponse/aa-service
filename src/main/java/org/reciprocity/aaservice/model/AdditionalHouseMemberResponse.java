package org.reciprocity.aaservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AdditionalHouseMemberResponse {

    List<AdditionalHouseMember> houseMembers = new ArrayList<>();
}
