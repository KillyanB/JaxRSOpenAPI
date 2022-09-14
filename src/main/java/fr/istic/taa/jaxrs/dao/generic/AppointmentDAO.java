package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Appointment;

public class AppointmentDAO extends AbstractJpaDao<Long, Appointment>{

    public AppointmentDAO() {
        this.setClazz(Appointment.class);
    }
}
