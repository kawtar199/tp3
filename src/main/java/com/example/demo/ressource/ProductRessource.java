package com.example.demo.ressource;


import com.example.demo.dao.ProductDAO;
import com.example.demo.entities.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Product")
public class ProductRessource {
    private ProductDAO ProductDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        boolean createProduct =ProductDAO.create(product);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("Product can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("Product created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Product product) {
        if(product==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update Product ").build();}
        else  {
            ProductDAO.update(product);
            return Response.status(Response.Status.OK).entity("Product updated").build();
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