package com.ecommerce.dao;

import com.ecommerce.entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateRepository extends JpaRepository<StateEntity, Integer> {

    // Search endpoint: http://localhost:8081/api/states/search/findByCountryCode?code=IN
    List<StateEntity> findByCountry_CountryCode(@Param("code") String code);  // Updated to match entity naming
}
