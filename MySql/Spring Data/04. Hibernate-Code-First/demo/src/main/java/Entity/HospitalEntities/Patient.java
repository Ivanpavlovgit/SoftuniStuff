package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private String pictureUrl;
    private Boolean hasMedicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;

    @ManyToMany
    public Set<Diagnose> getDiagnoses () {
        return this.diagnoses;
    }

    public Patient setDiagnoses (Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
        return this;
    }

    @OneToMany(mappedBy = "patient")
    public Set<Visitation> getVisitations () {
        return this.visitations;
    }

    public Patient setVisitations (Set<Visitation> visitations) {
        this.visitations = visitations;
        return this;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName () {
        return this.firstName;
    }

    public Patient setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName () {
        return this.lastName;
    }

    public Patient setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    public String getAddress () {
        return this.address;
    }

    public Patient setAddress (String address) {
        this.address = address;
        return this;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail () {
        return this.email;
    }

    public Patient setEmail (String email) {
        this.email = email;
        return this;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate getDateOfBirth () {
        return this.dateOfBirth;
    }

    public Patient setDateOfBirth (LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Column(name = "pictire_Url", nullable = true, unique = true)
    public String getPictureUrl () {
        return this.pictureUrl;
    }

    public Patient setPictureUrl (String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    @Column(name = "is_insured", nullable = false)
    public Boolean getHasMedicalInsurance () {
        return this.hasMedicalInsurance;
    }

    public Patient setHasMedicalInsurance (Boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
        return this;
    }

    public Patient () {
    }
}
