package org.reciprocity.aaservice.repository.orders;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.reciprocity.aaservice.repository.siteconfig.Services;

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
    private Services services;

    @Column(name="srvc_quantity")
    private Integer quantity;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}