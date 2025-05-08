package com.ecommerce.dao;

import com.ecommerce.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;

@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Retrieves products by category ID with pagination
    Page<ProductEntity> findByCategory_CategoryId(@Param("id") Long categoryId, Pageable pageable);

    // Retrieves products whose name contains the given string, with pagination
    Page<ProductEntity> findByProductNameContaining(@Param("name") String name, Pageable pageable);
}
