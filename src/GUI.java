import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GUI implements ActionListener {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args){

        JFrame frame = new JFrame(); //framed window

        //config for framed window to pop-up
        frame.setSize(350, 200); //100x100 window pixel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //invisible border guidelines(layout)
        JPanel panel = new JPanel();

        //put panel on the frame
        frame.add(panel);
        panel.setLayout(null);

        //Create User Label
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //Create User Text Field
        userText = new JTextField(20); //text field w 20 columns
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        //Create Password Label
        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);

        //Create Password Text Field
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        //Create Login Button
        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());

        panel.add(button);

        //Create label for successful login
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);


        frame.setVisible(true);



    }
    //implements ActionListener, so this code will run everytime the login button is clicked
    //need to increase the scope, to access easier here
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String user = userText.getText();
        String password = passwordText.getText();

        //cvs, comma separated values
        String fileName = "login-credential.csv";

        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String userName = scan.next().replace(",", "");
                String userPass = scan.next();
                if(userName.equals(user) && userPass.equals(password)){
                    success.setText("Login successful!");
                }
                else{
                    success.setText("Incorrect login credentials");
                }
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
