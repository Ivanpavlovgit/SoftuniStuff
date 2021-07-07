package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicament")
public class Medicament extends BaseEntity {
    private String name;

    @Column(name = "name", nullable = false, unique = true)
    public String getName () {
        return this.name;
    }

    public Medicament setName (String name) {
        this.name = name;
        return this;
    }

    public Medicament () {
    }
}