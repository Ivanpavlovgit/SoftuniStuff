package ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public void setName (String name) {
       if(!NameValidator.isValidName(name)){
           throw new IllegalArgumentException (ConstantMessages.INVALID_NAME_EXCEPTION_MESSAGE);
       }
       this.name=name;
    }

    public void setCost (double cost) {
      if(NumericValidator.isNegative (cost)){
      throw new IllegalArgumentException (ConstantMessages.NEGATIVE_MONEY_EXCEPTION_MESSAGE);
      }
        this.cost = cost;
    }

    public String getName () {
        return this.name;
    }

    public double getCost () {
        return this.cost;
    }


    public Product (String name,double cost) {
        this.name = name;
        this.cost = cost;
    }
}
