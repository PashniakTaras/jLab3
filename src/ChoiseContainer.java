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