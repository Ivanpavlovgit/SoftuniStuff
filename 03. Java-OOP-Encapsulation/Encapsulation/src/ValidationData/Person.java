package ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person (String firstName,String lastName,int age,double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge (age);
        this.setSalary (salary);
    }
//setters must be normaly -private
    public void setLastName (String lastName) {
        if(lastName.length ()<3){
            throw new IllegalArgumentException ("Last name cannot be less than 3 symbols");
        }
        this.lastName=lastName;
    }

    public void setFirstName (String firstName) {
        if(firstName.length ()<3){
            throw new IllegalArgumentException ("First name cannot be less than 3 symbols");
        }
        this.firstName=firstName;
    }


    public void setAge (int age) {
        if (age <= 0) {
            throw new IllegalArgumentException ("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary (double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }
        this.salary = this.salary * (1 + bonus / 100);
    }

    private void setSalary (double salary) {
        if (salary <= 460) {
            throw new IllegalArgumentException ("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public int getAge () {
        return this.age;
    }

    public double getSalary () {
        return this.salary;
    }

    @Override
    public String toString () {
        return String.format ("%s %s gets %.2f leva.",this.getFirstName (),this.getLastName (),this.getSalary ());
    }
}
