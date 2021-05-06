package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ();

        List<Birthable> birthables = new ArrayList<> ();
        while (!input.equals ("End")) {
            String[] info = input.split ("\\s+");
            switch (info[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen (info[1],Integer.parseInt (info[2]),info[3],info[4]);
                    birthables.add (citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet (info[1],info[2]);
                    birthables.add (pet);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine ();
        }
        String yearToCheck = scanner.nextLine ();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate ().endsWith (yearToCheck)) {
                System.out.println (birthable.getBirthDate ());
            }
        }
    }
}
