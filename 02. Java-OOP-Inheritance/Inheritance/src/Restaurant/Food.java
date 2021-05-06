package Restaurant;

import java.math.BigDecimal;

//The Food class must have the following members:
//•	A constructor with the following parameters: String name, BigDecimal price, double grams
//•	name – String
//•	price – double
//•	grams – double
//•	Getter for grams
public class Food extends Product {
    private double grams;
    public Food (String name,BigDecimal price,double grams){
        super(name,price);
        this.grams=grams;
    }
    public double getGrams () {
        return this.grams;
    }
}
