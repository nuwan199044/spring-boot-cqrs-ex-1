package com.myapp.product_command_service.repository;

import com.myapp.product_command_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommandRepository extends JpaRepository<Product, Long> {
}
