package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Lembrete;
import org.example.Service.LembreteService;

@Path("/lembretes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LembreteResource {

    private LembreteService service = new LembreteService();

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
            Lembrete l = service.buscarPorId(id);
            return l != null ? Response.ok(l).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Lembrete lembrete) {
        try {
            service.cadastrar(lembrete);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Lembrete lembrete) {
        try {
            lembrete.setId(id);
            service.atualizar(lembrete);
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
