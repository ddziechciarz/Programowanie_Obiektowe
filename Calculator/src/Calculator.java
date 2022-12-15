import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {



    static JTextField textField;
    private static int temp, num1, num2;
    private static String lastOperator;
    private static Input lastInput = Input.ACTION;
    static boolean zeroDivision = false;
    static boolean solved = true;
    static boolean hasBeenSolved = true;

    enum Input {
        NUMBER,
        EQUAL,
        ACTION,
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

    public static void createAndShowGUI() {

        ActionListener myActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                switch (buttonPressed) {
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
                        PressNum(buttonPressed);
                        break;
                    case "+", "-", "*", "/":
                        PressOperator(buttonPressed);
                        break;
                    case "=":
                        PressEq();
                        break;
                    case "C":
                        CleanCalc();
                        break;
                    default:
                        System.out.println("Nieznany przycisk");
                }
            }
        };

        JFrame jf = new JFrame("Calculator");
        JPanel jp = new JPanel();

        // Generowanie przyciskow funkcyjnych
        JButton [] FuncButton = new JButton[6];
        JButton addButton,difButton,mulButton,divButton,eqButton,clcButton;

        addButton = new JButton("+");
        difButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clcButton = new JButton("C");

        FuncButton[0] = addButton;
        FuncButton[1] = difButton;
        FuncButton[2] = mulButton;
        FuncButton[3] = divButton;
        FuncButton[4] = eqButton;
        FuncButton[5] = clcButton;

        for(int i =0; i< FuncButton.length; i++) {
            FuncButton[i].addActionListener(myActionListener);
            FuncButton[i].setFocusable(false);
        }

        // Generowanie przycisków z cyframi
        JButton [] NumButtons = new JButton[10];
        for(int i =0; i< NumButtons.length; i++) {
            NumButtons[i] = new JButton(String.valueOf(i));
            NumButtons[i].addActionListener(myActionListener);
            NumButtons[i].setFocusable(false);
        }

        // Wrzucenie wszystkiego w pane
        jp.setBounds(5,50,300,200);
        jp.setLayout(new GridLayout(5,4,10,5));
        jp.add(NumButtons[1]);jp.add(NumButtons[2]);jp.add(NumButtons[3]);jp.add(FuncButton[0]);
        jp.add(NumButtons[4]);jp.add(NumButtons[5]);jp.add(NumButtons[6]);jp.add(FuncButton[1]);
        jp.add(NumButtons[7]);jp.add(NumButtons[8]);jp.add(NumButtons[9]);jp.add(FuncButton[2]);
        jp.add(NumButtons[0]);jp.add(FuncButton[5]);jp.add(FuncButton[4]);jp.add(FuncButton[3]);

        // Ustawienia text field
        textField = new JTextField();
        textField.setBounds(5, 5, 300, 30);
        textField.setFont(new Font("Arial", Font.BOLD,16));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setText("0");

        // Ustawienia okna
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setSize(320, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Dodanie pól do okna
        jf.add(textField);
        jf.add(jp);
        jf.setVisible(true);
    }

    private static void PressEq() {
        if (zeroDivision) {
            return;
        }
        if (lastOperator == null) {
            solved = true;
            lastInput = Input.ACTION;
            hasBeenSolved = true;
            if (!textField.getText().isEmpty()) {
                num2 = Integer.parseInt(textField.getText());
            }
            return;
        }
        if (lastInput == Input.EQUAL) {
            num2 = temp;
        } else {
            temp = num2;
            num1 = Integer.parseInt(textField.getText());
        }
        switch (lastOperator) {
            case "+":
                temp = num2 + num1;
                break;
            case "-":
                temp = num2 - num1;
                break;
            case "*":
                temp = num2 * num1;
                break;
            case "/":
                if (num1 == 0) {
                    CleanCalc();
                    textField.setText("can't divide by 0!");
                    zeroDivision = true;
                    return;
                }
                temp = num2 / num1;
                break;
        }
        textField.setText(String.valueOf(temp));
        lastInput = Input.EQUAL;
        solved = true;
    }
    public static void CleanCalc() {
        textField.setText("0");
        num1 = 0;
        num2 = 0;
        lastOperator = null;
        lastInput = Input.ACTION;
        hasBeenSolved = true;
        zeroDivision = false;
    }

    public static void PressNum(String pressed) {
        if (zeroDivision) {
            return;
        }
        if (lastInput == Input.ACTION || textField.getText().startsWith("0")) {
            textField.setText("");
        }
        if (lastInput == Input.EQUAL) {
            textField.setText("");
            lastOperator = null;
        }
        textField.setText(textField.getText().concat(pressed));
        lastInput = Input.NUMBER;
    }

    private static void PressOperator(String pressed) {
        if (zeroDivision) {
            return;
        }
        if(lastInput == Input.ACTION) {
            lastOperator = pressed;
            solved = false;
            return;
        }
        if (!solved) {
            PressEq();
            solved = true;
        }
        num2 = Integer.parseInt(textField.getText());
        lastOperator = pressed;
        solved = false;
        lastInput = Input.ACTION;
    }






}
