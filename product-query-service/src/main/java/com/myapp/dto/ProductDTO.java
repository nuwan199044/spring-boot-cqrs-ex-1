package com.myapp.dto;


import com.myapp.product_query_service.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private UUID productCode;
    private String name;
    private Double price;

    public Product fromProductDTO() {
        return Product.builder()
                .productCode(productCode)
                .name(name)
                .price(price)
                .build();
    }
}
