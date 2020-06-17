package org.reciprocity.aaservice.model;


public enum HouseholdType {
    CHILD(1, "Child"),
    ADULT(2, "Adult");

    public final Integer code;
    public final String displayName;

    HouseholdType(Integer code, String displayName){
        this.code = code;
        this.displayName = displayName;
    };
}
