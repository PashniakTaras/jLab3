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