package com.myapp.product_query_service.controller;

import com.myapp.dto.ProductDTO;
import com.myapp.product_query_service.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/query")
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> fetchAllProducts() {
        return new ResponseEntity<>(productQueryService.fetchProductList(), HttpStatus.OK);
    }
}
