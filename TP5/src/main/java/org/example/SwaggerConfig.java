package org.example;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig {
    public static void configure() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("ElectroShop Sales API");
        beanConfig.setDescription("Documentation Swagger de l’API REST de gestion des ventes");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9090");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("org.example.resource");
        beanConfig.setScan(true);
    }
}