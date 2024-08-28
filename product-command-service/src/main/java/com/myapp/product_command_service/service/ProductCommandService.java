package com.myapp.product_command_service.service;

import com.myapp.dto.ProductDTO;

public interface ProductCommandService {
    public ProductDTO createProduct(ProductDTO productDTO);

    public ProductDTO updateProduct(ProductDTO productDTO);
}
