package harvestingFields;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


import java.util.*;
import java.util.List;

public class Main {
    public static void main (String[] args) throws ClassNotFoundException, IOException {
        long  startTime  = System.currentTimeMillis ();
        Class fatherLand = Class.forName ("harvestingFields.RichSoilLand");

        List<Field> fields    = Arrays.asList (fatherLand.getDeclaredFields ());
        String      inputPath = "C:\\Users\\Asus\\Desktop\\InputForProgramsFromIntelliJ.txt";

        FileReader     myReader     = new FileReader (inputPath);
        BufferedReader buffMyReader = new BufferedReader (myReader);


        String input = buffMyReader.readLine ();

        StringBuilder sb = new StringBuilder ();
        while (!input.equals ("HARVEST")) {
            String modifier = input;
            fields
                    .stream ()
                    .filter (field -> Modifier.toString (
                            field.getModifiers ()).equals (modifier) || modifier.equals ("all"))
                    .forEach (field ->
                            sb.append (String.format (
                                    "%s %s %s%n",
                                    Modifier.toString (field.getModifiers ()),
                                    field.getType ().getSimpleName (),
                                    field.getName ())));

            input = buffMyReader.readLine ();

        }
        myReader.close ();
        String output     = sb.toString ().trim ();
        String outputPath = "C:\\Users\\Asus\\Desktop\\OutputForProgramsFromIntelliJ.txt";
        try {
            FileWriter myWriter = new FileWriter (outputPath);
            myWriter.write (output);
            myWriter.close ();
            System.out.println ("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println ("An error occurred.");
            System.out.println (e.getMessage ());
        }
        long endTime = System.currentTimeMillis ();
        long elapsedTime=endTime-startTime;
        System.out.println (elapsedTime);
    }
}