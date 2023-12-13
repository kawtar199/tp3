package com.example.demo.ressource;


import com.example.demo.dao.CityDAO;
import com.example.demo.entities.City;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/City")
public class CityRessource {
    private CityDAO cityDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCity(City city) {
        boolean createCity =cityDAO.create(city);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("City can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("City created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(City city) {
        if(city==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update City ").build();}
        else  {
            cityDAO.update(city);
            return Response.status(Response.Status.OK).entity("City updated").build();
        }}

    @GET
    @Path("/GET/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public City getCartByID(@PathParam("id") Integer id) {
        try {
            return cityDAO.retrieveById(id.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id") Integer id) {
        boolean deleteCart= cityDAO.deleteById(id.toString());
        if (!deleteCart) {
            return Response.status(Response.Status.NO_CONTENT).entity("can not delete city").build();
        }
        return Response.status(Response.Status.OK).entity("city was deleted").build();
    }
}