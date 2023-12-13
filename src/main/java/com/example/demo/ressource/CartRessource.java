package com.example.demo.ressource;

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
            if(false) {
                return Response.status(Response.Status.NO_CONTENT).entity("cart can not be created").build();
            }else{
            return Response.status(Response.Status.CREATED).entity("cart created").build();
        }}

        @PUT
        @Path("/UPDATE/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateEmployee(Cart cart) {
            if(cart==null){
                return Response.status(Response.Status.NO_CONTENT).entity("can not update cart ").build();}
            else  {
                cartDAO.update(cart);
            return Response.status(Response.Status.OK).entity("cart updated").build();
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