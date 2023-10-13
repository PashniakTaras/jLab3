import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean Continue = true; //t
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Лаб 2.\nВиберіть номер завдання (1-3): ");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    First(); break;
                }
                case 2: {
                    Second(); break;
                }
                case 3: {
                    Third(); break;
                }
                default:{System.out.print("Не те…");     break;}
            }
            Scanner check = new Scanner(System.in);
            System.out.println("Дивимося завдання далі? 1 - Так, 2 - Ні \n");
            int cont = check.nextInt();
            if(cont == 2) {
                Continue = false;
            } else {
                Continue = true;
            }
        } while (Continue);
        System.out.println("Дапабачення");
    }

    public static void First() {
        Transport[] transports = new Transport[4];

        transports[0] = new Car("Легковий автомобіль", 5, 180);
        transports[1] = new Train("Пасажирський поїзд", 500, 10);
        transports[2] = new Express("Швидкий поїзд", 200, 5, "Київ");
        transports[3] = new Transport("Таксі", 4);

        for (Transport transport : transports) {
            transport.show();
            System.out.println();
        }
    }

    public static void Second() {
        double[] data = generateRandomData(5); // Генеруємо рандомні дані

        Container bubbleContainer = new Bubble(data);
        Container choiceContainer = new Choice(data);

        System.out.println("Bubble Container:");
        System.out.println("Before Sort: " + bubbleContainer);
        bubbleContainer.sort();
        System.out.println("After Sort: " + bubbleContainer);
        System.out.println("Norma: " + bubbleContainer.norma());

        System.out.println();

        System.out.println("Choice Container:");
        System.out.println("Before Sort: " + choiceContainer);
        choiceContainer.sort();
        System.out.println("After Sort: " + choiceContainer);
        System.out.println("Norma: " + choiceContainer.norma());
    }

    public static void Third() {
        double[] data = generateRandomData(5); // Генеруємо рандомні дані

        Containable bubbleContainer = new BubbleContainer(data);
        Containable choiceContainer = new ChoiceContainer(data);

        System.out.println("Bubble Container:");
        System.out.println("Before Sort: " + bubbleContainer);
        bubbleContainer.sort();
        System.out.println("After Sort: " + bubbleContainer);
        System.out.println("Norma: " + bubbleContainer.norma());

        System.out.println();

        System.out.println("Choice Container:");
        System.out.println("Before Sort: " + choiceContainer);
        choiceContainer.sort();
        System.out.println("After Sort: " + choiceContainer);
        System.out.println("Norma: " + choiceContainer.norma());
    }

    // Метод для генерації рандомних даних
    private static double[] generateRandomData(int size) {
        double[] data = new double[size];
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("0.0");

        for (int i = 0; i < size; i++) {
            data[i] = Double.parseDouble(df.format(10 * random.nextDouble())); // Округлення до 1 десятого
        }

        return data;
    }
}

// Інтерфейс для сортування та обробки елементів контейнера
interface Containable {
    void sort(); // Метод сортування

    double norma(); // Метод обробки елементів
}

import java.util.Arrays;

// Клас, який реалізує інтерфейс Containable для Bubble
class BubbleContainer implements Containable {
    private double[] elements;

    public BubbleContainer(double[] elements) {
        this.elements = elements;
    }

    @Override
    public void sort() {
        // Реалізація бульбашкового сортування
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    double temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (double element : elements) {
            sum += element;
        }
        return Math.sqrt(sum);
    }

    public double[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BubbleContainer other = (BubbleContainer) obj;
        return Arrays.equals(elements, other.elements);
    }
}

import java.util.Arrays;

// Клас, який реалізує інтерфейс Containable для Choice
class ChoiceContainer implements Containable {
    private double[] elements;

    public ChoiceContainer(double[] elements) {
        this.elements = elements;
    }

    @Override
    public void sort() {
        // Реалізація сортування методом вибору максимального елемента
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (elements[j] > elements[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = elements[i];
            elements[i] = elements[maxIndex];
            elements[maxIndex] = temp;
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (double element : elements) {
            sum += element;
        }
        return sum / elements.length;
    }

    public double[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChoiceContainer other = (ChoiceContainer) obj;
        return Arrays.equals(elements, other.elements);
    }
}

import java.util.Arrays;

// Абстрактний базовий клас Container
abstract class Container {
    protected double[] elements;

    public Container(double[] elements) {
        this.elements = elements;
    }

    public abstract void sort(); // Абстрактний метод сортування

    public abstract double norma(); // Абстрактний метод обробки елементів

    public double[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Container other = (Container) obj;
        return Arrays.equals(elements, other.elements);
    }
}

// Похідний клас Bubble
class Bubble extends Container {
    public Bubble(double[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        // Реалізація бульбашкового сортування
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    double temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (double element : elements) {
            sum += element;
        }
        return Math.sqrt(sum);
    }
}

// Похідний клас Choice
class Choice extends Container {
    public Choice(double[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        // Реалізація сортування методом вибору максимального елемента
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (elements[j] > elements[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = elements[i];
            elements[i] = elements[maxIndex];
            elements[maxIndex] = temp;
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (double element : elements) {
            sum += element;
        }
        return sum / elements.length;
    }
}

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