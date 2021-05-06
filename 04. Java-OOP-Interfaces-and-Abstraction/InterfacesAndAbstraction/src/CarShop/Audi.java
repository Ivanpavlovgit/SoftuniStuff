package CarShop;

public class Audi extends CarImpl implements Rentable {

    public Audi (String model,String color,Integer horsePower,String countryProduced,Integer minRentDay,Double pricePerDay) {
        super (model,color,horsePower,countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

   /* private String model;
    private String color;
    private Integer horsePower;
    private String countryProduce;*/

    private Integer minRentDay;
    private Double pricePerDay;

    /* @Override
     public String getModel () {
         return model;
     }

     @Override
     public String getColor () {
         return color;
     }

     @Override
     public Integer getHorsePower () {
         return horsePower;
     }

     @Override
     public String countryProduce () {
         return countryProduce;
     }
 */
    //Methods moved to Interface CarImpl
    @Override
    public Integer getMinRentDay () {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay () {
        return pricePerDay;
    }
}

   /* @Override
    public String toString () {
        return String.format ("This is %s produced in Spain and have %d tires",model,TIRES);
    }

}*/
