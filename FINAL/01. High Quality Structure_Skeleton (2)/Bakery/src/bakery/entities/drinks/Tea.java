package bakery.entities.drinks;

import bakery.entities.bakedFoods.BaseFood;

public class Tea extends BaseDrink {

    public Tea (String name,int portion,double price,String brand) {
        super (name,portion,2.50,brand);
    }
}
