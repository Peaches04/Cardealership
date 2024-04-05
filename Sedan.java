/**
 * Represents a Sedan, extending the Car class with additional trunk feature.
 */
public class Sedan extends Car {
    private float trunkSpace;

    /**
     * Constructs a new Sedan instance with specified details.
     * 
     * @param id The unique identifier for the car.
     * @param type The type of the car.
     * @param model The model of the car.
     * @param condition The condition of the car.
     * @param color The color of the car.
     * @param capacity The seating capacity of the car.
     * @param mileage The mileage of the car.
     * @param fuelType The type of fuel the car uses.
     * @param transmission The transmission type of the car.
     * @param vin The Vehicle Identification Number.
     * @param price The price of the car.
     * @param carsAvailable The number of cars available for this model.
     * @param trunkSpace The trunk space of the Sedan in cubic feet.
     */
    public Sedan(int id, String type, String model, String condition, String color, int capacity,
                 float mileage, String fuelType, String transmission, String vin, float price, 
                 int carsAvailable, float trunkSpace) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.trunkSpace = trunkSpace;
    }

    /**
     * Displays the details of the Sedan.
     */
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Trunk Space: " + trunkSpace + " cubic feet"); // Additional detail specific to Sedans
    }

    /**
     * Gets the trunk space of the Sedan.
     * 
     * @return The trunk space in cubic feet.
     */
    public float getTrunkSpace() {
        return trunkSpace;
    }

    /**
     * Sets the trunk space of the Sedan.
     * 
     * @param trunkSpace The new trunk space in cubic feet.
     */
    public void setTrunkSpace(float trunkSpace) {
        this.trunkSpace = trunkSpace;
    }
}