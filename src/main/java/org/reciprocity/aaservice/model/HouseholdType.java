package org.reciprocity.aaservice.model;


public enum HouseholdType {
    CHILD(1, "CHILD"),
    ADULT(2, "ADULT");

    public final Integer code;
    public final String displayName;

    HouseholdType(Integer code, String displayName){
        this.code = code;
        this.displayName = displayName;
    };
}
