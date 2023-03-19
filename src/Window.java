import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;    

public class Window {
    public Window() throws IOException{
        Frame f = new Frame();
        f.setTitle("Gambit Trading");
        File logopath = new File("lib/logo.png");
        Image logo = ImageIO.read(logopath);
        f.setIconImage(logo);
        f.setSize(500,500);
        f.setVisible(true);
        
        JTextField userField = new JTextField("Enter User");
        JPasswordField passField = new JPasswordField("Enter Password");
        JButton login = new JButton("login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed() {
                App.start();
            }

            
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
App.start();            }
            
        });
        userField.setBounds(50, 20, 100, 50);
        passField.setBounds(50, 90, 100, 50);
        login.setBounds(50, 150, 100, 20);
        f.setLayout(null);  
        f.add(login);
        f.add(userField);
        f.add(passField);
        

    }
}
