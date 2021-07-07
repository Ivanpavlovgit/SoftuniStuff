package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private Set<Comment> comments;
    private Set<Medicament> medication;

    @OneToMany
    public Set<Medicament> getMedication () {
        return this.medication;
    }

    public Diagnose setMedication (Set<Medicament> medication) {
        this.medication = medication;
        return this;
    }


    @Column(name = "name", nullable = false, unique = true)
    public String getName () {
        return this.name;
    }

    public Diagnose setName (String name) {
        this.name = name;
        return this;
    }

    @OneToMany
    public Set<Comment> getComments () {
        return this.comments;
    }

    public Diagnose setComments (Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Diagnose () {
    }
}
