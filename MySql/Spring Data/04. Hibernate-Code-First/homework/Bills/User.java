package Entity.Bills;

import Entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
@Column(name="fist_name",nullable = false)
    public String getFirstName () {
        return this.firstName;
    }

    public User setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Column(name="last_name",nullable = false)
    public String getLastName () {
        return this.lastName;
    }

    public User setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Column(name="password",nullable = false)
    public String getPassword () {
        return this.password;
    }

    public User setPassword (String password) {
        this.password = password;
        return this;
    }
    @Column(name="email",nullable = false,unique = true)
    public String getEmail () {
        return this.email;
    }

    public User setEmail (String email) {
        this.email = email;
        return this;
    }



    public User () {
    }
}
