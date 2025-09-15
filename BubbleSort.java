import java.awt.*;

public class BubbleSort extends Sorting {
    public BubbleSort(VisualizerFrame frame) {
        super(frame);  
    }

    @Override
    public void sort() {
        int n = bars.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Bar b1 = bars.get(j);
                Bar b2 = bars.get(j + 1);

                b1.setColor(Color.RED);
                b2.setColor(Color.RED);
                refresh();

                if (b1.getHeightValue() > b2.getHeightValue()) {
                    int temp = b1.getHeightValue();
                    b1.setHeightValue(b2.getHeightValue());
                    b2.setHeightValue(temp);
                }

                b1.setColor(Color.CYAN);
                b2.setColor(Color.CYAN);
                refresh();
            }
        }

        // Final sorted state
        for (Bar bar : bars) {
            bar.setColor(Color.GREEN);
            refresh();
        }
    }
}
