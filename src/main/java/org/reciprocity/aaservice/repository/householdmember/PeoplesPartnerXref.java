package org.reciprocity.aaservice.repository.householdmember;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="people_partners_xref")
@IdClass(PeoplesPartnerXref.class)
@Getter @Setter
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

