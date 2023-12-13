package com.example.demo.ressource;


import com.example.demo.dao.CountryDAO;

import com.example.demo.entities.Country;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/Country")
public class CountryRessource {
    private CountryDAO countryDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCountry(Country country) {
        boolean createCountry =countryDAO.create(country);
        if(false) {
            return Response.status(Response.Status.NO_CONTENT).entity("Country can not be created").build();
        }else{
            return Response.status(Response.Status.CREATED).entity("Country created").build();
        }}

    @PUT
    @Path("/UPDATE/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCountry(Country country) {
        if(country==null){
            return Response.status(Response.Status.NO_CONTENT).entity("can not update Country ").build();}
        else  {
            countryDAO.update(country);
            return Response.status(Response.Status.OK).entity("Country updated").build();
        }}

    @GET
    @Path("/GET/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryByID(@PathParam("id") Integer id) {
        try {
            return countryDAO.retrieveById(id.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCountry(@PathParam("id") Integer id) {
        boolean deleteCart= countryDAO.deleteById(id.toString());
        if (!deleteCart) {
            return Response.status(Response.Status.NO_CONTENT).entity("can not delete country").build();
        }
        return Response.status(Response.Status.OK).entity("cart was country").build();
    }}

