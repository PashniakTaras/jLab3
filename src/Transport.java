// Суперклас "Транспортний засіб"
class Transport {
    private String name;
    private int capacity;

    public Transport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void show() {
        System.out.println("Назва: " + name);
        System.out.println("Вмістимість: " + capacity + " пасажирів");
    }
}