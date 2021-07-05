package Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer credits;
    private Set<Student> students;
    private Teacher teacher;

    @ManyToMany
    public Set<Student> getStudents () {
        return this.students;
    }

    public Course setStudents (Set<Student> students) {
        this.students = students;
        return this;
    }

    public Course () {
    }

    @Column(name = "name")
    public String getName () {
        return this.name;
    }

    public Course setName (String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description")
    public String getDescription () {
        return this.description;
    }

    public Course setDescription (String description) {
        this.description = description;
        return this;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate () {
        return this.startDate;
    }

    public Course setStartDate (LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Column(name = "end_date")
    public LocalDate getEndDate () {
        return this.endDate;
    }

    public Course setEndDate (LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Column(name = "credits")
    public Integer getCredits () {
        return this.credits;
    }

    public Course setCredits (Integer credits) {
        this.credits = credits;
        return this;
    }
@ManyToOne
    public Teacher getTeacher () {
        return this.teacher;
    }

    public Course setTeacher (Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
