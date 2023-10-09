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