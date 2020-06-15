package org.reciprocity.aaservice.repository;//package org.mycovidresponse.cmservice.repository.entity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Table(name="people")
//public class People {
//
//    //after members, names, addresses
//
//    @Id
//    @Column(name = "member_key", updatable = false, nullable = false)
//    private Integer memberId;
//
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "member_key", referencedColumnName = "member_key")
//    private Members members;
//
//    //yyyy-MM-dd
//    //Doublcheck date formatting insert
//    private LocalDate birthdate;
//
//    private String gender;
//
//    //create enum from request payload
//    @Column(name="employment_status")
//    private String employmentStatus;
//
//
//    @Column(name="transportation_status")
//    private String transportAvail;
//
//    @Column(name="languages_spoke")
//    private List<String> languageSpoken;
//
//    @Column(name="hh_size")
//    private Integer householdSize;
//
//    //If you are the primary contact than this column is null
//    @Column(name="hh_primary_contact")
//    @ManyToOne
//    private People primaryContact;
//
//    @Column(name="aid_assistant")
//    @ManyToOne
//    private People aidAssistant;
//
//    private String qualifications;
//
//    //may not get used
//    @Column(name="field_of_work")
//    private String fieldOfWork;
//
//    @Column(name="created_date")
//    private LocalDate createdDate;
//
//    @Column(name="modified_date")
//    private LocalDate modifiedDate;
//}
//
////    CREATE TABLE IF NOT EXISTS ods_owner.people
////        (
////        member_key integer,
////        birthdate date,
////        phone_nbr text,
////        email text,
////        gender text,
////        employment_status text,
////        transportation_status text,
////        languages_spoken text[],
////        hh_size integer,
////        hh_primary_contact integer,
////        case_mgr integer,
////        qualifications text,
////        field_of_work text,
////        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        PRIMARY KEY (member_key),
////
////        CONSTRAINT member_key_fk
////        FOREIGN KEY (member_key)
////        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT hh_prim_contact_fk
////        FOREIGN KEY (hh_primary_contact)
////        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT case_mgr_fk
////        FOREIGN KEY (case_mgr)
////        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE
////        );