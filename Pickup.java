/**
 * Represents a Pickup truck, extending the Car class with additional towing capacity parameter.
 * 
 */
public class Pickup extends Car {
    private float towingCapacity; 

    /**
     * Constructs a new Pickup instance with specified details, including the towing capacity.
     * 
     * @param id The unique identifier.
     * @param type The type of the car.
     * @param model The model of the car.
     * @param condition The condition of the car .
     * @param color The color of the car.
     * @param capacity The seating capacity of the car.
     * @param mileage The mileage of the car.
     * @param fuelType The type of fuel the car uses.
     * @param transmission The transmission type of the car.
     * @param vin The Vehicle Identification Number.
     * @param price The price of the car.
     * @param carsAvailable The number of cars available for this model.
     * @param towingCapacity The towing capacity of the Pickup in pounds or kilograms.
     */
    public Pickup(int id, String type, String model, String condition, String color, int capacity,
                  float mileage, String fuelType, String transmission, String vin, float price, 
                  int carsAvailable, float towingCapacity) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.towingCapacity = towingCapacity; 
    }

    /**
     * Displays the details of the Pickup.
     */
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Towing Capacity: " + towingCapacity + " lbs/kg (depending on unit)"); // Additional detail specific to Pickup trucks
    }

    /**
     * Gets the towing capacity of the Pickup.
     * 
     * @return The towing capacity in pounds or kilograms.
     */
    public float getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * Sets the towing capacity of the Pickup.
     * 
     * @param towingCapacity The towing capacity in pounds.
     */
    public void setTowingCapacity(float towingCapacity) {
        this.towingCapacity = towingCapacity;
    }
}