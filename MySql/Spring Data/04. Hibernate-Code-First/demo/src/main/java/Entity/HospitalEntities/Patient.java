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
    private String picture;
    private Boolean isInsured;

    @OneToMany
    public Set<Visitation> getVisitations () {
        return this.visitations;
    }

    public Patient setVisitations (Set<Visitation> visitations) {
        this.visitations = visitations;
        return this;
    }

    private Set<Visitation> visitations;


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

    @Column(name = "address", nullable = false)
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

    @Column(name = "picture_url", nullable = true, unique = true)
    public String getPicture () {
        return this.picture;
    }

    public Patient setPicture (String picture) {
        this.picture = picture;
        return this;
    }

    @Column(name = "has_insurance", nullable = false)
    public Boolean getInsured () {
        return this.isInsured;
    }

    public Patient setInsured (Boolean insured) {
        isInsured = insured;
        return this;
    }

    public Patient () {
    }
}
