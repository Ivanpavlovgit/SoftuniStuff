import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner      scanner      = new Scanner (System.in);
        StarsPrinter starsPrinter = new StarsPrinter (Integer.parseInt (scanner.nextLine ()));
        starsPrinter.printEntireRhombus ();

        DayOfWeek[] dnite = DayOfWeek.values ();
        // DayOfWeek.MONDAY.setDayNumber (9);

        for (DayOfWeek dayOfWeek : dnite) {
            System.out.println (dayOfWeek.getDayNumber () + " " + dayOfWeek.getDayName ());
        }
    }
}
