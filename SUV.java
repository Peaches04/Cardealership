public class SUV extends Car {
    private boolean fourWheelDrive; 

  
    public SUV(String model, float price, float mileage, boolean fourWheelDrive) {
        super(model, price, mileage); 
        this.fourWheelDrive = fourWheelDrive; 
    }

 
    public void displayDetails() {
        System.out.println("SUV Details:");
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Mileage: " + mileage + " MPG");
        System.out.println("Four Wheel Drive: " + (fourWheelDrive ? "Yes" : "No"));
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }
}