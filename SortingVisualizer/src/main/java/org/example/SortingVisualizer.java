package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizer extends JFrame {
    private final int WIDTH = 800, HEIGHT = 600;
    private final int BAR_WIDTH = 10;
    private final int SIZE = WIDTH / BAR_WIDTH;
    private int[] array = new int[SIZE];
    private String currentAlgorithm = "Bubble Sort";

    private JPanel drawPanel;
    private JComboBox<String> algorithmSelector;
    private JButton sortButton, shuffleButton;

    public SortingVisualizer() {
        setTitle("Sorting Algorithm Visualizer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        drawPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawArray(g);
            }
        };
        drawPanel.setBackground(Color.BLACK);
        add(drawPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        algorithmSelector = new JComboBox<>(new String[]{
                "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort"
        });

        sortButton = new JButton("Sort");
        shuffleButton = new JButton("Shuffle");

        sortButton.addActionListener(e -> new Thread(this::sort).start());
        shuffleButton.addActionListener(e -> {
            shuffleArray();
            repaint();
        });

        controlPanel.add(new JLabel("Select Algorithm:"));
        controlPanel.add(algorithmSelector);
        controlPanel.add(sortButton);
        controlPanel.add(shuffleButton);

        add(controlPanel, BorderLayout.SOUTH);
        shuffleArray();
    }

    private void drawArray(Graphics g) {
        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            g.setColor(Color.ORANGE);
            g.fillRect(i * BAR_WIDTH, drawPanel.getHeight() - height, BAR_WIDTH, height);
        }
    }

    private void shuffleArray() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(500); // use a fixed height instead of drawPanel.getHeight()
        }
    }


    private void sort() {
        currentAlgorithm = (String) algorithmSelector.getSelectedItem();
        switch (currentAlgorithm) {
            case "Bubble Sort": bubbleSort(); break;
            case "Selection Sort": selectionSort(); break;
            case "Insertion Sort": insertionSort(); break;
            case "Merge Sort": mergeSort(0, array.length - 1); break;
            case "Quick Sort": quickSort(0, array.length - 1); break;
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
        repaint();
    }

    private void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    sleep(10);
                }
            }
        }
    }

    private void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
            sleep(10);
        }
    }

    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                sleep(10);
            }
            array[j + 1] = key;
            sleep(10);
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
            repaint();
            sleep(20);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = array[left + i];
        for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            array[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
            repaint();
            sleep(20);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
                sleep(10);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
