package org.reciprocity.aaservice.repository.organization;

import org.reciprocity.aaservice.repository.organization.Organizations;
import org.reciprocity.aaservice.repository.siteconfig.AvailabilityTimeslots;
import org.reciprocity.aaservice.repository.siteconfig.AvailableService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="organization_srvc_time_cap")
public class OrganizationServiceTimeCap {

    //PRIMARY KEY (org_timeslot_key, srvc_key),
    //Double check this is setup correctly

    @GeneratedValue
    @Id
    @Column(name="org_timeslot_key")
    private Long orgTimeSlotId;

    //replace
    @OneToOne
    @JoinColumn(name="srvc_key", referencedColumnName = "srvc_key")
    private AvailableService serviceKey;

    @OneToOne
    @JoinColumn(name = "organization_key", referencedColumnName = "member_key")
    private Organizations members;

    @OneToOne
    @JoinColumn(name="timeslot_key", referencedColumnName = "timeslot_key")
    private AvailabilityTimeslots timeSlotKey;

    @Column(name="timeslot_capacity")
    private Integer timeSlotCapacity;

    @Column(name="start_efctv_date")
    private LocalDate startEffectiveDate;

    @Column(name="end_efctv_date")
    private LocalDate endEffectiveDate;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;

}
