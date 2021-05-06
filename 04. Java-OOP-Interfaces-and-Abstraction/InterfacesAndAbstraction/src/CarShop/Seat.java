package CarShop;

public class Seat extends CarImpl implements Sellable {
/*    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduce;*/

    private Double price;

    public Seat (String model,String color,Integer horsePower,String countryProduced,Double price) {
        super (model,color,horsePower,countryProduced);

        this.price = price;
    }
//Methods moved to Interface CarImpl

   /* @Override
    public String getModel () {
        return model ;
    }

    @Override
    public String getColor () {
        return color ;
    }

    @Override
    public Integer getHorsePower () {
        return horsePower;
    }

    @Override
    public String countryProduce () {
        return countryProduce ;
    }
*/


    @Override
    public Double getPrice () {
        return this.price;
    }
}
