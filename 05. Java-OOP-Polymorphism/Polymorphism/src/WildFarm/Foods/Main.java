package WildFarm.Foods;

import WildFarm.Animals.*;
import WildFarm.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner      scanner    = new Scanner (System.in);
        String       line       = scanner.nextLine ();
        List<Animal> animalList = new ArrayList<> ();

        while (!line.equals ("End")) {
            String[] animalTokens = line.split ("\\s+");
            String[] foodTokens   = scanner.nextLine ().split ("\\s+");
            Animal   animal       = createAnimal (animalTokens);
            Food     food         = createFood (foodTokens);
            animal.makeSound ();
            try {
                animal.eat (food);
            } catch (IllegalArgumentException exception) {
                System.out.println (exception.getMessage ());
            }
            animalList.add (animal);
            line = scanner.nextLine ();
        }

        for (Animal animal : animalList) {
            System.out.println (animal.toString ());
        }
    }

    private static Food createFood (String[] foodTokens) {
        int quantity = Integer.parseInt (foodTokens[1]);
        return foodTokens[0].equals ("Meat")
                ? new Meat (quantity)
                : new Vegetable (quantity);
    }

    private static Animal createAnimal (String[] animalTokens) {
        switch (animalTokens[0]) {
            case "Mouse":
                return new Mouse
                        (animalTokens[1],"Mouse",
                                Double.parseDouble (animalTokens[2]),animalTokens[3]);

            case "Cat":
                return new Cat
                        (animalTokens[1],"Cat",
                                Double.parseDouble (animalTokens[2]),animalTokens[3],animalTokens[4]);

            case "Tiger":
                return new Tiger
                        (animalTokens[1],"Tiger",
                                Double.parseDouble (animalTokens[2]),animalTokens[3]);

            case "Zebra":
                return new Zebra
                        (animalTokens[1],"Zebra",
                                Double.parseDouble (animalTokens[2]),animalTokens[3]);

            default:
                throw new IllegalStateException ("Unknown animal type" + animalTokens[0]);
        }
    }
}
