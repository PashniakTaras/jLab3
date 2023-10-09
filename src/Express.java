// Підклас "Експрес"
class Express extends Train {
    private String destination;

    public Express(String name, int capacity, int numberOfCars, String destination) {
        super(name, capacity, numberOfCars);
        this.destination = destination;
    }

    public void show() {
        super.show();
        System.out.println("Пункт призначення: " + destination);
    }
}