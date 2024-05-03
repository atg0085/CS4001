import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//imports required for the text fields and such

public class PhoneCallSimulator implements ActionListener
{
    //declare buttons and text boxes etc
    private JTextField durationTextField;
    private JTextField creditsTextField;
    private JButton callButton;
    private JButton clearButton;
    private JFrame frame;
    private int credits = 1000; //starting credits, unable to change (yet)

    public PhoneCallSimulator()
    {
        
        //constructor for said buttons and boxes etc
        
        frame = new JFrame("Phone Call Simulator");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        durationTextField = new JTextField(15);
        contentPane.add(durationTextField);        

        callButton = new JButton("Call");
        contentPane.add(callButton);
        callButton.addActionListener(this);       

        clearButton = new JButton("Clear");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        
        creditsTextField = new JTextField(15);
        contentPane.add(creditsTextField);        
        
        frame.pack(); 
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //allows the program to run in command prompt
        //probably
        //i hope
        PhoneCallSimulator simulator = new PhoneCallSimulator();
    }

    public void actionPerformed(ActionEvent event)
    {
        //decides what to do when you press a button
        String command = event.getActionCommand();
        if (command.equals("Call")) {
            makeCall();
        }
        if (command.equals("Clear")) {
            clear();
        }
    }
    
    public int getCallDuration()
    {
        //generic getter method, nothing to see here
        int callDuration = Integer.parseInt(durationTextField.getText());
        return callDuration;
    }

    public void makeCall()
    {
        /*
         * simple function to make a call for x minutes,
         * if the available credit amount is less than the
         * call duration, the function does nothing and 
         * instead says no credits. else it pastes the 
         * remaining amount of credits left
         */
        
        int callDuration = getCallDuration();
        if (callDuration <= credits) {
            credits = credits - callDuration;
            creditsTextField.setText("" + credits);
        } else {
            creditsTextField.setText("Insufficient credits...");
        }
    }
    
    public void clear()
    {
        //simple procedure, sets contents to a blank string
        durationTextField.setText("");
        creditsTextField.setText("");
    }
}
