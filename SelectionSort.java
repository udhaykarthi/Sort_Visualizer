import java.awt.*;

public class SelectionSort extends Sorting {
    public SelectionSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        int n = bars.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            Bar minBar = bars.get(minIndex);
            minBar.setColor(Color.YELLOW); // current min candidate
            refresh();

            for (int j = i + 1; j < n; j++) {
                Bar current = bars.get(j);

                current.setColor(Color.RED); // comparing
                refresh();

                if (current.getHeightValue() < bars.get(minIndex).getHeightValue()) {
                    // reset old min back to default
                    bars.get(minIndex).setColor(Color.CYAN);
                    refresh();

                    minIndex = j;
                    bars.get(minIndex).setColor(Color.YELLOW); // new min
                    refresh();
                } else {
                    current.setColor(Color.CYAN); // reset if not chosen
                    refresh();
                }
            }

            // swap i and minIndex
            if (minIndex != i) {
                int temp = bars.get(i).getHeightValue();
                bars.get(i).setHeightValue(bars.get(minIndex).getHeightValue());
                bars.get(minIndex).setHeightValue(temp);
            }

            // lock this position as sorted
            bars.get(i).setColor(Color.GREEN);
            refresh();
        }

        // last element also sorted
        bars.get(n - 1).setColor(Color.GREEN);
        refresh();
    }
}
