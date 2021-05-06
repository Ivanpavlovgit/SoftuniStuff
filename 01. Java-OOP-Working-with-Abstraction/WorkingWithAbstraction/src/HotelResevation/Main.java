package HotelResevation;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] data = scanner.nextLine ().split ("\\s+");

        double   pricePerDay = Double.parseDouble (data[0]);
        int      days        = Integer.parseInt (data[1]);
        Season   season      = Season.valueOf (data[2].toUpperCase ());
        Discount discount    = Discount.valueOf (data[3].toUpperCase ());

        PriceCalculator calculator = new PriceCalculator (season,discount,pricePerDay,days);

        System.out.printf ("%.2f",calculator.calculatePrice ());
    }
}
