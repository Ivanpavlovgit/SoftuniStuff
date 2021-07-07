package Entity.UniversitySystemEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends User {
    private BigDecimal salary;
    private String email;
    private Set<Course> courses;

    public Teacher () {
    }

    @Column(name = "salary")
    public BigDecimal getPrice () {
        return this.salary;
    }

    public Teacher setPrice (BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    @Column(name = "email")
    public String getEmail () {
        return this.email;
    }

    public Teacher setEmail (String email) {
        this.email = email;
        return this;
    }
@OneToMany(mappedBy = "teacher")
    public Set<Course> getCourses () {
        return this.courses;
    }

    public Teacher setCourses (Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
