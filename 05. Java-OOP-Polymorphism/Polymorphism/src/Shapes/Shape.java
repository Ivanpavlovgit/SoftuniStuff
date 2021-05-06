package Shapes;

public abstract class Shape {
    protected Double perimeter;
    protected Double area;


    public abstract Double calculatePerimeter ();
    public abstract Double calculateArea ();

    public Double getPerimeter () {
        return this.perimeter;
    }
    public Double getArea () {
        return this.area;
    }
}
