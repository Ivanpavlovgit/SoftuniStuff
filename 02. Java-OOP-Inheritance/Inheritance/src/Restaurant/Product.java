package Restaurant;

import java.math.BigDecimal;

//The Product class must have the following members:
//•	A public constructor with the following parameters: String name, BigDecimal price
//•	name – String
//•	price – BigDecimal
//•	Getters for the fields
public class Product {
    public String getName () {
        return this.name;
    }

    public BigDecimal getPrice () {
        return this.price;
    }

    private String name;
    private BigDecimal price;

    public Product(String name,BigDecimal price){
        this.name=name;
        this.price=price;
    }
}
