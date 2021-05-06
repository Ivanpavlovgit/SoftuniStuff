import java.util.Scanner;

public class testo {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
//first half
        printTop (n);
//        for (int j = 0; j < n - r; j++) {
//            System.out.print (" ");
//        }
//        for (int i = 0; i < r; i++) {
//            System.out.print ("* ");
//        }
//        System.out.println ();
//
////second half
        printBottom (n);
//        for (int r = 1; r <= n - 1; r++) {
//            for (int j = 0; j < r; j++) {
//                System.out.print (" ");
//            }
//            for (int i = 0; i < n - r; i++) {
//                System.out.print ("* ");
//            }
//            System.out.println ();
//        }
    }

    private static void printBottom (int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
            printString (i," ");
            printString (rowsCount-i,"* ");
            System.out.println ();
        }
    }

    public static void printTop (int rowsCount) {
        for (int i = 1; i <= rowsCount; i++) {
//            printPaddingSpaces (rowsCount - i);
//            printStars (i);
            printString (rowsCount - i," ");
            printString (i,"* ");
            System.out.println ();
        }
    }

    //    private static void printStars (int starsCount) {
//        for (int i = 0; i < starsCount; i++) {
//            System.out.print ("* ");
//        }
//    }
//
//    private static void printPaddingSpaces (int countSpaces) {
//        for (int i = 0; i < countSpaces; i++) {
//            System.out.print (" ");
//        }
//    }
    private static void printString (int count,String string) {
        for (int i = 0; i < count; i++) {
            System.out.print (string);
        }
    }
}
