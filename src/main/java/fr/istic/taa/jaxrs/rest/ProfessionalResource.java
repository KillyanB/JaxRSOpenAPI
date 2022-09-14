package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.AppointmentDAO;
import fr.istic.taa.jaxrs.dao.generic.ProfessionalDAO;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.Professional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/professional")
@Produces({"application/json", "application/xml"})
public class ProfessionalResource {

    ProfessionalDAO professionalDAO = new ProfessionalDAO();
    AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professional getProfessionalById(@PathParam("id") Long professionalId) {
        return professionalDAO.findOne(professionalId);
    }

    @GET
    @Path("/appointment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointmentReserved(@PathParam("id") Long id) {
        List<Appointment> res = new ArrayList<Appointment>();

        for(Appointment a : appointmentDAO.findAll()) {
            if (a.getProfessional().getId().equals(id)) {
                System.out.println(id);
                res.add(a);
            }
        }

        return res;
    }
}