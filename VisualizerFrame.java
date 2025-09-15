import javax.swing.*;
import java.awt.*;
import java.util.*;

public class VisualizerFrame extends JFrame {
    private JPanel canvas;
    private JButton generateBtn;
    private JButton bubbleSortBtn;
    private JButton selectionSortBtn;
    private JButton quickSortBtn;
    private JButton mergeSortBtn;
    private JButton dualPivotQuickSortBtn;
    private JButton insertionSortBtn;
    private JButton heapSortBtn;
    private ArrayList<Bar> bars;
    private int n = 50;

    public VisualizerFrame() {
        setTitle("Sorting Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        bars = new ArrayList<>();

        // Canvas to draw bars
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Bar bar : bars) {
                    bar.draw(g);
                }
            }
        };
        canvas.setBackground(Color.BLACK);

        // Buttons
        generateBtn = new JButton("Generate");
        bubbleSortBtn = new JButton("Bubble Sort");
        selectionSortBtn = new JButton("Selection Sort");
        quickSortBtn = new JButton("Quick Sort");
        mergeSortBtn = new JButton("Merge Sort");
        dualPivotQuickSortBtn = new JButton("Dual-Pivot Quick Sort");
        insertionSortBtn = new JButton("Insertion Sort");
        heapSortBtn = new JButton("Heap Sort");


        generateBtn.addActionListener(e -> generateBars());
        bubbleSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new BubbleSort(this).sort(); 
            }).start();
        });

        selectionSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new SelectionSort(this).sort(); 
            }).start();
        });

        quickSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new QuickSort(this).sort(); 
            }).start();
        });
        mergeSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new MergeSort(this).sort(); 
            }).start();
        });
        dualPivotQuickSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new DualPivotQuickSort(this).sort(); 
            }).start();
        });
        insertionSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new InsertionSort(this).sort(); 
            }).start();
        });
        heapSortBtn.addActionListener(e -> {
            new Thread(() -> {
                new HeapSort(this).sort(); 
            }).start();
        });

        // Control panel with both buttons
        JPanel controlPanel = new JPanel();
        controlPanel.add(generateBtn);
        controlPanel.add(bubbleSortBtn);
        controlPanel.add(selectionSortBtn);
        controlPanel.add(quickSortBtn);
        controlPanel.add(mergeSortBtn);
        controlPanel.add(dualPivotQuickSortBtn);
        controlPanel.add(insertionSortBtn);
        controlPanel.add(heapSortBtn);

        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void generateBars() {
        bars.clear();
        Random rand = new Random();
        int width = getWidth() / n;
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(getHeight() - 100) + 20;
            bars.add(new Bar(i * width, getHeight() - value, width - 2, value));
        }
        repaint();
    }

    public ArrayList<Bar> getBars() {
        return bars;
    }
}
