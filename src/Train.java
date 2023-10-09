// Підклас "Поїзд"
class Train extends Transport {
    private int numberOfCars;

    public Train(String name, int capacity, int numberOfCars) {
        super(name, capacity);
        this.numberOfCars = numberOfCars;
    }

    public void show() {
        super.show();
        System.out.println("Кількість вагонів: " + numberOfCars);
    }
}