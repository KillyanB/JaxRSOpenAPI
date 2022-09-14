package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Patient extends User implements Serializable {

    public Patient() {

    }

    public Patient(String login, String pwd) {
        super(login, pwd);
    }
}
