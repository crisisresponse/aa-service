package org.reciprocity.aaservice.repository.member;
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
    @Setter(AccessLevel.NONE)
    @Column(name="member_key")
    public UUID memberId;

    @Column(name="member_type", nullable = false)
    public String memberType;

    //Clean up phone number to be 9 digits only (frontend)
    @Column(name="phone_nbr")
    public String phoneNumber;

    @Email
    public String email;

    @OneToOne
    @JoinColumn(name = "nm_surr_key_fk", referencedColumnName = "nm_surr_key")
    public org.reciprocity.aaservice.repository.member.Name Name;

    @OneToOne
    @JoinColumn(name = "addr_surr_key_fk", referencedColumnName = "addr_surr_key")
    public Address address;

    @Column(name="created_date")
    public LocalDate createdDate;

    @Column(name="modified_date")
    public LocalDate modifiedDate;

}

//    CREATE TABLE IF NOT EXISTS ods_owner.members
//        (
//        member_key integer UNIQUE,
//        member_type text CHECK (member_type IN ('PER', 'ORG', 'WH')),
//        nm_surr_key integer NOT NULL,
//        addr_surr_key integer NOT NULL,
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (member_key),
//
//        CONSTRAINT nm_surr_key_fk
//        FOREIGN KEY (nm_surr_key)
//        REFERENCES ods_owner.names(nm_surr_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT addr_surr_key_fk
//        FOREIGN KEY (addr_surr_key)
//        REFERENCES ods_owner.addresses(addr_surr_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );
