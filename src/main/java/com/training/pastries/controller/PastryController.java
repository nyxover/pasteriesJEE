package com.training.pastries.controller;

import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.entity.Pastry;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/pastries")
public class PastryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        PastryDao dao = DaoFactory.getPastryDao();
        List<Pastry> pastries = dao.getAll();

        return Response
                .status(Response.Status.OK)
                .entity(pastries)
                .build();
    }

     // READ
    @GET
    @Path("/{idParam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("idParam") Long idSearched) {
        PastryDao dao = DaoFactory.getPastryDao();
        Optional<Pastry> pastryOpt = dao.get(idSearched);

        if(pastryOpt.isEmpty()){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(pastryOpt.get())
                .build();
    }

    // CREATE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPastry(Pastry pastry){

       PastryDao dao = DaoFactory.getPastryDao();
       Pastry pastryCreated = dao.save(pastry);

        return Response
                .status(Response.Status.CREATED)
                .entity(pastryCreated)
                .build();
    }

    @PUT
    @Path("/{idParam}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePastry(@PathParam("idParam") Long idSearched, Pastry pastry) {
        PastryDao dao = DaoFactory.getPastryDao();
        Optional<Pastry> pastryOpt = dao.get(idSearched);
        if (pastryOpt.isEmpty()) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        Pastry pastryUpdated = dao.update(pastry);
        return Response
                .status(Response.Status.OK)
                .entity(pastryUpdated)
                .build();
    }

    @DELETE
    @Path("/{idParam}")
    public Response deletePastry(@PathParam("idParam")Long idSearched) {
        PastryDao dao = DaoFactory.getPastryDao();
        Optional<Pastry> pastryOpt = dao.get(idSearched);
        if (pastryOpt.isPresent()) {
            dao.delete(pastryOpt.get());
        }

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }




}
