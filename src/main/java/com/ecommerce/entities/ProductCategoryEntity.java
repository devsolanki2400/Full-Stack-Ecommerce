package com.ecommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Getter
@Setter
public class ProductCategoryEntity {  // Renamed for consistency
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;  // Clearer naming for readability

    @Column(name = "category_name", nullable = false, unique = true, length = 100)
    private String categoryName;  // Added constraints for integrity

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    private Set<ProductEntity> products;  // Ensure related entity follows naming consistency
}
