

public class Main {
    public static void main (String[] args) throws ClassNotFoundException {

        Class<?> clazz       = Class.forName ("Reflection");
        Subject  annotations = clazz.getAnnotation (Subject.class);
        for (String cat : annotations.categories ()) {
            if (!cat.equals ("Test")) {
                System.out.println (cat);

            }


        }

    }
}