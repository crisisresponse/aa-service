package org.reciprocity.aaservice.model;


public enum AdditionalMemberType {
    CHILD(1, "CHILD"),
    ADULT(2, "ADULT");

    public final Integer code;
    public final String displayName;

    AdditionalMemberType(Integer code, String displayName){
        this.code = code;
        this.displayName = displayName;
    };
}
