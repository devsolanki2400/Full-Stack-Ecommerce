package com.ecommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {  // Renamed for consistency
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;  // More descriptive

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategoryEntity category;  // Ensure related entity follows the naming pattern

    @Column(name = "sku", nullable = false, unique = true, length = 50)
    private String productSku;  // Improved clarity and added constraints

    @Column(name = "name", nullable = false, length = 100)
    private String productName;

    @Column(name = "description", length = 500)
    private String productDescription;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;  // Ensuring accuracy of financial values

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "units_in_stock", nullable = false)
    private int unitsInStock;

    @Column(name = "date_created", updatable = false)
    private LocalDateTime dateCreated;  // Changed to LocalDateTime for better precision

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
