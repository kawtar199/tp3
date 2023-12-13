package com.example.demo.ressource;


import com.example.demo.dao.ProductDAO;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Product")
public class ProductRessource {
    private ProductDAO productDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        boolean createProduct =productDAO.create(product);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("Product can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("Product created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) {
        if(product==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update Product ").build();}
        else  {
            productDAO.update(product);
            return Response.status(Response.Status.OK).entity("Product updated").build();
        }}

    @GET
    @Path("/GET/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getCartByID(@PathParam("id") Integer id) {
        try {
            return productDAO.retrieveById(id.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") Integer id) {
        boolean deleteCart= productDAO.deleteById(id.toString());
        if (!deleteCart) {
            return Response.status(Response.Status.NO_CONTENT).entity("can not delete cart").build();
        }
        return Response.status(Response.Status.OK).entity("cart was deleted").build();
    }
}