package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;

    @OneToMany
    public Set<Diagnose> getDiagnoses () {
        return this.diagnoses;
    }

    public Visitation setDiagnoses (Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
        return this;
    }

    private Set<Diagnose> diagnoses;

    @Column(name = "date", nullable = false)
    public LocalDate getDate () {
        return this.date;
    }

    public Visitation setDate (LocalDate date) {
        this.date = date;
        return this;
    }


    public Visitation () {
    }
}
