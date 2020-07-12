package org.reciprocity.aaservice.repository.householdmember;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="members")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_key")
    public UUID memberKey;

    @Column(name="member_type", nullable = false)
    public String memberType;

    //Clean up phone number to be 9 digits only (frontend)
    @Column(name="cell_phone_nbr")
    public String cellPhoneNumber;

    @Column(name="home_phone_nbr")
    public String homePhoneNumber;

    @Column(name="other_phone_nbr")
    public String otherPhoneNumber;

    @Email
    public String email;

    @OneToOne
    @JoinColumn(name = "nm_surr_key_fk", referencedColumnName = "nm_surr_key")
    public Name Name;

    @OneToOne
    @JoinColumn(name = "addr_surr_key_fk", referencedColumnName = "addr_surr_key")
    public Address address;

    @OneToOne
    @JoinColumn(name = "scnd_addr_surr_key", referencedColumnName = "addr_surr_key")
    public Address secondAddress;

    @Column(name="start_efctv_date")
    public LocalDate startEffectiveDate;

    @Column(name="end_efctv_date")
    public LocalDate endEffectiveDate;

    @Column(name="created_date")
    public LocalDate createdDate;

    @Column(name="modified_date")
    public LocalDate modifiedDate;

}
