package org.reciprocity.aaservice.repository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter @Setter
public class Address {

    //Need to be saved first (concurrently with name)

    @Id
    @Column(name="addr_surr_key", columnDefinition="CHAR(32)")
    public String addressSurrKey;

    //Request payload needs to include an indictor for boolean 'permanent address'

    //Question about address are we combining street 1 and apt value
    @Column(name="street_addr", nullable = false)
    public String streetAddress;

    @Column(name="addr_city", nullable = false)
    public String city;

    //Validate transformer is uppercase
    @Column(name="addr_st_abbr", nullable = false)
    public String state;

    @Column(name="add_zipcode")
    public String zipCode;

    public float latitude;

    public float longitude;

    @Column(name="created_date")
    public LocalDate createdDate;

    @Column(name="modified_date")
    public LocalDate modifiedDate;
}
