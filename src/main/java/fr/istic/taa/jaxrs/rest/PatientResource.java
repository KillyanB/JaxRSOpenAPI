package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.PatientDAO;
import fr.istic.taa.jaxrs.domain.Patient;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/patient")
@Produces({"application/json", "application/xml"})
public class PatientResource {

    PatientDAO dao = new PatientDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("id") Long patientId) {
        return dao.findOne(patientId);
    }

}
