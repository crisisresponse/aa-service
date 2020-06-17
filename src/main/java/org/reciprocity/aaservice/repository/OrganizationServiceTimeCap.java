package org.reciprocity.aaservice.repository;//package org.mycovidresponse.cmservice.repository.entity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="organization_srvc_time_cap")
//public class OrganizationServiceTimeCap {
//
//    //PRIMARY KEY (org_timeslot_key, srvc_key),
//    //Double check this is setup correctly
//
//    @GeneratedValue
//    @Id
//    @Column(name="org_timeslot_key")
//    private Integer orgTimeSlotId;
//
//    //replace
//    @ManyToOne
//    @Column(name="srvc_key")
//    private AvailableService serviceKey;
//
//    @Id
//    @Column(name = "organization_key", updatable = false, nullable = false)
//    private Integer memberId;
//
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "organization_key", referencedColumnName = "member_key")
//    private Organizations members;
//
//    @ManyToOne
//    @Column(name="timeslot_key")
//    private AvailabilityTimeslots timeslotKey;
//
//    //
//    @Column(name="timeslot_capacity")
//    private Integer timeSlotCapacity;
//
//    @Column(name="start_efctv_date")
//    private LocalDate startEffectiveDate;
//
//    @Column(name="end_efctv_date")
//    private LocalDate endEffectiveDate;
//
//    @Column(name="created_date")
//    private LocalDate createdDate;
//
//    @Column(name="modified_date")
//    private LocalDate modifiedDate;
//
//}
//
////    CREATE TABLE IF NOT EXISTS ods_owner.organization_srvc_time_cap
////        (
////        org_timeslot_key integer UNIQUE,
////        srvc_key integer,
////        organization_key integer NOT NULL,
////        timeslot_key integer NOT NULL,
////        timeslot_type text NOT NULL,
////        timeslot_capacity integer NOT NULL,
////        start_efctv_date date NOT NULL,
////        end_efctv_date date NOT NULL,
////        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        PRIMARY KEY (org_timeslot_key, srvc_key),
////
////        CONSTRAINT organization_key_fk
////        FOREIGN KEY (organization_key)
////        REFERENCES ods_owner.organizations(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT srvc_key_fk
////        FOREIGN KEY (srvc_key)
////        REFERENCES ods_owner.services(srvc_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT timeslot_key_fk
////        FOREIGN KEY (timeslot_key, timeslot_type)
////        REFERENCES ods_owner.availability_timeslots(timeslot_key, timeslot_type) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT timeslot_type_chk CHECK (timeslot_type = 'WAREHOUSE')
////        );
