package Animal;

import java.util.List;

public class Main {
    public static void main (String[] args) {
List<Animal> animals =List.of(new Wolf (),new Goat (),new Snake ());
        for (Animal animal : animals) {
            animal.eat ();
        }
    }
}
