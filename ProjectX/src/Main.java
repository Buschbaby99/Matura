
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Number Converter
         */
        /*

        // Initialisiert die Tabelle
        String[] columnNames = {"Decimal", "Binary", "Hexadecimal", "Octal", "ASCII"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Erstellt JFrame
        JFrame frame = new JFrame("Number Converter Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstellt Eingabefeld und Button
        JTextField inputField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton addButton2 = new JButton("AddObject");

        // Fügt Eingabefeld und Button zu einem Panel hinzu
        JPanel panel = new JPanel();
        panel.add(inputField);
        panel.add(addButton);
        panel.add(addButton2);

        // Fügt das Panel und die Tabelle zum Frame hinzu
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);


        /**
         * List mit Strin array
         */
        // ActionListener für den Button
        /*
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    int inputNumber = Integer.parseInt(inputText);
                    NumberConverter myNum = new NumberConverter();
                    myNum.setDecimalNumber(inputNumber);

                    List<String[]> allValues = myNum.returnMyNumbers();

                    // Wir nehmen an, dass es nur eine Reihe in allValues gibt
                    if (!allValues.isEmpty()) {
                        for(String[] myList : myNum.returnMyNumbers()){
                            tableModel.addRow(new Object[]{myList[0], myList[1], myList[2], myList[3], myList[4]});
                        }
                    }
                  myNum.myPrint();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid decimal number.");
                }
                inputField.setText("");  // Leert das Eingabefeld
            }
        });

        /**
         * List with Object Array
         */
        /*
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    int inputNumber = Integer.parseInt(inputText);
                    NumberConverter myNum = new NumberConverter();
                    myNum.setDecimalNumber(inputNumber);

                    // Wir nehmen an, dass es nur eine Reihe in allValues gibt
                    //tableModel.setRowCount(0); Um alles zu löschen
                    tableModel.addRow(myNum.getAllValuesForObject().toArray());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid decimal number.");
                }
                inputField.setText("");  // Leert das Eingabefeld
            }
        });

        // Frame-Eigenschaften setzen
        frame.pack();
        frame.setVisible(true);
        */


        /**
         * File System
         */

        //FileSystemGUI fileSystemGUI = new FileSystemGUI();


        /**
         * Read and Write
         */
/*
        ReadFileAndWriteFile myRandW = new ReadFileAndWriteFile();

    // Hängt den Inhalt am Ende der Datei an
        myRandW.performOperation();


*/
        /*
        ReadFileAndWriteFile a = new ReadFileAndWriteFile();
        a.setPath("src/Test/myTESTSDCDSC");
        a.readFileEasy();
        System.out.println(a.getContent());
*/
        //ReadFileAndWriteFile w = new ReadFileAndWriteFile("hallo meine freunde");
        /*
        ReadFileAndWriteFile r = new ReadFileAndWriteFile();
        r.setContent("dsdlsdlvlvmsdv");
        r.setPath("src/Test/myTESTSDCDSC");

        r.appendFile(r.getPath(), r.getContent());

        r.copyChoosenFile();

        ReadFileAndWriteFile myFile = new ReadFileAndWriteFile();

        //myFile.copyChoosenFile();

        myFile.setPath("src/Test/hhh");
        myFile.setContent("UUUUUUUUUUUUUUUUUUUUUUUU");
        myFile.appendFile(myFile.getPath(), myFile.getContent());

        myFile.setChoosenPath();
        System.out.println(myFile.getPath());

         */

        FileReader fileReader = new FileReader("src/Test/t");

        // Setzen Sie den Delimiter hier
        fileReader.readFileAndSplitByDelimiter(" ");

        List<String> words = fileReader.getWords();
        for (String word : words) {
            System.out.println(word);
        }
    }
}
