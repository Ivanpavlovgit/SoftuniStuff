package blackBoxInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Main {
    public static void main (String[] args) throws
            IOException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException {

        String         inputPath    = "C:\\Users\\Asus\\Desktop\\InputForProgramsFromIntelliJ.txt";
        FileReader     myReader     = new FileReader (inputPath);
        BufferedReader buffMyReader = new BufferedReader (myReader);
        String         input        = buffMyReader.readLine ();

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        clazz.getDeclaredConstructor (int.class).setAccessible (true);
        Constructor<BlackBoxInt> ctor     = clazz.getDeclaredConstructor (int.class);
        ctor.setAccessible (true);
        BlackBoxInt              whiteBox = ctor.newInstance (0);



        while (!input.equals ("END")) {
            String[] tokens        = input.split ("_");
            String   command       = tokens[0];
            int      value         = Integer.parseInt (tokens[1]);
            Method   currentMethod = clazz.getDeclaredMethod (command,int.class);
            currentMethod.setAccessible (true);
            currentMethod.invoke (whiteBox,value);
            Field field = clazz.getDeclaredField ("innerValue");
            field.setAccessible (true);
            System.out.println (field.get (whiteBox));
            input = buffMyReader.readLine ();
        }
        buffMyReader.close ();
    }
}
