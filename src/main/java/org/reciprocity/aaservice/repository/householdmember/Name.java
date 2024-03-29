package org.reciprocity.aaservice.repository.householdmember;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "names")
@Getter @Setter
public class Name implements Serializable {

    @Id
    @Column(name = "nm_surr_key", columnDefinition="VARCHAR(32)")
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
