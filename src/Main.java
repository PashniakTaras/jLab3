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

