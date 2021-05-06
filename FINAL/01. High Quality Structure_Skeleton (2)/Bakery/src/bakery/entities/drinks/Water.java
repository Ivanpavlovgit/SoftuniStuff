package bakery.entities.drinks;

public class Water extends BaseDrink {
    public Water (String name,int portion,double price,String brand) {
        super (name,portion,1.50,brand);
    }
}
