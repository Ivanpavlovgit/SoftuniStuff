package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;
    private Patient patient;

    @ManyToOne()
    public Patient getPatient () {
        return this.patient;
    }

    public Visitation setPatient (Patient patient) {
        this.patient = patient;
        return this;
    }

    private Set<Comment> comments;

    @Column(name = "date_of_visit", nullable = false)
    public LocalDate getDate () {
        return this.date;
    }

    public Visitation setDate (LocalDate date) {
        this.date = date;
        return this;
    }

    @OneToMany
    public Set<Comment> getComments () {
        return this.comments;
    }

    public Visitation setComments (Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Visitation () {
    }
}
