public class Hatchback extends Car {
    private boolean foldableSeats;

    public Hatchback(String model, float price, float mileage, boolean foldableSeats) {
        super(model, price, mileage);
        this.foldableSeats = foldableSeats;
    }

    @Override
    public void displayDetails() {
        System.out.println("Hatchback Model: " + model + ", Mileage: " + mileage+ ", Foldable Seats: " + foldableSeats);
    }
}