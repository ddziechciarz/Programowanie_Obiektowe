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
        writeOutput();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                addToPrint(numberButtons[i].getText());
            }

        }
        if(e.getSource() == addButton){
            System.out.println("Pressed Add Button");
            OperatorPressed(addButton.getText());
        }
        if(e.getSource() == subsButton){
            System.out.println("Pressed subs Button");
            OperatorPressed(addButton.getText());
            addToPrint("-");
        }
        if(e.getSource() == multButton){
            System.out.println("Pressed mult Button");
            OperatorPressed(multButton.getText());
        }
        if(e.getSource() == divButton){
            System.out.println("Pressed div Button");
            OperatorPressed(divButton.getText());
        }
        if(e.getSource() == clrsButton){
            first = "";
            second = "0";
            operator = "";
        }
        if(e.getSource() == eqButton){
            if(first.length() > 0 && second.length() > 0){
                num1 = Double.parseDouble(first);
                num2 = Double.parseDouble(second);
//                switch (operator){
//                    case "+":
//                        resault = num1 + num2;
//                        break;
//                    case "-":
//                        resault = num1 - num2;
//                        break;
//                    case "*":
//                        resault = num1 * num2;
//                        break;
//                    case "/":
//                        if(num2 == 0){
//                            textField.setText("Error, division by 0");
//                            return;
//                        }
//                        resault = num1 / num2;
//                        break;
//                }
//                first = Integer.toString((int)num2);
//                second = Integer.toString((int)Math.floor(resault));
                Calculate(num1, num2, operator);
                return;
            }
        }
        writeOutput();
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