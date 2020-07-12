package org.reciprocity.aaservice.repository.householdmember;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.siteconfig.Services;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="people_role_xref")
@Getter @Setter
public class PeopleRoleXref {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "member_key", updatable = false, nullable = false)
    private UUID memberKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_key", referencedColumnName = "member_key")
    private People people;

    @Column(name="person_role")
    private String personRole;

    //enum active + inactive
    @Column(name="person_role_status")
    private String personRoleStatus;

    @Column(name="start_efctv_date")
    public LocalDate startEffectiveDate;

    @Column(name="end_efctv_date")
    public LocalDate endEffectiveDate;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}
