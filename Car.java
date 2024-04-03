public abstract class Car {
    protected String model;
    protected float price;
    protected float mileage;
    
    public Car(String model, float price, float mileage ) {
        this.model = model;
        this.price = price;
        this.mileage = mileage;
    }

    public abstract void displayDetails();
}