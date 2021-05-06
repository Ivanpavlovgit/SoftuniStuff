package GreedyTimes;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner  scanner       = new Scanner (System.in);
        long     capacityOfBag = Long.parseLong (scanner.nextLine ());
        String[] input         = scanner.nextLine ().split ("\\s+");

        // var torba = new LinkedHashMap<String, LinkedHashMap<String, Long>> ();
        /*old variables
        long zlato   = 0;
        long kamuni  = 0;
        long mangizi = 0;*/
        Bag bag = new Bag (capacityOfBag);
        for (int i = 0; i < input.length; i += 2) {
            String itemName = input[i];
            long   quantity = Long.parseLong (input[i + 1]);
            if (itemName.length () == 3) {
                //put money in the bag
                bag.addCash (itemName,quantity);
            } else if (itemName.toLowerCase ().endsWith ("gem")) {
                //put gem in the bag
                bag.addGems (itemName,quantity);
            } else if (itemName.toLowerCase ().equals ("gold")) {
                //add gold found
                bag.addGold (quantity);
            }
//Switch case for the money in gem
            /*switch (kvoE) {
                case "Gem":
                    if (!torba.containsKey (kvoE)) {
                        if (torba.containsKey ("Gold")) {
                            if (itemWeight > torba.get ("Gold").values ().stream ().mapToLong (e -> e).sum ()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get (kvoE).values ().stream ().mapToLong (e -> e).sum () + itemWeight > torba.get ("Gold").values ().stream ().mapToLong (e -> e).sum ()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!torba.containsKey (kvoE)) {
                        if (torba.containsKey ("Gem")) {
                            if (itemWeight > torba.get ("Gold").values ().stream ().mapToLong (e -> e).sum ()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get (kvoE).values ().stream ().mapToLong (e -> e).sum () + itemWeight > torba.get ("Gem").values ().stream ().mapToLong (e -> e).sum ()) {
                        continue;
                    }
                    break;
            }*/
        }
            System.out.print (bag.toString ());
    }
}