package org.reciprocity.aaservice.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.siteconfig.AvailableService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="srvc_orders_line_item")
@Getter @Setter
public class ServiceOrderLineItem {

    @Id
    @Setter(AccessLevel.NONE)
    @Column(name = "srvc_order_key", updatable = false, nullable = false)
    private Long serviceOrderKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "srvc_order_key", referencedColumnName = "srvc_order_key")
    private ServiceOrders serviceOrders;

    @OneToOne
    @JoinColumn(name = "srvc_key", referencedColumnName = "srvc_key")
    private AvailableService services;

    @Column(name="srvc_quantity")
    private Integer quantity;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}

//    CREATE TABLE IF NOT EXISTS ods_owner.srvc_orders_line_item
//        (
//        srvc_order_key integer NOT NULL,
//        srvc_key integer NOT NULL,
//        srvc_quantity integer NOT NULL,
//        created_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        modified_date timestamp without time zone NOT NULL DEFAULT NOW(),
//        PRIMARY KEY(srvc_order_key, srvc_key),
//
//        CONSTRAINT srvc_order_key_fk
//        FOREIGN KEY (srvc_order_key)
//        REFERENCES ods_owner.srvc_orders(srvc_order_key) ON DELETE SET NULL ON UPDATE CASCADE,
//
//        CONSTRAINT srvc_key_fk
//        FOREIGN KEY (srvc_key)
//        REFERENCES ods_owner.services(srvc_key) ON DELETE SET NULL ON UPDATE CASCADE
//        );