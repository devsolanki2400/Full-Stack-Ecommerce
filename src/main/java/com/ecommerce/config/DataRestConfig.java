package com.ecommerce.config;

import com.ecommerce.entities.CountryEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.ProductCategoryEntity;
import com.ecommerce.entities.StateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer { // Renamed for better clarity

    private final EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // Disable HTTP methods for entities
        disableHttpMethods(ProductEntity.class, config, unsupportedActions);
        disableHttpMethods(ProductCategoryEntity.class, config, unsupportedActions);
        disableHttpMethods(CountryEntity.class, config, unsupportedActions);
        disableHttpMethods(StateEntity.class, config, unsupportedActions);

        exposeIds(config);
    }

    private void disableHttpMethods(Class<?> entityClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(entityClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // Retrieve all entity types from EntityManager and expose their IDs
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class<?>> entityClasses = entities.stream()
                .map(EntityType::getJavaType)
                .collect(Collectors.toList());

        config.exposeIdsFor(entityClasses.toArray(new Class[0]));
    }
}
