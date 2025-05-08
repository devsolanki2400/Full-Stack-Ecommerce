package com.ecommerce.dao;

import com.ecommerce.entities.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategories", path = "product-categories")
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
