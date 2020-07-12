package org.reciprocity.aaservice.repository.siteconfig;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.organization.Organizations;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name="resources_available")
public class ResourcesAvailable {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "member_key", updatable = false, nullable = false)
    private UUID orgKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "provider_key", referencedColumnName = "member_key")
    private Organizations org;

    @OneToOne
    @JoinColumn(name = "srvc_key", referencedColumnName = "srvc_key")
    private Services services;

    @OneToOne
    @JoinColumn(name = "timeslot_key", referencedColumnName = "timeslot_key")
    private AvailabilityTimeslots availabilityTimeslots;

    //Enum PUBLIC or PRIVATE
    @Column(name="resource_type")
    private String resourceType;

    @Column(name="resource_desc")
    private String resourceDesc;

    @Column(name="start_efctv_date")
    public LocalDate startEffectiveDate;

    @Column(name="end_efctv_date")
    public LocalDate endEffectiveDate;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//(
//        provider_key bigint,
//        srvc_key bigint,
//        timeslot_key bigint,
//        resource_type VARCHAR(10) CHECK (resource_type IN ('PUBLIC', 'PRIVATE')),
//        resource_desc VARCHAR(255),
//        resource_restrictions VARCHAR(100)[],
//        start_efctv_date date,
//        end_efctv_date date,
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (provider_key, srvc_key, timeslot_key),
//
//        CONSTRAINT provider_key_fk
//        FOREIGN KEY (provider_key)
//        REFERENCES ods_owner.organizations(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT srvc_key_fk
//        FOREIGN KEY (srvc_key)
//        REFERENCES ods_owner.services(srvc_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );
