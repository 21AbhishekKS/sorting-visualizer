package org.example;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {


            SwingUtilities.invokeLater(() -> {
                SortingVisualizer sv = new SortingVisualizer();
                sv.setVisible(true);
            });


    }
}
