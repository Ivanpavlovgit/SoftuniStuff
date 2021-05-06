package Shapes;

public class Main {
    public static void main (String[] args) {
        Shape shape=new Rectangle (2.0,4.0);
        Shape circle=new Circle (1.0);
        System.out.println (shape.calculateArea ());
        System.out.println (shape.calculatePerimeter ());
        System.out.println (circle.calculateArea ());
        System.out.println (circle.calculatePerimeter ());
    }
}
