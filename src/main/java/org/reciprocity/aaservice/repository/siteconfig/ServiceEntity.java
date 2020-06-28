package org.reciprocity.aaservice.repository.siteconfig;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="services")
@Getter @Setter
public class ServiceEntity {

    @Id
    @GeneratedValue
    @Column(name="srvc_key")
    private Long serviceKey;

    @Column(name="srvc_nm")
    private String name;

    @Column(name="srvc_desc")
    private String description;

    //enum
    @Column(name="srvc_category")
    private String category;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//    CREATE TABLE IF NOT EXISTS ods_owner.services
//        (
//        srvc_key integer UNIQUE,
//        srvc_nm text,
//        srvc_desc text,
//        srvc_category text CHECK (srvc_category IN ('FOOD', 'VIRTUAL', 'SPECIAL', 'WAREHOUSE')),
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY (srvc_key)
//        );
