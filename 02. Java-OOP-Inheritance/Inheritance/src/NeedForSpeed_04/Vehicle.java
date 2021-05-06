package NeedForSpeed_04;

//Create a base class Vehicle. It should contain the following members:
//•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
//•	fuelConsumption –double
//•	fuel – double
//•	horsePower – int
//•	Getters and Setters for the fields
//•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
//•	void drive(double kilometers)
//o	The drive method should have a functionality to reduce the fuel based on the travelled kilometers and fuel consumption.
// Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.
public class Vehicle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsepower;

    public int getHorsepower () {
        return this.horsepower;
    }

    public void setHorsepower (int horsepower) {
        this.horsepower = horsepower;
    }

    public double getFuel () {
        return this.fuel;
    }

    public void setFuel (double fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumption () {
        return this.fuelConsumption;
    }

    public void setFuelConsumption (double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Vehicle (double fuel,int horsepower) {
        this.setFuel (fuel);
        this.setHorsepower (horsepower);
        this.setFuelConsumption (DEFAULT_FUEL_CONSUMPTION);
    }

    public void drive (double kilometers) {
        double usedFuel = kilometers * fuelConsumption;
        if (usedFuel <= this.fuel) {
            fuel -= usedFuel;
        }
    }

}
