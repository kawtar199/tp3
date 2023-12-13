package com.example.demo.ressource;


import com.example.demo.dao.CountryDAO;
import com.example.demo.entities.Country;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Country")
public class CountryRessource {
    private CountryDAO CountryDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCountry(Country country) {
        boolean createCountry =CountryDAO.create(country);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("Country can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("Country created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Country country) {
        if(country==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update Country ").build();}
        else  {
            CountryDAO.update(country);
            return Response.status(Response.Status.OK).entity("Country updated").build();
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