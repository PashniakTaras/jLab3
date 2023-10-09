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