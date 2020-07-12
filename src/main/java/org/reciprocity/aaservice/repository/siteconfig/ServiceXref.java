package org.reciprocity.aaservice.repository.siteconfig;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.householdmember.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="services_xref")
@Getter @Setter
public class ServiceXref {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "requested_srvc_key", updatable = false, nullable = false)
    private Long requestedServiceKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "requested_srvc_key", referencedColumnName = "srvc_key")
    private Services requestedServices;

    @OneToOne
    @JoinColumn(name = "provided_srvc_key", referencedColumnName = "srvc_key")
    private Services providedServices;

    @Column(name="start_efctv_date")
    public LocalDate startEffectiveDate;

    @Column(name="end_efctv_date")
    public LocalDate endEffectiveDate;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}
