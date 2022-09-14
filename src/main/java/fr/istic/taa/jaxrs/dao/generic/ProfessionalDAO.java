package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Professional;

public class ProfessionalDAO extends AbstractJpaDao<Long, Professional> {

    public ProfessionalDAO() {
        this.setClazz(Professional.class);
    }
}
