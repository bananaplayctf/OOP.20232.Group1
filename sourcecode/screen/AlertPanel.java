package screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertPanel extends JPanel{
    private JLabel alertLabel;
    
    public AlertPanel(){
        setLayout(new FlowLayout());
        setVisible(false);
        setBounds(250, 550, 450, 100);
        alertLabel = new JLabel("Short Circuit is found!!!");
		alertLabel.setFont(new Font("Arial", Font.BOLD, 20));
		alertLabel.setForeground(Color.RED);
		alertLabel.setSize(250, 30);

		add(alertLabel);
    }

    public void showErrorMessage(ArrayList<String> errorList){
        setVisible(true);
        String errorMess = "Message: ";
        for(String erroString : errorList){
            errorMess += erroString + ", ";
        }
        if (errorList.size() == 0){
            errorMess += "Equivalent resistance equals to 0!!!!";
        }
        else{
            errorMess += "have the resistance equals to 0!";
        }
        JLabel errorLabel = new JLabel();
        errorLabel.setText(errorMess);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        JLabel tryAgainLabel = new JLabel("Please change the electrical component!!");
        tryAgainLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        tryAgainLabel.setForeground(Color.BLACK);
        add(tryAgainLabel);
    }
}
