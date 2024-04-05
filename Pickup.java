public class Pickup extends Car {
    private float towingCapacity; 

    public Pickup(int id, String type, String model, String condition, String color, int capacity,
                  float mileage, String fuelType, String transmission, String vin, float price, 
                  int carsAvailable, float towingCapacity) {
        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
        this.towingCapacity = towingCapacity; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to the superclass method to display common details
        System.out.println("Towing Capacity: " + towingCapacity + " lbs/kg (depending on unit)"); // Additional detail specific to Pickup trucks
    }

    public float getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(float towingCapacity) {
        this.towingCapacity = towingCapacity;
        
    }
}