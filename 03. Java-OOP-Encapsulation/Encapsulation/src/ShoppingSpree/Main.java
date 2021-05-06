package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {


        Scanner scanner = new Scanner (System.in);

        Map<String, Person>  people;
        Map<String, Product> products;
        try {
            people = getPeopleList (scanner);
            products = getProductList (scanner);
        } catch (IllegalArgumentException ex) {
            System.out.println (ex.getMessage ());
            return;
        }

        String input = scanner.nextLine ();
        while (!input.equals ("END")) {
            String[] tokens = input.split ("\\s+");

            String person  = tokens[0];
            String product = tokens[1];
            buyProduct (people,products,person,product);

            input = scanner.nextLine ();
        }
//        for(
//    Person person :people)
//
//    {
//        System.out.println (person.toString ());
//    }
        for (Person person : people.values ()
        ) {
            System.out.println (person.toString ());
        }
    }

    private static void buyProduct (Map<String, Person> people,Map<String, Product> products,String person,String product) {
        //            for (Person p : people) {
//                if (p.getName ().equals (person)) {
        try {

//                        Product productToBuy = products.stream ()
//                                .filter (prod -> prod.getName ().equals (product))
//                                .findFirst ()
//                                .orElseThrow (Exception::new);
//                        p.buyProduct (productToBuy);
            people.get (person).buyProduct (products.get (product));

            System.out.println (person + " bought " + product);
        } catch (IllegalArgumentException exc) {
            System.out.println (exc.getMessage ());
        }
    }


    private static Map<String, Person> getPeopleList (Scanner scanner) {

        String[] tokens = scanner.nextLine ().split (";");

        Map<String, Person> people = new LinkedHashMap<> ();

        for (String token : tokens) {
            String[] personInfo = token.split ("=");

            Person person = new Person (personInfo[0],Double.parseDouble (personInfo[1]));

            people.put (person.getName (),person);
        }
        return people;
    }


    private static Map<String, Product> getProductList (Scanner scanner) {
        String[] tokens = scanner.nextLine ().split (";");

        Map<String, Product> people = new LinkedHashMap<> ();

        for (String token : tokens) {
            String[] personInfo = token.split ("=");

            Product person = new Product (personInfo[0],Double.parseDouble (personInfo[1]));

            people.put (person.getName (),person);
        }
        return people;
    }
}