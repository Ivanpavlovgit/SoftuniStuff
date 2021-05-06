package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {


        Scanner scanner = new Scanner (System.in);
        //  int[]     coordinates = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        Point     a         = getPoint (scanner);
        Point     c         = getPoint (scanner);

        Rectangle rectangle = new Rectangle (a,c);
//go to next row because you use nextInt in getPoint() method
        scanner.nextLine ();
        int n = Integer.parseInt (scanner.nextLine ());

        while (n-- > 0) {
            Point pointToCheck = getPoint (scanner);
            System.out.println (rectangle.contains (pointToCheck));
        }
    }

    private static Point getPoint (Scanner scanner) {


        return new Point (scanner.nextInt (),scanner.nextInt ());
    }

}

//  private static Point getPoint (Scanner scanner) {
//        int[] coordinates;
//        coordinates = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
//        return new Point (coordinates[0],coordinates[1]);
//    }
//}