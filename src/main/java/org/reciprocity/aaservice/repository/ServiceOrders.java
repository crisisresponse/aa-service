package org.reciprocity.aaservice.repository;

import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.member.Member;
import org.reciprocity.aaservice.repository.member.People;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="srvc_orders")
@Getter @Setter
public class ServiceOrders {

    @GeneratedValue
    @Id
    @Column(name="srvc_order_key")
    private Long srvOrderKey;

    @OneToOne
    @JoinColumn(name = "client_key", referencedColumnName = "member_key")
    private Member personInNeed;

    @OneToOne
    @JoinColumn(name = "vol_key", referencedColumnName = "member_key")
    private Member volunteerMember;

    //enum
    @Column(name="srvc_status")
    private String srvcStatus;

    //people change to members_vol_xref-ish
    //new table to be created
    
    @Column(name="suggested_vols")
    @OneToMany
    private List<People> suggestedVolunteers;

    private String description;

    @Column(name="proj_fulfill_date")
    private LocalDate projFillDate;

    
    @Column(name="org_timeslot_key_fk")
    @OneToMany
    private List<OrganizationServiceTimeCap> orgTimeSlotKey;

    //Cutting block
    @Column(name="fulfill_modality")
    private String fullFillModality;

    @Column(name="completed_date")
    private LocalDate completedDate;

    @Column(name="vol_completion_notes")
    private String volunteerCompletionNotes;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//(
//        srvc_order_key bigint UNIQUE,
//        client_key bigint NOT NULL,
//        vol_key bigint,
//        srvc_status VARCHAR(20) CHECK (srvc_status IN ('INCOMPLETE', 'NOTIFY', 'AWAITING RESPONSE', 'DECLINED', 'CONFIRMED', 'IN PROGRESS', 'COMPLETE')),
//        description VARCHAR(255),
//        proj_fulfill_date date,
//        org_timeslot_key bigint,
//        fulfill_modality VARCHAR(40),
//        completed_date date,
//        vol_completion_notes VARCHAR(255),
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (srvc_order_key),
//
//        CONSTRAINT client_key_fk
//        FOREIGN KEY (client_key)
//        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT vol_key_fk
//        FOREIGN KEY (vol_key)
//        REFERENCES ods_owner.members(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT org_timeslot_key_fk
//        FOREIGN KEY (org_timeslot_key)
//        REFERENCES ods_owner.organization_srvc_time_cap(org_timeslot_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );
