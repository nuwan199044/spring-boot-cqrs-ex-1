package com.myapp.product_query_service.kafka;

import com.myapp.dto.ProductDTO;
import com.myapp.product_query_service.entity.Product;
import com.myapp.product_query_service.repository.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final ProductQueryRepository productQueryRepository;
    private final ModelMapper modelMapper;

    @KafkaListener(topics = "order-topic", groupId = "product-group")
    public void consume(ProductDTO productDTO) {
        log.info("consumer consume the product {} ",productDTO.toString());
        Product product = modelMapper.map(productDTO, Product.class);
        productQueryRepository.save(product);
    }

}
