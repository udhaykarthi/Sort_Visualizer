import java.awt.*;

public class HeapSort extends Sorting {
    public HeapSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        int n = bars.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max) with last element
            swap(0, i);
            bars.get(i).setColor(Color.GREEN); // locked in place
            refresh();

            // Heapify reduced heap
            heapify(i, 0);
        }

        // Last element is sorted
        bars.get(0).setColor(Color.GREEN);
        refresh();
    }

    private void heapify(int n, int i) {
        int largest = i;  
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            bars.get(left).setColor(Color.RED); // checking left child
            refresh();
            if (bars.get(left).getHeightValue() > bars.get(largest).getHeightValue()) {
                largest = left;
            }
            bars.get(left).setColor(Color.CYAN); // reset
        }

        if (right < n) {
            bars.get(right).setColor(Color.RED); // checking right child
            refresh();
            if (bars.get(right).getHeightValue() > bars.get(largest).getHeightValue()) {
                largest = right;
            }
            bars.get(right).setColor(Color.CYAN); // reset
        }

        if (largest != i) {
            swap(i, largest);
            refresh();

            heapify(n, largest);
        }
    }

    private void swap(int i, int j) {
        int temp = bars.get(i).getHeightValue();
        bars.get(i).setHeightValue(bars.get(j).getHeightValue());
        bars.get(j).setHeightValue(temp);
    }
}
