package solution;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/** 
 * @author Ryon McAuley
 * @version 2/7/18
 */
public class Calculator
{
    private JFrame calculator = new JFrame();
    private float result;
    private String s;
    private JLabel resultL = new JLabel();
    private JPanel resultP = new JPanel();

    public Calculator()
    {
        calculator.setLocation(100, 100);
        calculator.setSize(100, 100);
        calculator.setTitle("Calculator");
        initializeParts();
        calculator.pack();
        calculator.setVisible(true);
    }
    /**
      * Begins initializing all the necessary parts.
      */
    public void initializeParts()
    {
        initializeButtons();
        
    }
    /**
     * Called by initializeParts(), makes the buttons.
     */
    public void initializeButtons()
    {
        JPanel textPanel = new JPanel();
        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        text1.setName("leftOperand");
        text2.setName("rightOperand");
        textPanel.add(text1);
        textPanel.add(text2);
        calculator.add(textPanel, BorderLayout.PAGE_START);

        JPanel buttonPanel = new JPanel();
        
        JButton addButton = new JButton("ADD");
        addButton.setName("addButton");
        buttonMechAdd(addButton, text1, text2); 
        JButton subButton = new JButton("SUB");
        subButton.setName("subButton");
        buttonMechSub(subButton, text1, text2); 
        JButton multButton = new JButton("MULT");
        multButton.setName("multButton");
        buttonMechMult(multButton, text1, text2); 
        JButton divButton = new JButton("DIV");
        divButton.setName("divButton");
        buttonMechDiv(divButton, text1, text2); 
        
        //JButton addButton = new JButton("Couch Potato");
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);
        
        calculator.add(buttonPanel, BorderLayout.PAGE_END);
        resultL.setText("Result = ");
        resultL.setName("resultLabel");
        resultP.add(resultL, BorderLayout.LINE_START);
        calculator.add(resultP, BorderLayout.LINE_START);
    }
    /**
     * 
     */
    public void makeResults()
    {
        //resultL.setName("resultLabel");
        //resultL.setText("");
        resultL.setText("Result = " + s);        
        //resultP.add(resultL, BorderLayout.LINE_START);
        //calculator.add(resultP, BorderLayout.LINE_START);
        calculator.pack();
    }
    /**
     * @param button is the button
     * @param textA is the text1 field
     * @param textB is the text2 field
     */
    public void buttonMechAdd(JButton button, JTextField textA,
        JTextField textB)
    {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int num1 = Integer.parseInt(textA.getText());
                    int num2 = Integer.parseInt(textB.getText());
                    result = num1 + num2;
                    s = Float.toString(result);
                }
                catch (NumberFormatException n)
                {
                    s = "Error";
                }
                makeResults();
            }
        });
    }
    /**
     * @param button is the button
     * @param textA is the text1 field
     * @param textB is the text2 field
     */
    public void buttonMechSub(JButton button, JTextField textA,
        JTextField textB)
    {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int num1 = Integer.parseInt(textA.getText());
                    int num2 = Integer.parseInt(textB.getText());
                    result = num1 - num2;
                    s = Float.toString(result);
                }
                catch (NumberFormatException n)
                {
                    s = "Error";
                }
                makeResults();
            }
        });
    }
    /**
     * @param button is the button
     * @param textA is the text1 field
     * @param textB is the text2 field
     */
    public void buttonMechMult(JButton button, JTextField textA,
        JTextField textB)
    {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int num1 = Integer.parseInt(textA.getText());
                    int num2 = Integer.parseInt(textB.getText());
                    result = num1 * num2;
                    s = Float.toString(result);
                }
                catch (NumberFormatException n)
                {
                    s = "Error";
                }
                makeResults();
            }
        });
    }
    /**
     * @param button is the button
     * @param textA is the text1 field
     * @param textB is the text2 field
     */
    public void buttonMechDiv(JButton button, JTextField textA,
        JTextField textB)
    {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int num1 = Integer.parseInt(textA.getText());
                    int num2 = Integer.parseInt(textB.getText());
                    result = num1 / num2;
                    s = Float.toString(result);
                }
                catch (NumberFormatException n)
                {
                    s = "Error";
                }
                catch (ArithmeticException n)
                {
                    s = "Error";
                }
                makeResults();
            }
        });
    }
    /**
     *@return the calculator 
     */
    public JFrame getFrame()
    {
        return calculator;
    }
    
    /**
     * @param args fun things
     */
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}
