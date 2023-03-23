import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
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
        
        JTextField userField = new JTextField("Enter_User");
        JPasswordField passField = new JPasswordField("Enter Password");
        if (new File("Private.txt").exists()) {
            File file = new File("Private.txt");

            Scanner s = new Scanner(file);
             userField.setText(s.nextLine());
            passField.setText(s.nextLine());
            
            

        }
        JButton login = new JButton("login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed() throws IOException, InterruptedException {
                if (App.connect(userField.getText(), passField.getPassword())) {
                    App.start();
                } 
                else{
                    login.setText("Fail. Try Again");
                }
            }

            
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if (App.connect(userField.getText(), passField.getPassword())) {
                        login.setText("Success!");
                        int x =0;
while (!(new File("stocks").exists()) || x==0) {
    File setup = new File("stocks");
    setup.mkdir();
    File[] files = new File("stocks").listFiles();
    while (x!=1) {
        try {
            // Your code...
            System.out.println(files.length);
            App.start();
            System.out.println("don");
            x=1;

           } catch (Exception ignore) { }

    }
    userField.setVisible(false);
    passField.setVisible(false);

}
                        
                    } 
                    else{
                        login.setText("Fail. Try Again");
                    }
                } catch (IOException | InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } }
            
        });
        userField.setBounds(500, 20, 100, 50);
        passField.setBounds(500, 90, 100, 50);
        login.setBounds(500, 150, 100, 20);
        f.setLayout(null);  
        f.add(login);
        f.setBounds(500, 0, 1000, 500);
        f.add(userField);
        f.add(passField);
        f.addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
            }
        });

    }
}
