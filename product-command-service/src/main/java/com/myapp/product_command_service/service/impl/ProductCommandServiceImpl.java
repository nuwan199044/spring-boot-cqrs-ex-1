package com.myapp.product_command_service.service.impl;

import com.myapp.dto.ProductDTO;
import com.myapp.product_command_service.entity.Product;
import com.myapp.product_command_service.kafka.KafkaMessagePublisher;
import com.myapp.product_command_service.repository.ProductCommandRepository;
import com.myapp.product_command_service.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductCommandRepository productCommandRepository;
    private final ModelMapper modelMapper;
    private final KafkaMessagePublisher kafkaMessagePublisher;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productDTO.fromProductDTO();
        product.setProductCode(UUID.randomUUID());
        productDTO = modelMapper.map(productCommandRepository.save(product), ProductDTO.class);
        kafkaMessagePublisher.sendEventToTopic(productDTO);
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productDTO.fromProductDTO();
        productDTO = modelMapper.map(productCommandRepository.save(product), ProductDTO.class);
        kafkaMessagePublisher.sendEventToTopic(productDTO);
        return productDTO;
    }
}
