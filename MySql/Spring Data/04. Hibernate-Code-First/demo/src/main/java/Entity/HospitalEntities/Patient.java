package Entity.HospitalEntities;
import Entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    public Patient () {
    }
}
