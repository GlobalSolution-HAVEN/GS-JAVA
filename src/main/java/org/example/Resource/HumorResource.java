package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Humor;
import org.example.Service.HumorService;

import java.util.List;

@Path("/humor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HumorResource {

    private HumorService service = new HumorService();

    @GET
    public Response listarTodos() {
        try {
            return Response.ok(service.listarTodos()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            Humor h = service.buscarPorId(id);
            return h != null ? Response.ok(h).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Humor humor) {
        try {
            service.cadastrar(humor);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Humor humor) {
        try {
            humor.setId(id);
            service.atualizar(humor);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE @Path("/{id}")
    public Response excluir(@PathParam("id") int id) {
        try {
            service.excluir(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
