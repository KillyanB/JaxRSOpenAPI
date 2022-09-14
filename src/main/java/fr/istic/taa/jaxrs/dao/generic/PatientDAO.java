package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Patient;

public class PatientDAO extends AbstractJpaDao<Long, Patient> {

    public PatientDAO() {
        this.setClazz(Patient.class);
    }
}
