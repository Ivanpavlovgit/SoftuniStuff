package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {
    private Float avgGrade;
    private Integer attendance;
    private Set<Course> courses;
@ManyToMany(mappedBy = "students")
    public Set<Course> getCourses () {
        return this.courses;
    }

    public Student setCourses (Set<Course> courses) {
        this.courses = courses;
        return this;
    }

    public Student () {
    }

    @Column(name = "avg_grade")
    public Float getAvgGrade () {
        return this.avgGrade;
    }

    public Student setAvgGrade (Float avgGrade) {
        this.avgGrade = avgGrade;
        return this;
    }

    @Column(name = "attendance")
    public Integer getAttendance () {
        return this.attendance;
    }

    public Student setAttendance (Integer attendance) {
        this.attendance = attendance;
        return this;
    }
}
