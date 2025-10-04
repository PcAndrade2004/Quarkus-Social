package br.com.pauloCesar.controller;

import br.com.pauloCesar.entity.UserEntity;
import br.com.pauloCesar.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @POST
    public Response novoUsuario(@Valid UserEntity user) {
        return Response.status(Response.Status.CREATED).entity(service.novoUsuario(user)).build();
    }

    @GET
    public Response listarUsuarios(@QueryParam("page") @DefaultValue("0") int page,
                                   @QueryParam("size") @DefaultValue("10") int size) {
        return Response.ok(service.listarUsuarios(page, size)).build();
    }

    @GET
    @Path("/{usuarioId}")
    public Response buscarUsuarioId(@PathParam("usuarioId") UUID usuarioId) {
        return Response.ok(service.buscarUsuarioId(usuarioId)).build();
    }

    @PUT
    @Path("/{usuarioId}")
    public Response atualizarUsuario(@PathParam("usuarioId") UUID usuarioId, @Valid UserEntity userEntity) {
        return Response.ok(service.atualizarUsuario(usuarioId, userEntity)).build();
    }

    @DELETE
    @Path("/{usuarioId}")
    public Response deletarUsuario(@PathParam("usuarioId") UUID usuarioId) {
        service.deletarUsuario(usuarioId);
        return Response.noContent().build();
    }



}
