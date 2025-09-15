import java.awt.*;

public class DualPivotQuickSort extends Sorting {
    public DualPivotQuickSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        dualPivotQuickSort(0, bars.size() - 1);

        // Mark final sorted array
        for (Bar bar : bars) {
            bar.setColor(Color.GREEN);
            refresh();
        }
    }

    private void dualPivotQuickSort(int low, int high) {
        if (low < high) {
            int[] pivots = partition(low, high);
            int lp = pivots[0];
            int rp = pivots[1];

            dualPivotQuickSort(low, lp - 1);
            dualPivotQuickSort(lp + 1, rp - 1);
            dualPivotQuickSort(rp + 1, high);
        }
    }

    private int[] partition(int low, int high) {
        // choose pivots
        Bar leftPivot = bars.get(low);
        Bar rightPivot = bars.get(high);

        leftPivot.setColor(Color.YELLOW);  // left pivot
        rightPivot.setColor(Color.MAGENTA); // right pivot
        refresh();

        // Ensure left pivot <= right pivot
        if (leftPivot.getHeightValue() > rightPivot.getHeightValue()) {
            int temp = leftPivot.getHeightValue();
            leftPivot.setHeightValue(rightPivot.getHeightValue());
            rightPivot.setHeightValue(temp);
        }

        int lpVal = leftPivot.getHeightValue();
        int rpVal = rightPivot.getHeightValue();

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            Bar current = bars.get(i);
            current.setColor(Color.RED); // comparing
            refresh();

            if (current.getHeightValue() < lpVal) {
                swap(i, lt);
                lt++;
                i++;
            } else if (current.getHeightValue() > rpVal) {
                swap(i, gt);
                gt--;
            } else {
                i++;
            }

            current.setColor(Color.CYAN); // reset
            refresh();
        }

        lt--;
        gt++;

        swap(low, lt);
        swap(high, gt);

        leftPivot.setColor(Color.CYAN);
        rightPivot.setColor(Color.CYAN);
        bars.get(lt).setColor(Color.GREEN); // locked
        bars.get(gt).setColor(Color.GREEN);
        refresh();

        return new int[]{lt, gt};
    }

    private void swap(int i, int j) {
        int temp = bars.get(i).getHeightValue();
        bars.get(i).setHeightValue(bars.get(j).getHeightValue());
        bars.get(j).setHeightValue(temp);
    }
}
