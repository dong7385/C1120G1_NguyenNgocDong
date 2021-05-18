package com.test_module_4.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "date_request", columnDefinition = "date")
    private String dateRequest;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}