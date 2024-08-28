package com.myapp.product_command_service.kafka;

import com.myapp.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessagePublisher {

    private final KafkaTemplate<String,Object> template;

    public void sendEventToTopic(ProductDTO productDTO) {
        try {
            CompletableFuture<SendResult<String, Object>> customerTopic = template.send("order-topic", productDTO);
            customerTopic.whenComplete((result, exception)->{
                if (exception == null) {
                    System.out.println("Sent product=["+productDTO.toString()+ "] with offset=[ "+result.getRecordMetadata().offset()+" ]");
                } else {
                    System.out.println("Unable to send product=["+productDTO.toString()+ "] due to: "+exception.getMessage());
                }
            });
        } catch(Exception ex) {
            log.error("ERROR {} ",ex.getMessage());
        }
    }
}
