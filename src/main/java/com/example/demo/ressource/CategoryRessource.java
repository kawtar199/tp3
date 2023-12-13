package com.example.demo.ressource;


import com.example.demo.dao.CategoryDAO;

import com.example.demo.entities.Category;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Category")
public class CategoryRessource {
    private CategoryDAO categoryDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) {
        boolean createCategory =categoryDAO.create(category);
        if(!createCategory) {
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
            categoryDAO.update(category);
            return Response.status(Response.Status.OK).entity("Category updated").build();
        }}

    @GET
    @Path("/GET/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCartByID(@PathParam("id") Integer id) {
        try {
            return categoryDAO.retrieveById(id.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") Integer id) {
        boolean deleteCart= categoryDAO.deleteById(id.toString());
        if (!deleteCart) {
            return Response.status(Response.Status.NO_CONTENT).entity("can not delete category").build();
        }
        return Response.status(Response.Status.OK).entity("cart was category").build();
    }
}