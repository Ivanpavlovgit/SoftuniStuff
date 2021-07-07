package Entity.UniversitySystemEntities;
import Entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntity {
    //•	Student (id, first name, last name, phone number, average grade, attendance)
    private String firstName;
    private String lastName;
    private String phoneNumber;
@Column(name="fist_name")
    public String getFirstName () {
        return this.firstName;
    }

    public User setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Column(name="last_name")
    public String getLastName () {
        return this.lastName;
    }

    public User setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Column(name="phone_number")
    public String getPhoneNumber () {
        return this.phoneNumber;
    }

    public User setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
