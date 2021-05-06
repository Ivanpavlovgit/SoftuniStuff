package Shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height,Double width){
        this.height=height;
        this.width=width;
    }

    public Double getHeight () {
        return this.height;
    }
    public Double getWidth () {
        return this.width;
    }

//use the super.method to save space and make code clear
    @Override
    public Double calculatePerimeter () {
        if(super.perimeter !=null){
            return super.perimeter;
        }
        return super.perimeter= 2*( this.height+this.width);
    }
    @Override
    public Double calculateArea () {
        if(super.area!=null){
            return super.area;
        }
        return super.area= this.height*this.width;
    }
}
