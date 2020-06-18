package org.reciprocity.aaservice.repository;

import lombok.AccessLevel;
import lombok.Setter;
import org.reciprocity.aaservice.repository.member.People;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="people_partners_xref")
@IdClass(PeoplesPartnerXref.class)
public class PeoplesPartnerXref implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "person_key", updatable = false, nullable = false)
    private UUID peopleKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_key", referencedColumnName = "member_key")
    private People people;

    @Id
    @Column(name="organization_key", nullable = false)
    public Integer orgKey;

    @Column(name="primary_partner_ind", nullable = false)
    public String primaryPartnerFlag;

    @Column(name="created_date")
    public LocalDate createdDate;

    @Column(name="modified_date")
    public LocalDate modifiedDate;
}

//    CREATE TABLE IF NOT EXISTS ods_owner.people_partners_xref
//        (
//        person_key integer,
//        organization_key integer,
//        primary_partner_ind text CHECK (primary_partner_ind IN ('Y', 'N')),
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (person_key, organization_key),
//
//        CONSTRAINT person_key_fk
//        FOREIGN KEY (person_key)
//        REFERENCES ods_owner.people(member_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT organization_key_fk
//        FOREIGN KEY (organization_key)
//        REFERENCES ods_owner.organizations(member_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );

