package com.myapp.product_query_service.service;

import com.myapp.dto.ProductDTO;
import com.myapp.product_query_service.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductQueryRepository productQueryRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ProductDTO> fetchProductList() {
        return productQueryRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
    }
}
