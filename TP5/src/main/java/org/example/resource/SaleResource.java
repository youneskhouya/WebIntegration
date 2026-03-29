package org.example.resource;

import io.swagger.annotations.*;
import org.example.model.Sale;
import org.example.service.SaleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sales")
@Api(value = "/sales", tags = {"Sales"}, description = "API REST de gestion des ventes ElectroShop")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaleResource {

    private SaleService saleService = SaleService.getInstance();

    @GET
    @ApiOperation(value = "Lister toutes les ventes", notes = "Retourne la liste complète des ventes", response = Sale.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Liste des ventes récupérée avec succès")
    })
    public Response getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return Response.ok(sales).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Récupérer une vente par ID", notes = "Retourne une vente selon son identifiant", response = Sale.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vente trouvée"),
            @ApiResponse(code = 404, message = "Vente non trouvée")
    })
    public Response getSaleById(
            @ApiParam(value = "Identifiant de la vente", required = true)
            @PathParam("id") Long id) {

        Sale sale = saleService.getSaleById(id);
        if (sale == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Vente non trouvée\"}")
                    .build();
        }
        return Response.ok(sale).build();
    }

    @POST
    @ApiOperation(value = "Ajouter une vente", notes = "Crée une nouvelle vente et calcule automatiquement le total", response = Sale.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Vente créée avec succès"),
            @ApiResponse(code = 400, message = "Données invalides")
    })
    public Response addSale(Sale sale) {
        Sale created = saleService.addSale(sale);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Mettre à jour une vente", notes = "Modifie une vente existante", response = Sale.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vente mise à jour"),
            @ApiResponse(code = 404, message = "Vente non trouvée")
    })
    public Response updateSale(
            @ApiParam(value = "Identifiant de la vente", required = true)
            @PathParam("id") Long id,
            Sale sale) {

        Sale updated = saleService.updateSale(id, sale);
        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Vente non trouvée\"}")
                    .build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Supprimer une vente", notes = "Supprime une vente selon son identifiant")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Vente supprimée"),
            @ApiResponse(code = 404, message = "Vente non trouvée")
    })
    public Response deleteSale(
            @ApiParam(value = "Identifiant de la vente", required = true)
            @PathParam("id") Long id) {

        boolean deleted = saleService.deleteSale(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Vente non trouvée\"}")
                    .build();
        }
        return Response.ok("{\"message\":\"Vente supprimée avec succès\"}")
                .build();
    }

    @GET
    @Path("/count")
    @ApiOperation(value = "Compter les ventes", notes = "Retourne le nombre total des ventes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Nombre de ventes calculé")
    })
    public Response countSales() {
        int count = saleService.countSales();
        return Response.ok("{\"count\": " + count + "}").build();
    }
}
