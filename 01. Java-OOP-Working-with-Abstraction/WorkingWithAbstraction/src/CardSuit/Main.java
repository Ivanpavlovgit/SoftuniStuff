package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
//        System.out.println ("Card Ranks:");
////iterate through ranks
//        for (CardRank rank : CardRank.values ()) {
//            System.out.printf ("Ordinal value: %d; Name value: %s%n",rank.ordinal (),rank);
//        }

        //Read two lines of code
        //1st line = card rank
        //2nd line= card suite
        // assign the power values to he rank and suite and print the output in the specified format
        // Could be interesting with additional class Card(String rank,String Suit)->calculate total pwoer and have toString() method for the sum .
        // it is cleaner with Card();
        Scanner scanner         = new Scanner (System.in);
        String  rankInput       = scanner.nextLine ();
        String  suitInput       = scanner.nextLine ();
        Card    currentCard     = new Card (rankInput,suitInput);
     /*   int     inputRankPower  = CardRank.valueOf (rankInput).getPower ();
        int     inputSuitePower = CardSuits.valueOf (suitInput).getPower ();
        int     outputSum       = inputRankPower + inputSuitePower;

      //  System.out.printf ("Card name: %s of %s; Card power: %d",rankInput,suitInput,outputSum);*/
        System.out.println (currentCard);
    }
}
