package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.nio.file.Path;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {


    //•	capacity - int the table capacity.
    //o	 It can’t be less than zero. In these cases, throw an IllegalArgumentException with message "Capacity has to be greater than 0"
    //•	numberOfPeople - int the count of people who want a table.
    //o	 cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    //•	pricePerPerson – double the price per person for the table
    //•	isReserved - boolean returns true if the table is reserved, otherwise false.
    //•	price – double calculates the price for all people
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;

    private void setCapacity (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException (INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople (int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException (INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setTableNumber (int tableNumber) {
        this.tableNumber = tableNumber;
    }

    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable (int tableNumber,int capacity,double pricePerPerson) {
        setNumberOfPeople (tableNumber);
        setCapacity (capacity);
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber () {
        return this.tableNumber;
    }

    @Override
    public int getCapacity () {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople () {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson () {
        return this.pricePerPerson;
    }

    //TODO check
    @Override
    public boolean isReserved () {
        return false;
    }

    @Override
    public double getPrice () {
        return this.price;
    }

    @Override
    public void reserve (int numberOfPeople) {

    }

    @Override
    public void orderFood (BakedFood food) {

    }

    @Override
    public void orderDrink (Drink drink) {

    }

    @Override
    public double getBill () {
        return 0;
    }

    @Override
    public void clear () {

    }

    @Override
    public String getFreeTableInfo () {
        return String.format ("T");
    }
}
