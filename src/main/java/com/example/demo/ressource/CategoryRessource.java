package com.example.demo.ressource;

import com.example.demo.dao.ActionDAO;
import com.example.demo.entities.Category;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Category")
public class CategoryRessource {
    private ActionDAO actionDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) {
        boolean createCategory =actionDAO.create(category);
        if(createCategory=false) {
            return Response.status(Response.Status.NO_CONTENT).entity("Category can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("Category created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Category category) {
        if(category==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update Category ").build();}
        else  {
            actionDAO.update(category);
            return Response.status(Response.Status.OK).entity("Category updated").build();
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