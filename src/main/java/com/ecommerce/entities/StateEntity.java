package com.ecommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "state")
@Getter
@Setter
public class StateEntity {  // Renamed for consistency
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int stateId;  // Clearer naming

    @Column(name = "name", nullable = false, length = 100)
    private String stateName;  // Added constraints for integrity

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;  // Ensure consistency with renamed `CountryEntity`
}
