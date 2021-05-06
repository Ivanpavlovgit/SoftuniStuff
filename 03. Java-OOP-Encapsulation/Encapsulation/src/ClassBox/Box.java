package ClassBox;

///-	length: double
//-	width:  double
//-	height:  double
//+ 	Box (double length, double width, double height)
//-	setLength(double): void
//-	setWidth(double): void
//-	setHeight(double): void
//+	calculateSurfaceArea (): double
//+	calculateLateralSurfaceArea (): double
//+	calculateVolume (): double
public class Box {
    private double length;
    private double width;
    private double height;

    private void setLength (double length) {
        if (isGreaterThanZero (length)) {
            this.length = length;
        } else {
            throw new IllegalArgumentException ("Length cannot be zero or negative");
        }
    }

    private void setWidth (double width) {
        if (!isGreaterThanZero (width)) {
            throw new IllegalArgumentException ("Width cannot be zero or negative");
        }
        this.width = width;
    }

    private void setHeight (double height) {
        if (isGreaterThanZero (height)) {
            this.height = height;
        } else {
            throw new IllegalArgumentException ("Height cannot be zero or negative");
        }
    }

    public Box (double length,double width,double height) {
        this.setLength (length);
        this.setHeight (height);
        this.setWidth (width);
    }

    private boolean isGreaterThanZero (double val) {
        return val > 0;
    }

    public double calculateLateralSurfaceArea () {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateSurfaceArea () {
        return calculateLateralSurfaceArea () + 2 * length * width;
    }

    public double calculateVolume () {
        return this.height * this.length * this.width;
    }


}
