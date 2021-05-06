package animals;

public class Animal {
    private String name;

    public String getName () {
        return this.name;
    }

    public int getAge () {
        return this.age;
    }

    public String getGender () {
        return this.gender.getAsString ();
    }

    private int age;
    private Gender gender;

    public Animal (String name,int age,Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected String produceSound () {
        return "";
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
        sb
                .append (this.getClass ().getSimpleName ()+" ")
                .append (System.lineSeparator ())
                .append (getName () + " " + getAge () + " " + this.gender.getAsString ())
                .append (System.lineSeparator ())
                .append (this.produceSound ())
                .append (System.lineSeparator ());
        return sb.toString ().trim ();
    }

}
