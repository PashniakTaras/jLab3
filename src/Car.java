// Підклас "Автомобіль"
class Car extends Transport {
    private int maxSpeed;

    public Car(String name, int capacity, int maxSpeed) {
        super(name, capacity);
        this.maxSpeed = maxSpeed;
    }

    public void show() {
        super.show();
        System.out.println("Максимальна швидкість: " + maxSpeed + " км/год");
    }
}