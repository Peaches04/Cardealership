public class SUV extends Car {
    private boolean fourWheelDrive; 

    public SUV(int id, String type, String model, String condition, String color, int capacity,
               float mileage, String fuelType, String transmission, String vin, float price, 
               int carsAvailable, boolean fourWheelDrive) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.fourWheelDrive = fourWheelDrive; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Four Wheel Drive: " + (fourWheelDrive ? "Yes" : "No")); // Additional detail specific to SUVs
    }

    // Getters and setters for the fourWheelDrive field

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }
}