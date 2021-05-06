package WildFarm.Animals;

import WildFarm.Foods.Food;
import WildFarm.Foods.Meat;

public class Zebra extends Mammal{
    public Zebra (String animalName,String animalType,double animalWeight,String livingRegion) {
        super (animalName,animalType,animalWeight,livingRegion);
    }
    @Override
    public void eat (Food food) {
        if(food instanceof Meat){
            try {
                throw new IllegalAccessException ("Zebras are not eating that type of food!");
            } catch (IllegalAccessException e) {
                e.printStackTrace ();
            }
        }
        super.eat (food);
    }
    @Override
    public void makeSound () {
        System.out.println ("Zs");
    }
}
