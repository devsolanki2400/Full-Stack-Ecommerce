package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class CountryEntity {  // Renamed for clarity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int countryId;  // Clearer naming

    @Column(name = "code", nullable = false, unique = true, length = 3)
    private String countryCode; // Added constraints for integrity

    @Column(name = "name", nullable = false, length = 100)
    private String countryName;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StateEntity> states; // Ensure State class matches
}
