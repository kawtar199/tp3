package com.example.demo.ressource;


import com.example.demo.dao.CityDAO;
import com.example.demo.entities.City;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/City")
public class CityRessource {
    private CityDAO CityDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCity(City city) {
        boolean createCity =CityDAO.create(city);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("City can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("City created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(City city) {
        if(city==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update City ").build();}
        else  {
            CityDAO.update(city);
            return Response.status(Response.Status.OK).entity("City updated").build();
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