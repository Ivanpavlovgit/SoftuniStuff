package Restaurant;

import java.math.BigDecimal;

//The Beverage class must have the following members:
//•	A public constructor with the following parameters: String name, BigDecimal price, double milliliters
//•	name – String
//•	price – BigDecimal
//•	milliliters – double
//•	Getter for milliliters
public class Beverage extends Product {
    private double milliliters;
    public Beverage(String name,BigDecimal price,double milliliters){
        super(name,price);
        this.milliliters=milliliters;
    }

    public double getMilliliters () {
        return this.milliliters;
    }
}
