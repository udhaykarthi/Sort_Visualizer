import java.awt.*;

public class MergeSort extends Sorting {
    public MergeSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        mergeSort(0, bars.size() - 1);

        // Mark final sorted array
        for (Bar bar : bars) {
            bar.setColor(Color.GREEN);
            refresh();
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = bars.get(left + i).getHeightValue();
        }
        for (int j = 0; j < n2; j++) {
            R[j] = bars.get(mid + 1 + j).getHeightValue();
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            Bar leftBar = bars.get(k);
            leftBar.setColor(Color.RED); // comparison
            refresh();

            if (L[i] <= R[j]) {
                leftBar.setHeightValue(L[i]);
                i++;
            } else {
                leftBar.setHeightValue(R[j]);
                j++;
            }

            leftBar.setColor(Color.CYAN); // reset after placed
            refresh();
            k++;
        }

        while (i < n1) {
            Bar leftBar = bars.get(k);
            leftBar.setColor(Color.RED);
            refresh();

            leftBar.setHeightValue(L[i]);
            i++;
            k++;

            leftBar.setColor(Color.CYAN);
            refresh();
        }

        while (j < n2) {
            Bar leftBar = bars.get(k);
            leftBar.setColor(Color.RED);
            refresh();

            leftBar.setHeightValue(R[j]);
            j++;
            k++;

            leftBar.setColor(Color.CYAN);
            refresh();
        }
    }
}
