package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import java.net.URI;

public class Application {

    public static final String BASE_URI = "http://localhost:9090/api/";

    public static HttpServer startServer() {
        SwaggerConfig.configure();

        final ResourceConfig config = new ResourceConfig()
                .packages("org.example.resource")
                .register(ApiListingResource.class)
                .register(SwaggerSerializers.class)
                .property(ServerProperties.WADL_FEATURE_DISABLE, false);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }

    public static void main(String[] args) {
        try {
            final HttpServer server = startServer();

            System.out.println("============================================================");
            System.out.println(" Serveur REST démarré avec succès!");
            System.out.println(" URL de base: " + BASE_URI);
            System.out.println("============================================================");
            System.out.println("\n Endpoints disponibles:");
            System.out.println("  GET    " + BASE_URI + "products");
            System.out.println("  GET    " + BASE_URI + "products/{id}");
            System.out.println("  POST   " + BASE_URI + "products");
            System.out.println("  PUT    " + BASE_URI + "products/{id}");
            System.out.println("  DELETE " + BASE_URI + "products/{id}");
            System.out.println("  GET    " + BASE_URI + "products/search?q=...");
            System.out.println("  GET    " + BASE_URI + "products/count");
            System.out.println("  GET    " + BASE_URI + "application.wadl");
            System.out.println("\nAppuyez sur Entrée pour arrêter le serveur...");

            System.in.read();

            server.shutdownNow();
            System.out.println("\n Serveur arrêté.");

        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
//http://localhost:9090/api/application.wadl
     /* http://localhost:8080/api/products
        http://localhost:8080/api/products/1
        http://localhost:8080/api/products/count
        http://localhost:8080/api/products/search?q=samsung */