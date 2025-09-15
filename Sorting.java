import java.util.ArrayList;

public abstract class Sorting {
    protected ArrayList<Bar> bars;
    protected VisualizerFrame frame;

    public Sorting(VisualizerFrame frame) {
        this.frame = frame;
        this.bars = frame.getBars();
    }

    public abstract void sort();

    protected void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    protected void refresh() {
        frame.repaint();
        sleep(50); 
    }
}
