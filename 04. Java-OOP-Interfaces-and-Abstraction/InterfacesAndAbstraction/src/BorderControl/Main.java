package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();
//put all id-objects under one Identifiable interface:
//        List<Citizen> citizens = new ArrayList<> ();
//        List<Robot>   robots   = new ArrayList<> ();

        List<Identifiable> identifiables=new ArrayList<> ();


        while (!input.equalsIgnoreCase ("End")) {

            String[] tokens = input.split ("\\s+");
            if (tokens.length == 3) {
                //read citizen and add to the list
                identifiables.add (new Citizen (tokens[0],Integer.parseInt (tokens[1]),tokens[2]));

            } else {
                //read robot and add to list
                identifiables.add (new Robot (tokens[0],tokens[1]));
            }
            input = scanner.nextLine ();
        }
        String postFixId = scanner.nextLine ();
        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId ().endsWith (postFixId)){
                System.out.println (identifiable.getId ());
            }
        }
    }
}
