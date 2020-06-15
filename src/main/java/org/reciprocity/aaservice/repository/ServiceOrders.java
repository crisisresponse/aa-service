package org.reciprocity.aaservice.repository;//package org.mycovidresponse.cmservice.repository.entity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="srvc_orders")
//public class ServiceOrders {
//
//    @GeneratedValue
//    @Id
//    @Column(name="srvc_order_key")
//    private Integer srvOrderKey;
//
//    @Id
//    @Column(name = "client_key", updatable = false, nullable = false)
//    private Integer clientKey;
//
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "client_key", referencedColumnName = "member_key")
//    private Members personInNeed;
//
//    @Id
//    @Column(name = "vol_key", updatable = false, nullable = false)
//    private Integer volunteerKey;
//
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "vol_key", referencedColumnName = "member_key")
//    private Members volunteerMember;
//
//    //enum
//    @Column(name="srvc_status")
//    private String srvcStatus;
//
//    //people change to members_vol_xref-ish
//    //new table to be created
//    //
//    @Column(name="suggested_vols")
//    @OneToMany
//    private People suggestedVolunteers;
//
//    private String description;
//
//    @Column(name="proj_fulfill_date")
//    private LocalDate projFillDate;
//
//    //
//    @Column(name="org_time_slot_key")
//    @OneToMany
//    private Object orgTimeSlotKey;
//
//    //Cutting block
//    @Column(name="fulfill_modality")
//    private String fullFillModality;
//
//    @Column(name="completed_date")
//    private LocalDate completedDate;
//
//    @Column(name="vol_completion_notes")
//    private String volunteerCompletionNotes;
//
//    @Column(name="created_date")
//    private LocalDate createdDate;
//
//    @Column(name="modified_date")
//    private LocalDate modifiedDate;
//}
//
////    CREATE TABLE IF NOT EXISTS ods_owner.srvc_orders
////        (
////        srvc_order_key integer UNIQUE,
////        client_key integer NOT NULL,
////        vol_key integer,
////        srvc_status text CHECK (srvc_status IN ('INCOMPLETE', 'NOTIFY', 'AWAITING RESPONSE', 'DECLINED', 'CONFIRMED', 'IN PROGRESS', 'COMPLETE')),
////        suggested_vols integer[],
////        description text,
////        proj_fulfill_date date,
////        org_timeslot_key integer,
////        fulfill_modality text,
////        completed_date date,
////        vol_completion_notes text,
////        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
////        PRIMARY KEY (srvc_order_key),
////
////        CONSTRAINT client_key_fk
////        FOREIGN KEY (client_key)
////        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT vol_key_fk
////        FOREIGN KEY (vol_key)
////        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
////
////        CONSTRAINT org_timeslot_key_fk
////        FOREIGN KEY (org_timeslot_key)
////        REFERENCES ods_owner.organization_srvc_time_cap(org_timeslot_key) ON DELETE SET NULL ON UPDATE CASCADE
////        );
////
////        --ALTER TABLE ods_owner.srvc_orders
////        --owner to ods_owner;
