package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.AppointmentDAO;
import fr.istic.taa.jaxrs.dao.generic.PatientDAO;
import fr.istic.taa.jaxrs.dao.generic.ProfessionalDAO;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/appointment")
@Produces({"application/json", "application/xml"})
public class AppointmentResource {

    AppointmentDAO appointmentDAO = new AppointmentDAO();
    ProfessionalDAO professionalDAO = new ProfessionalDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("id") Long appointmentId) {
        return appointmentDAO.findOne(appointmentId);
    }

    @POST
    @Path("/create/{id}/{date}/{duration}")
    public void createAppointment(@PathParam("id") Long professionalId, @PathParam("date") int dateAppointment, @PathParam("duration") int durationAppointment) {
        if(professionalDAO.findOne(professionalId) != null) {
            appointmentDAO.save(new Appointment(professionalDAO.findOne(professionalId), dateAppointment, durationAppointment));
        }
    }
}