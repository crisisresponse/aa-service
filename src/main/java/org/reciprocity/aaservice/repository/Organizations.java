package org.reciprocity.aaservice.repository;//package org.mycovidresponse.cmservice.repository.entity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="organizations")
//public class Organizations {
//
//    //After people
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
//    //Enum
//    @Column(name="organization_type")
//    private String organizationType;
//
//    @Column(name="organization_desc")
//    private String organizationDesc;
//
//    @Id
//    @Column(name = "primary_contact", updatable = false, nullable = false)
//    private Integer primaryContact;
//
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "primary_contact", referencedColumnName = "member_key")
//    private People peopleContact;
//
//    @Column(name="created_date")
//    private LocalDate createdDate;
//
//    @Column(name="modified_date")
//    private LocalDate modifiedDate;
//}
//
////    CREATE TABLE IF NOT EXISTS ods_owner.organizations
////        (
////        member_key integer,
////        organization_type text CHECK (organization_type in ('NETWORK PARTNER', 'WAREHOUSE')),
////        organization_desc text NOT NULL,
////        primary_contact integer NOT NULL,
////        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        PRIMARY KEY (member_key),
////
////        CONSTRAINT member_key_fk
////        FOREIGN KEY (member_key)
////        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT contact_person_fk
////        FOREIGN KEY (primary_contact)
////        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE
////        );