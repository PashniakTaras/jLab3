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