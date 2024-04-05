/**
 * Represents a Hatchback car, extending the Car class with additional foldable seat feature. 
 * 
 */
public class Hatchback extends Car {
    private boolean foldableSeats;

    /**
     * Constructs a new Hatchback instance with the specified details, including whether it has foldable seats.
     *
     * @param id The unique identifier for the car.
     * @param type The type of the car (e.g., Hatchback, Sedan, SUV).
     * @param model The model of the car.
     * @param condition The condition of the car (e.g., New, Used).
     * @param color The color of the car.
     * @param capacity The seating capacity of the car.
     * @param mileage The mileage of the car.
     * @param fuelType The type of fuel the car uses (e.g., Gasoline, Electric).
     * @param transmission The transmission type of the car (e.g., Automatic, Manual).
     * @param vin The Vehicle Identification Number.
     * @param price The price of the car.
     * @param carsAvailable The number of cars available for this model.
     * @param foldableSeats Indicates whether the car has foldable seats.
     */
    public Hatchback(int id, String type, String model, String condition, String color, int capacity,
                     float mileage, String fuelType, String transmission, String vin, float price, 
                     int carsAvailable, boolean foldableSeats) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.foldableSeats = foldableSeats;
    }

    /**
     * Displays the details of the Hatchback car, including common details inherited from the Car class
     * and the additional foldable seats feature.
     */
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Foldable Seats: " + foldableSeats); // Additional detail specific to Hatchbacks
    }

    /**
     * Returns the foldable seats status of the car.
     *
     * @return {@code true} if the car has foldable seats, otherwise {@code false}.
     */
    public boolean isFoldableSeats() {
        return foldableSeats;
    }

    /**
     * Sets the foldable seats status of the car.
     *
     * @param foldableSeats Indicates the car has foldable seats.
     */
    public void setFoldableSeats(boolean foldableSeats) {
        this.foldableSeats = foldableSeats;
    }
}