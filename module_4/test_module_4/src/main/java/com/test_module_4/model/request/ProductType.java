package com.test_module_4.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;
    @Column(name = "product_type_name", length = 45)
    private String productTypeName;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    List<Product> productList;
}
