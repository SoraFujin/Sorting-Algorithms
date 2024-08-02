package com.sort.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingGUI extends JFrame {

    private sortingAnimation sort = new sortingAnimation();
    private JTextField sizeField;
    private JPanel arrayPanel;
    private JButton[] sortButtons;
    private JButton colorButton;
    private int[] array;
    private Timer timer;
    private int currentStep = 0;
    private int delay = 500; 
    private int[][] steps;
    private JSlider speedSlider; 
    private Color barColor = Color.GREEN; 

    public SortingGUI() {
        setTitle("Sorting Algorithm Visualizer");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Array Size:"), gbc);
        sizeField = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(sizeField, gbc);

        JButton generateButton = new JButton("Generate Array");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        inputPanel.add(generateButton, gbc);

        add(inputPanel, BorderLayout.NORTH);

        arrayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (array != null) {
                    int width = Math.max(5, getWidth() / array.length);
                    int maxHeight = getHeight() - 50;
                    int scale = maxHeight / getMax(array);

                    for (int i = 0; i < array.length; i++) {
                        int barHeight = array[i] * scale;
                        g.setColor(barColor);
                        g.fillRect(i * width, getHeight() - barHeight, width, barHeight);
                        g.setColor(Color.BLACK);
                        g.drawRect(i * width, getHeight() - barHeight, width, barHeight);
                        g.drawString(String.valueOf(array[i]), i * width + width / 2, getHeight() - barHeight - 5);
                    }
                }
            }
        };
        add(arrayPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 4, 10, 10));

        String[] buttonLabels = {
            "Bubble Sort", "Radix Sort", "Selection Sort",
            "Count Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Clear"
        };

        sortButtons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            sortButtons[i] = new JButton(buttonLabels[i]);
            buttonPanel.add(sortButtons[i]);
            sortButtons[i].addActionListener(new SortButtonListener(i));
        }

        colorButton = new JButton("Change Color");
        buttonPanel.add(colorButton);
        colorButton.addActionListener(e -> chooseColor());

        add(buttonPanel, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());

        JLabel speedLabel = new JLabel("Animation Speed:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        controlPanel.add(speedLabel, gbc);

        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.addChangeListener(e -> updateDelay());

        gbc.gridx = 1;
        gbc.gridy = 0;
        controlPanel.add(speedSlider, gbc);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(inputPanel, BorderLayout.NORTH);
        northPanel.add(controlPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);

        generateButton.addActionListener(e -> generateArray());
    }

    private void generateArray() {
        try {
            int size = Integer.parseInt(sizeField.getText());
            if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Array size must be a positive integer.");
                return;
            }
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * getHeight() / 2);
            }
            repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for the array size.");
        }
    }

    private void startAnimation() {
        if (array == null) {
            JOptionPane.showMessageDialog(this, "Please generate an array first.");
            return;
        }

        currentStep = 0;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep < steps.length) {
                    array = steps[currentStep].clone();
                    repaint();
                    currentStep++;
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    private void updateDelay() {
        int sliderValue = speedSlider.getValue();
        delay = Math.max(50, 1000 / sliderValue); 
        if (timer != null) {
            timer.setDelay(delay);
        }
    }

    private void chooseColor() {
        Color newColor = JColorChooser.showDialog(this, "Choose Bar Color", barColor);
        if (newColor != null) {
            barColor = newColor;
            repaint();
        }
    }

    private class SortButtonListener implements ActionListener {
        private int sortType;

        public SortButtonListener(int sortType) {
            this.sortType = sortType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (sortType) {
                case 0:
                    bubbleSort();
                    break;
                case 1:
                    radixSort();
                    break;
                case 2:
                    selectionSort();
                    break;
                case 3:
                    countingSort();
                    break;
                case 4:
                    insertionSort();
                    break;
                case 5:
                    quickSort();
                    break;
                case 6:
                    mergeSort();
                    break;
                case 7:
                    arrayPanel.removeAll();
                    array = null;
                    repaint();
                    break;
            }
        }

        private void bubbleSort() {
            steps = sort.bubbleSort(array);
            startAnimation();
        }

        private void radixSort() {
            steps = sort.radixSort(array);
            startAnimation();
        }

        private void selectionSort() {
            steps = sort.selectionSort(array);
            startAnimation();
        }

        private void countingSort() {
            steps = sort.countingSort(array);
            startAnimation();
        }

        private void insertionSort() {
            steps = sort.insertionSort(array);
            startAnimation();
        }

        private void quickSort() {
            steps = sort.quickSort(array);
            startAnimation();
        }

        private void mergeSort() {
            steps = sort.MergeSort(array);
            startAnimation();
        }
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortingGUI().setVisible(true));
    }
}

