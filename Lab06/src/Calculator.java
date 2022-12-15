import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    JFrame jf;
    JButton[] numberButtons = new JButton[10];
    JButton[] funcButtons = new JButton[6];
    JButton addButton, subsButton, multButton, divButton, eqButton, clrsButton;
    JPanel buttons;
    JTextField textField;
    Font resaultFont = new Font("Arial",Font.BOLD,16);
    double num1 = 0, num2 = 0, resault = 0, helper = 0;
    String first = "", second = "0", operator;
    boolean justPressedEq = false;

    Calculator(){
        // frame setting
        jf = new JFrame("Calculator");
        jf.setSize(450,300);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);

        // texfield settings
        textField = new JTextField();
        textField.setBounds(0,0,435,40);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setText("0");
        textField.setFont(resaultFont);

        // adding buttons in panel buttons


        addButton = new JButton("+");
        subsButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrsButton = new JButton("C");

        funcButtons[0] = addButton;
        funcButtons[1] = subsButton;
        funcButtons[2] = multButton;
        funcButtons[3] = divButton;
        funcButtons[4] = eqButton;
        funcButtons[5] = clrsButton;

        for(int i = 0; i < funcButtons.length; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFocusable(false);
        }

        String[] calcButtonsNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i = 0; i < calcButtonsNumbers.length; i++){
            numberButtons[i] = new JButton(calcButtonsNumbers[i]);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        buttons = new JPanel();
        buttons.setBounds(0,50, 450, 210);
        buttons.setLayout(new GridLayout(4,4,10,5));

        buttons.add(numberButtons[1]);
        buttons.add(numberButtons[2]);
        buttons.add(numberButtons[3]);
        buttons.add(addButton);
        buttons.add(numberButtons[4]);
        buttons.add(numberButtons[5]);
        buttons.add(numberButtons[6]);
        buttons.add(subsButton);
        buttons.add(numberButtons[7]);
        buttons.add(numberButtons[8]);
        buttons.add(numberButtons[9]);
        buttons.add(multButton);
        buttons.add(numberButtons[0]);
        buttons.add(eqButton);
        buttons.add(clrsButton);
        buttons.add(divButton);

        jf.add(textField, BorderLayout.NORTH);
        jf.add(buttons, BorderLayout.SOUTH);
        jf.setVisible(true);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void writeOutput(){
        textField.setText(second);
    }

    public void addToPrint(String txt){
        if(second =="0"){
            second = "";
        }
        second += txt;
    }

    public void OperatorPressed(String opr){

        if(second.isEmpty()){
            return;
        }
        if(first.isEmpty()){
            first = second;
            second = "";
        }
        System.out.println(first + " " + second);
        second = "";
        operator = opr;
        //writeOutput();
    }

    public void OperatorButtonPressed(JButton button){
        if(!first.isEmpty() && !second.isEmpty() && justPressedEq==false && second!="-"){
            num1 = Double.parseDouble(first);
            num2 = Double.parseDouble(second);
            Calculate(num1, num2, operator);
            System.out.println(first + " wynik działania");
            textField.setText(first);
        }
        OperatorPressed(button.getText());
        System.out.println("F: " + first + " S: " + second);
        justPressedEq = false;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                addToPrint(numberButtons[i].getText());
                System.out.println("F: " + first + " S: " + second);
                writeOutput();
            }

        }
        if(e.getSource() == addButton){
            OperatorButtonPressed(addButton);

        }
        if(e.getSource() == subsButton){
            if(!second.isEmpty()){
                OperatorButtonPressed(subsButton);
            }
            else{
                second = "0";
            }

            return;

        }
        if(e.getSource() == multButton){
            OperatorButtonPressed(multButton);
        }
        if(e.getSource() == divButton){
            OperatorButtonPressed(multButton);
        }
        if(e.getSource() == clrsButton){
            first = "";
            second = "0";
            operator = "";
            textField.setText(second);
        }
        if(e.getSource() == eqButton){
            System.out.println("performing " + operator + " on first: " + first + " and second: " + second);
            if(first.length() > 0 && second.length() > 0 && second!="-"){

                num1 = Double.parseDouble(first);
                num2 = Double.parseDouble(second);
                Calculate(num1, num2, operator);
                justPressedEq = true;
            }
        }

    }

    public void Calculate(double n1, double n2, String operator){
        double rs = 0;
        switch (operator){
            case "+":
                rs = n1 + n2;
                break;
            case "-":
                rs = n1 - n2;
                break;
            case "*":
                System.out.println("multiplying " + n1 + " " + n2);
                rs = n1 * n2;
                break;
            case "/":
                if(n2 == 0){
                    textField.setText("Error, division by 0");
                    return;
                }
                rs = n1 / n2;
                break;
        }
        first = Integer.toString((int)Math.floor(rs));
        second = Integer.toString((int)n2);
        textField.setText(first);
    }
    public static void main(String[] args) {

        Calculator cal = new Calculator();
    }
}