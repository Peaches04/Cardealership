public class Hatchback extends Car {
    private boolean foldableSeats;

    public Hatchback(int id, String type, String model, String condition, String color, int capacity,
                     float mileage, String fuelType, String transmission, String vin, float price, 
                     int carsAvailable, boolean foldableSeats) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.foldableSeats = foldableSeats;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Foldable Seats: " + foldableSeats); // Additional detail specific to Hatchbacks
    }

    // Getters and setters for foldableSeats

    public boolean isFoldableSeats() {
        return foldableSeats;
    }

    public void setFoldableSeats(boolean foldableSeats) {
        this.foldableSeats = foldableSeats;
    }
}