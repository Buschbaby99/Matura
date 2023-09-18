import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.event.DocumentEvent;

public class ConverterGUI extends JFrame {
    private JPanel MainPanel;
    private JTextArea input;
    private JTextArea output;
    private JRadioButton hexButton;
    private JRadioButton binaryButton;

    private JMenuBar menuBar;
    private JMenu myMenu, myMenuView;
    private JMenuItem Open, Save, Save_As, Stats;

    private boolean saved;

    private String title;


    Converter myCon = new Converter();
    ReadWriteFiles myReader = new ReadWriteFiles();

    public ConverterGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        add(MainPanel);
        pack();
        setVisible(true);

        title = "untitled - Technical Editor";

        /**
         * Menu
         */
        menuBar = new JMenuBar();
        myMenu = new JMenu("File");
        Open = new JMenuItem("Open...");
        Save = new JMenuItem("Save");
        Save_As = new JMenuItem("Save As...");

        myMenuView = new JMenu("View");
        Stats = new JMenuItem("Stats");

        menuBar.add(myMenu);
        menuBar.add(myMenuView);
        myMenu.add(Open);
        myMenu.add(Save);
        myMenu.add(Save_As);
        myMenuView.add(Stats);

        setJMenuBar(menuBar);

        /**
         * default set radioButton to HEX
         */
        hexButton.setSelected(true);



        setTitle(title);


        input.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                saved = false;
                if(hexButton.isSelected()){
                    output.setText(myCon.textToHEX(input.getText()));
                } else if (binaryButton.isSelected()) {
                    output.setText(myCon.textToBinary(input.getText()));
                }
                setTitle(title + "*" + " - " + "Technical Editor");
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saved = false;
                if(hexButton.isSelected()){
                    output.setText(myCon.textToHEX(input.getText()));
                }else if (binaryButton.isSelected()) {
                    output.setText(myCon.textToBinary(input.getText()));
                }
                setTitle(title + "*" + " - " + "Technical Editor");
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                saved = false;
                if(hexButton.isSelected()){
                    output.setText(myCon.textToHEX(input.getText()));
                }else if (binaryButton.isSelected()) {
                    output.setText(myCon.textToBinary(input.getText()));
                }
                setTitle(title + "*" + " - " + "Technical Editor");
            }
        });
        hexButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saved = false;
                output.setText(myCon.textToHEX(input.getText()));
                binaryButton.setSelected(false);
            }
        });

        binaryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saved = false;
                output.setText(myCon.textToBinary(input.getText()));
                hexButton.setSelected(false);
            }
        });

        Open.addActionListener(e -> {
            try {
                myReader.chooseFilePath();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            input.setText(myReader.getContent());

            this.title = (myReader.getPath());
            setTitle(title + " - " + "Technical Editor");
        });

        Save.addActionListener(e -> {
            if(myReader.getPath().equals(" ")){
                myReader.setContent(input.getText());
                myReader.setContentOutput(output.getText());

                myReader.chooseFilePathWrite();
                saved = true;
                title = myReader.getPath();
                setTitle(title + " - " + "Technical Editor");
            }
            myReader.setContent(input.getText());
            myReader.setContentOutput(output.getText());
            myReader.writeFile(myReader.getPath());
            saved = true;
            setTitle(title + " - " + "Technical Editor");
        });

        Save_As.addActionListener(e -> {
            myReader.setContent(input.getText());
            myReader.setContentOutput(output.getText());
            myReader.chooseFilePathWrite();
            saved = true;
            title = myReader.getPath();
            setTitle(title + " - " + "Technical Editor");
        });

        Stats.addActionListener(e -> {
            if(binaryButton.isSelected()){
                JOptionPane.showMessageDialog(null, myBinaryStatistic(output.getText()), "Statistics", JOptionPane.INFORMATION_MESSAGE);
            } else if(hexButton.isSelected()){
                JOptionPane.showMessageDialog(null, myHexStatistic(output.getText()), "Statistics", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        /**
         * Shortcut strg + s
         */
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
    }


    public String myBinaryStatistic(String myText) {
        String result = "";

        int zero = 0;
        int ones = 0;
        String myStr = myText;
        for (int i = 0; i < myStr.length(); i++) {
            String myValue = String.valueOf((myStr.charAt(i)));
            if (myValue.equals("0")) {
                zero++;
            } else if (myValue.equals("1")) {
                ones++;
            }
        }
        result = "0: " + zero + "\n" + "1: " + ones;
        return result;
    }

    public String myHexStatistic(String myText) {
        String result = "";

        int zero = 0;
        int ones = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int ee = 0;
        int f = 0;

        String myStr = myText;
        for (int i = 0; i < myStr.length(); i++) {
            String myValue = String.valueOf((myStr.charAt(i)));
            if(myValue.equals("0")){
                zero++;
            } else if (myValue.equals("1")) {
                ones++;
            } else if (myValue.equals("2")) {
                two++;
            }
            else if (myValue.equals("3")) {
                three++;
            }
            else if (myValue.equals("4")) {
                four++;
            }
            else if (myValue.equals("5")) {
                five++;
            }else if (myValue.equals("6")) {
                six++;
            }
            else if (myValue.equals("7")) {
                seven++;
            }
            else if (myValue.equals("8")) {
                eight++;
            }
            else if (myValue.equals("9")) {
                nine++;
            }
            else if (myValue.equals("A")) {
                a++;
            }
            else if (myValue.equals("B")) {
                b++;
            }
            else if (myValue.equals("C")) {
                c++;
            }else if (myValue.equals("D")) {
                d++;
            }else if (myValue.equals("E")) {
                ee++;
            }else if (myValue.equals("F")) {
                f++;
            }

        }
        result = "0: " + zero
                + "\n" + "1: " + ones
                + "\n" + "2: " + two
                + "\n" + "3: " + three
                + "\n" + "4: " + four
                + "\n" + "5: " + five
                + "\n" + "6: " + six
                + "\n" + "7: " + seven
                + "\n" + "8: " + eight
                + "\n" + "9: " + nine
                + "\n" + "A: " + a
                + "\n" + "B: " + b
                + "\n" + "C: " + c
                + "\n" + "D: " + d
                + "\n" + "E: " + ee
                + "\n" + "F: " + f;

        return result;
    }



/*
    public String myStatistics(String myText){
        String result = "";
        if(binaryButton.isSelected()){
            int zero = 0;
            int ones = 0;
            String myStr = myText;
            for (int i = 0; i < myStr.length(); i++) {
                String myValue = String.valueOf((myStr.charAt(i)));
                if(myValue.equals("0")){
                    zero++;
                } else if (myValue.equals("1")) {
                    ones++;
                }
            }
            result = "0: " + zero + "\n" + "1: " + ones;

            return  result;

        } else if (hexButton.isSelected()) {
            int zero = 0;
            int ones = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            int nine = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int ee = 0;
            int f = 0;

            String myStr = myText;
            for (int i = 0; i < myStr.length(); i++) {
                String myValue = String.valueOf((myStr.charAt(i)));
                if(myValue.equals("0")){
                    zero++;
                } else if (myValue.equals("1")) {
                    ones++;
                } else if (myValue.equals("2")) {
                    two++;
                }
                else if (myValue.equals("3")) {
                    three++;
                }
                else if (myValue.equals("4")) {
                    four++;
                }
                else if (myValue.equals("5")) {
                    five++;
                }else if (myValue.equals("6")) {
                    six++;
                }
                else if (myValue.equals("7")) {
                    seven++;
                }
                else if (myValue.equals("8")) {
                    eight++;
                }
                else if (myValue.equals("9")) {
                    nine++;
                }
                else if (myValue.equals("A")) {
                    a++;
                }
                else if (myValue.equals("B")) {
                    b++;
                }
                else if (myValue.equals("C")) {
                    c++;
                }else if (myValue.equals("D")) {
                    d++;
                }else if (myValue.equals("E")) {
                    ee++;
                }else if (myValue.equals("F")) {
                    f++;
                }

            }
            result = "0: " + zero
                    + "\n" + "1: " + ones
                    + "\n" + "2: " + two
                    + "\n" + "3: " + three
                    + "\n" + "4: " + four
                    + "\n" + "5: " + five
                    + "\n" + "6: " + six
                    + "\n" + "7: " + seven
                    + "\n" + "8: " + eight
                    + "\n" + "9: " + nine
                    + "\n" + "A: " + a
                    + "\n" + "B: " + b
                    + "\n" + "C: " + c
                    + "\n" + "D: " + d
                    + "\n" + "E: " + ee
                    + "\n" + "F: " + f;

            return  result;
        }
        return result;
    }
*/

}
