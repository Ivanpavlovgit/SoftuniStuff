package WildFarm.Animals;

public class Cat extends Feline{
    private String breed;
    public Cat (String animalName,String animalType,double animalWeight,String livingRegion,String breed) {
        super (animalName,animalType,animalWeight,livingRegion);
        this.breed=breed;
    }

    @Override
    public void makeSound () {
        System.out.println ("Meowwww");
    }

    @Override
    public String toString () {
       StringBuilder baseClassToString=new StringBuilder ( super.toString ());
       baseClassToString.insert (baseClassToString.indexOf (",")+1,this.breed+",");
       return baseClassToString.toString ();

    }
}
