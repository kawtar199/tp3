package com.example.demo.ressource;

import com.example.demo.dao.ActionDAO;
import com.example.demo.dao.CartDAO;
import com.example.demo.entities.Cart;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Cart")
public class CartRessource {
private CartDAO cartDAO;


        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response createCart(Cart cart) {
        boolean createCart =cartDAO.create(cart);
            if(!createCart) {
                return Response.status(Response.Status.NO_CONTENT).entity("cart can not be created").build();
            }else{
            return Response.status(Response.Status.CREATED).entity("cart created").build();
        }}

        @PUT
        @Path("/UPDATE/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateCart(Cart cart) {
            if(cart==null){
                return Response.status(Response.Status.NO_CONTENT).entity("can not update cart ").build();}
            else  {
                cartDAO.update(cart);
            return Response.status(Response.Status.OK).entity("cart updated").build();
        }}


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCart(@PathParam("id") Integer id) {
            boolean deleteCart= cartDAO.deleteById(id.toString());
        if (!deleteCart) {
            return Response.status(Response.Status.NO_CONTENT).entity("can not delete cart").build();
        }
        return Response.status(Response.Status.OK).entity("cart was deleted").build();
    }
}