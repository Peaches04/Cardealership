public class Pickup extends Car {
    private float towingCapacity; 

    public Pickup(String model, float price, float mileage, float towingCapacity) {
        super(model, price, mileage); 
        this.towingCapacity = towingCapacity; 
    }


    public void displayDetails() {
    	//in progress
    	//new commnet
    }

    public float getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(float towingCapacity) {
        this.towingCapacity = towingCapacity;
        
    }
}