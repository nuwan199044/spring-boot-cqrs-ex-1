package com.myapp.product_query_service.repository;

import com.myapp.product_query_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<Product, Long> {
}
