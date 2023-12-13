package com.example.demo.ressource;


import com.example.demo.dao.UserDAO;
import com.example.demo.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/User")
public class UserRessource {
    private UserDAO UserDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        boolean createUser =UserDAO.create(user);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("User can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("User created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(User user) {
        if(user==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update User ").build();}
        else  {
            UserDAO.update(user);
            return Response.status(Response.Status.OK).entity("User updated").build();
        }}


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id) {
        if (id > 10) {
            return Response.status(Response.Status.NO_CONTENT).entity("Employee note send").build();
        }
        return Response.status(Response.Status.OK).entity("Employee was deleted").build();

    }
}