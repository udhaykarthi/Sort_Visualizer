import java.awt.*;

public class InsertionSort extends Sorting {
    public InsertionSort(VisualizerFrame frame) {
        super(frame);
    }

    @Override
    public void sort() {
        int n = bars.size();

        for (int i = 1; i < n; i++) {
            Bar keyBar = bars.get(i);
            int key = keyBar.getHeightValue();

            keyBar.setColor(Color.YELLOW); // current key
            refresh();

            int j = i - 1;
            while (j >= 0 && bars.get(j).getHeightValue() > key) {
                Bar cur = bars.get(j);
                cur.setColor(Color.RED); // shifting
                refresh();

                bars.get(j + 1).setHeightValue(cur.getHeightValue());
                cur.setColor(Color.CYAN); // reset
                refresh();

                j--;
            }

            bars.get(j + 1).setHeightValue(key);
            keyBar.setColor(Color.CYAN); // reset key
            refresh();
        }

        // Mark final sorted array
        for (Bar bar : bars) {
            bar.setColor(Color.GREEN);
            refresh();
        }
    }
}
