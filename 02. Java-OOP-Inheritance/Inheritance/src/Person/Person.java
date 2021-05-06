package Person;

public class Person {
    //must have String name,int age,Constructor(name,age),and getters for both.
    private String name;
    private int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge () {
        return this.age;
    }

    public String getName () {
        return this.name;
    }
}
