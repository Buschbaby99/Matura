import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NumberConverterGUI extends JFrame {
    private JTextField inputField;
    private JLabel outputLabel;
    private JCheckBox hexBox, binBox, octBox;
    private DefaultTableModel tableModel;
    private JTable resultTable;

    public NumberConverterGUI() {
        setTitle("Number Converter");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Datei");
        JMenuItem saveItem = new JMenuItem("Als Markdown speichern");
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        saveItem.addActionListener(e -> saveTableAsMarkdown());

        inputField = new JTextField(10);
        outputLabel = new JLabel("Ergebnis: ");
        hexBox = new JCheckBox("Hex");
        binBox = new JCheckBox("Binär");
        octBox = new JCheckBox("Oktal");

        String[] columnNames = {"Dezimal", "Hex", "Binär", "Oktal"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setPreferredSize(new Dimension(550, 300));

        resultTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = resultTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        tableModel.removeRow(selectedRow);
                        outputLabel.setText("Zeile gelöscht");
                    }
                }
            }
        });

        JButton convertButton = new JButton("Konvertieren");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(inputField.getText());
                    String hexResult = "", binResult = "", octResult = "";

                    if (hexBox.isSelected()) {
                        hexResult = Integer.toHexString(num).toUpperCase();
                    }
                    if (binBox.isSelected()) {
                        binResult = Integer.toBinaryString(num);
                    }
                    if (octBox.isSelected()) {
                        octResult = Integer.toOctalString(num);
                    }

                    outputLabel.setText("Ergebnis hinzugefügt");
                    tableModel.addRow(new Object[]{num, hexResult, binResult, octResult});

                } catch (NumberFormatException ex) {
                    outputLabel.setText("Ungültige Eingabe");
                }
            }
        });

        add(inputField);
        add(convertButton);
        add(hexBox);
        add(binBox);
        add(octBox);
        add(outputLabel);
        add(scrollPane);
    }

    private void saveTableAsMarkdown() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("table.md"))) {
            writer.write("| Dezimal | Hex | Binär | Oktal |\n");
            writer.write("|---------|-----|-------|-------|\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                writer.write("| ");
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.write(tableModel.getValueAt(i, j).toString() + " | ");
                }
                writer.write("\n");
            }
            outputLabel.setText("Tabelle als Markdown gespeichert");
        } catch (IOException e) {
            outputLabel.setText("Fehler beim Speichern der Datei");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumberConverterGUI().setVisible(true);
        });
    }
}
