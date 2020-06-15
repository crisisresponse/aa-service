package org.reciprocity.aaservice.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "names")
@Getter @Setter
public class Name implements Serializable {

    @Id
    @Column(name = "nm_surr_key", columnDefinition="CHAR(32)")
    public String namesId;

    @Column(name = "first_nm")
    public String firstName;

    @Column(name = "last_nm")
    public String lastName;

    @Column(name = "org_nm")
    public String orgName;

    @Column(name = "created_date")
    public LocalDate createdDate;

    @Column(name = "modified_date")
    public LocalDate modifiedDate;
}
