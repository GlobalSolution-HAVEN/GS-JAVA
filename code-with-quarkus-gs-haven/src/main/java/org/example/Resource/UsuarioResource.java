package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Usuario;
import org.example.Service.UsuarioService;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioService service = new UsuarioService();

    @GET
    public Response listarTodos() {
        try {
            List<Usuario> usuarios = service.listarTodos();
            return Response.ok(usuarios).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            Usuario u = service.buscarPorId(id);
            return u != null ? Response.ok(u).build() : Response.status(404).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Usuario usuario) {
        try {
            service.cadastrar(usuario);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Usuario usuario) {
        try {
            usuario.setId(id);
            service.atualizar(usuario);
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
