import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {CreateAndShowGUI();}
        });
    }

    public static void CreateAndShowGUI(){
        // frame settings
        JFrame jf = new JFrame("Calculator");
        jf.setSize(600,200);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(new BorderLayout());

        // texfield settings
        JTextField textfield = new JTextField();
        textfield.setBounds(0,5,400,50);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setText("test");
        jf.add(textfield);
        Font scoreFont = new Font("Arial",Font.BOLD,16);
        textfield.setFont(scoreFont);


        JPanel buttons = new JPanel();
        buttons.setSize(600,300);

        // adding buttons in panel buttons
        jf.getContentPane().add(buttons, BorderLayout.SOUTH);
        buttons.setLayout(new GridLayout(4, 4));
        String[] calcButtons = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};
        for(String mark:calcButtons){
            JButton button = new JButton(mark);
            button.setFont(scoreFont);
            buttons.add(button);
        }


        /*JPanel numbers = new JPanel();
        JPanel resault = new JPanel();
        JPanel operators = new JPanel();


        jf.getContentPane().add(numbers, BorderLayout.WEST);
        jf.getContentPane().add(resault, BorderLayout.NORTH);
        jf.getContentPane().add(operators, BorderLayout.EAST);


        numbers.setLayout(new GridLayout(4, 4));
        resault.setLayout(new FlowLayout());
        operators.setLayout(new GridLayout(5, 1));

        numbers.setPreferredSize(new Dimension(400, 400));
        operators.setPreferredSize(new Dimension(100, 400));
        //adding number buttons
        JButton b[] = new JButton[10];

        for(int i = 1; i <= 9; i++){
            b[i] = new JButton(Integer.toString(i));
            numbers.add(b[i]);
        }

        b[0] = new JButton(Integer.toString(0));
        numbers.add(b[0]);

        //adding resault field
        JLabel label1 = new JLabel("resault");
        label1.setText("0");
        resault.add(label1);

        //adding operators field
        String[] operatorsString = {"+", "-", "*", "/", "=" };
        for (String operator: operatorsString) {
            JButton jb = new JButton(operator);
            operators.add(jb);
        }
        */
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}