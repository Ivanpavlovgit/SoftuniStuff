package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicament")
public class Medicament extends BaseEntity {
    public Medicament () {
    }
}