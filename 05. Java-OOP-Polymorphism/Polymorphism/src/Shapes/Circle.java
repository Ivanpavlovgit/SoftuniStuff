package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle (Double radius) {
        this.radius = radius;
    }

    public final Double getRadius () {
        return this.radius;
    }

    @Override
    public Double calculatePerimeter () {
        if(super.perimeter!=null){
            return perimeter;
        }
        return super.perimeter= 2 * this.radius * Math.PI;
    }

    @Override
    public Double calculateArea () {
        if(super.area!=null){
            return area;
        }
        return super.area= this.radius * this.radius * Math.PI;
    }
}
