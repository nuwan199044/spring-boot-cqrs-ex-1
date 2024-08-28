package com.myapp.product_query_service.service;

import com.myapp.dto.ProductDTO;

import java.util.List;

public interface ProductQueryService {
    public List<ProductDTO> fetchProductList();
}
