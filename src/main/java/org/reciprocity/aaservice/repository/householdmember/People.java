package org.reciprocity.aaservice.repository.householdmember;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.util.StringListConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="people")
@Getter @Setter
public class People {

    //after members, names, addresses

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "member_key", updatable = false, nullable = false)
    private UUID memberKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_key", referencedColumnName = "member_key")
    private Member member;

    //yyyy-MM-dd
    //Doublcheck date formatting insert
    private LocalDate birthdate;

    private String gender;

    //create enum from request payload
    @Column(name="employment_status")
    private String employmentStatus;


    @Column(name="transportation_status")
    private String transportAvail;

    @Column(name="languages_spoke")
    @Convert(converter = StringListConverter.class)
    private List<String> languageSpoken;

    @Column(name="hh_size")
    private Integer householdSize;

    @Column(name="hh_members")
    @ElementCollection(targetClass = UUID.class)
    private List<UUID> householdMembers;

    @OneToOne
    @JoinColumn(name = "hh_primary_contact", referencedColumnName = "member_key")
    public People primaryContact;

    @OneToOne
    @JoinColumn(name="care_coordinator", referencedColumnName = "member_key")
    private Member careCoordinator;

    @Column(columnDefinition="VARCHAR(10)")
    private String grade;

    @Column(columnDefinition="VARCHAR(75)")
    private String school;

    //This is only for volunteers
    private String qualifications;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//    CREATE TABLE IF NOT EXISTS ods_owner.people
//        (
//        member_key integer,
//        birthdate date,
//        phone_nbr text,
//        email text,
//        gender text,
//        employment_status text,
//        transportation_status text,
//        languages_spoken text[],
//        hh_size integer,
//        hh_primary_contact integer,
//        case_mgr integer,
//        qualifications text,
//        field_of_work text,
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (member_key),
//
//        CONSTRAINT member_key_fk
//        FOREIGN KEY (member_key)
//        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT hh_prim_contact_fk
//        FOREIGN KEY (hh_primary_contact)
//        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT case_mgr_fk
//        FOREIGN KEY (case_mgr)
//        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );
