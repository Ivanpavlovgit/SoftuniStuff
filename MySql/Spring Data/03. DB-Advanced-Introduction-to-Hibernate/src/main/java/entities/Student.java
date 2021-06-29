package entities;

public class Student {
    private int id;
    private String name;

    public Student() {
    }
    // Getters and setters


    public int getId () {
        return this.id;
    }

    public Student setId (int id) {
        this.id = id;
        return this;
    }

    public String getName () {
        return this.name;
    }

    public Student setName (String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString () {
        return "My name is Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
