public class Sedan extends Car {
	  private float trunkSpace; 

	    public Sedan(int id, String type, String model, String condition, String color, int capacity,
	                 float mileage, String fuelType, String transmission, String vin, float price, 
	                 int carsAvailable, float trunkSpace) {
	        super(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
	        this.trunkSpace = trunkSpace; 
	    }

	    @Override
	    public void displayDetails() {
	        super.displayDetails(); // Call to the superclass method to display common details
	        System.out.println("Trunk Space: " + trunkSpace + " cubic feet"); // Additional detail specific to Sedans
	    }

	    // Getters and setters for the trunkSpace field

	    public float getTrunkSpace() {
	        return trunkSpace;
	    }

	    public void setTrunkSpace(float trunkSpace) {
	        this.trunkSpace = trunkSpace;
	    }
}