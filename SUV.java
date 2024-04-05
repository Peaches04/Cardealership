/**
 * Represents an SUV, extending the {@code Car} class with additional four-wheel drive feature. 
 */
public class SUV extends Car {
    private boolean fourWheelDrive;

    /**
     * Constructs a new SUV instance with specified details, including whether it has four-wheel drive.
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
     * @param fourWheelDrive A boolean indicating whether the SUV has four-wheel drive.
     */
    public SUV(int id, String type, String model, String condition, String color, int capacity,
               float mileage, String fuelType, String transmission, String vin, float price, 
               int carsAvailable, boolean fourWheelDrive) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.fourWheelDrive = fourWheelDrive;
    }

    /**
     * Displays the details of the SUV.
     */
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Four Wheel Drive: " + (fourWheelDrive ? "Yes" : "No")); // Additional detail specific to SUVs
    }

    /**
     * Gets the four-wheel drive status of the SUV.
     * 
     * @return boolean true if the SUV has four-wheel drive, false otherwise.
     */
    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    /**
     * Sets the four-wheel drive status of the SUV.
     * 
     * @param fourWheelDrive The new four-wheel drive status.
     */
    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }
}