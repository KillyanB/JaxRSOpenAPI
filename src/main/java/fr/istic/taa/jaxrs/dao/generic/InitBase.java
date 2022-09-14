package fr.istic.taa.jaxrs.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import fr.istic.taa.jaxrs.domain.Patient;
import fr.istic.taa.jaxrs.domain.Professional;
import fr.istic.taa.jaxrs.domain.Appointment;

public class InitBase {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        try {
            int numOfProfessional = manager.createQuery("Select p From Professional p", Professional.class).getResultList().size();
            if (numOfProfessional == 0) {
                ArrayList<String> appointmentName = new ArrayList<String>();
                appointmentName.add("A1");
                appointmentName.add("A2");

                manager.persist(new Professional("admin", "admin", appointmentName));
                manager.persist(new Professional("user", "user", appointmentName));
            }

            int numOfPatient = manager.createQuery("Select pa From Patient pa", Patient.class).getResultList().size();
            if (numOfPatient == 0) {
                manager.persist(new Patient("user1", "pass1"));
                manager.persist(new Patient("user2", "pass2"));
                manager.persist(new Patient("user3", "pass3"));
            }

            List<Professional> resultListPro = manager.createQuery("Select p From Professional p", Professional.class).getResultList();
            for(Professional p : resultListPro) {
                manager.persist(new Appointment(p, 12, 35));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        manager.close();
    }
}
