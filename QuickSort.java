import java.awt.*;

public class QuickSort extends Sorting {
    public QuickSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        quickSort(0, bars.size() - 1);

        // Mark final sorted array
        for (Bar bar : bars) {
            bar.setColor(Color.GREEN);
            refresh();
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            // Left side
            quickSort(low, pi - 1);
            // Right side
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Bar pivotBar = bars.get(high);
        pivotBar.setColor(Color.YELLOW); // pivot
        refresh();

        int i = low - 1;

        for (int j = low; j < high; j++) {
            Bar current = bars.get(j);
            current.setColor(Color.RED); // comparing
            refresh();

            if (current.getHeightValue() < pivotBar.getHeightValue()) {
                i++;

                // swap bars[i] and bars[j]
                int temp = bars.get(i).getHeightValue();
                bars.get(i).setHeightValue(current.getHeightValue());
                current.setHeightValue(temp);
            }

            current.setColor(Color.CYAN); // reset
            refresh();
        }

        // place pivot in correct position
        i++;
        int temp = bars.get(i).getHeightValue();
        bars.get(i).setHeightValue(pivotBar.getHeightValue());
        pivotBar.setHeightValue(temp);

        pivotBar.setColor(Color.CYAN); // reset pivot
        bars.get(i).setColor(Color.GREEN); // correct position locked
        refresh();

        return i;
    }
}
