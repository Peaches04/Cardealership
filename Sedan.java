public class Sedan extends Car {
    private float trunkSpace; 


    public Sedan(String model, float price, float mileage, float trunkSpace) {
        super(model, price, mileage); 
        this.trunkSpace = trunkSpace; 
    }


    public void displayDetails() {
        System.out.println("Sedan Details:");
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Mileage: " + mileage + " MPG");
        System.out.println("Trunk Space: " + trunkSpace + " cubic feet");
    }

    public float getTrunkSpace() {
        return trunkSpace;
    }

    public void setTrunkSpace(float trunkSpace) {
        this.trunkSpace = trunkSpace;
    }
}