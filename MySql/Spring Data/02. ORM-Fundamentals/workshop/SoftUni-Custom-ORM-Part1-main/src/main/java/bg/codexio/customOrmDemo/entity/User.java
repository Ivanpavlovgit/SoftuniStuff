package bg.codexio.customOrmDemo.entity;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.time.LocalDate;

@Entity(tableName = "users")
public class User {
    @Id
    private int id;
    @Column(name = "username", columnDefinition = "VARCHAR(100)")
    private String userName;
    @Column(name = "age", columnDefinition = "INT")
    private int age;
    @Column(name = "registration", columnDefinition = "DATE")
    private LocalDate registration;

    public User () {
    }



    public int getId () {
        return this.id;
    }

    public User setId (int id) {
        this.id = id;
        return this;
    }

    public String getUserName () {
        return this.userName;
    }

    public User setUserName (String userName) {
        this.userName = userName;
        return this;
    }

    public int getAge () {
        return this.age;
    }

    public User setAge (int age) {
        this.age = age;
        return this;
    }

    public LocalDate getRegistration () {
        return this.registration;
    }

    public User setRegistration (LocalDate registration) {
        this.registration = registration;
        return this;
    }
}
