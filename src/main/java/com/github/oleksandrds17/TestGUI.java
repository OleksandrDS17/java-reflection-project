package com.github.oleksandrds17;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TestGUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextArea logArea;

    public TestGUI() {
        setTitle("Java Reflection Test Runner");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        JButton runButton = new JButton("Run Tests");
        JButton loadButton = new JButton("Load Results");
        JButton clearButton = new JButton("Clear DB");

        topPanel.add(runButton);
        topPanel.add(loadButton);
        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"ID", "Test Name", "Result", "Run Time"}, 0
        );

        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);

        add(tableScroll, BorderLayout.CENTER);

        logArea = new JTextArea(8, 40);
        logArea.setEditable(false);
        JScrollPane logScroll = new JScrollPane(logArea);

        add(logScroll, BorderLayout.SOUTH);

        runButton.addActionListener(e -> runTestsAndRefresh());
        loadButton.addActionListener(e -> loadResultsIntoTable());
        clearButton.addActionListener(e -> clearDatabase());

        loadResultsIntoTable();
    }

    private void runTestsAndRefresh() {
        logArea.append("Tests werden gestartet...\n");
        TestRunner.runTests(CalculatorTest.class);
        logArea.append("Tests fertig.\n");
        loadResultsIntoTable();
    }

    private void loadResultsIntoTable() {
        tableModel.setRowCount(0);

        List<String[]> results = DatabaseManager.getResults();

        for (String[] row : results) {
            tableModel.addRow(row);
        }

        logArea.append("Datenbankdaten geladen.\n");
    }

    private void clearDatabase() {
        DatabaseManager.clearResults();
        tableModel.setRowCount(0);
        logArea.append("Datenbank wurde geleert.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestGUI gui = new TestGUI();
            gui.setVisible(true);
        });
    }
}
