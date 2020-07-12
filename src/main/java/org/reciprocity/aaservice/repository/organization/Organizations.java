package org.reciprocity.aaservice.repository.organization;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.householdmember.Member;
import org.reciprocity.aaservice.repository.householdmember.People;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="organizations")
@Getter @Setter
public class Organizations implements Serializable {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "member_key", updatable = false, nullable = false)
    private UUID memberKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "member_key", referencedColumnName = "member_key")
    private Member member;

    //Enum
    @Column(name="organization_type")
    private String organizationType;

    @Column(name="organization_desc")
    private String organizationDesc;

    @OneToOne
    @JoinColumn(name="primary_contact", referencedColumnName = "member_key")
    private People primaryContact;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}
