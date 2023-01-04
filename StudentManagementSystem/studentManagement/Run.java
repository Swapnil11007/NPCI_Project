package studentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Run extends JFrame implements ActionListener {

    Run() {

        getContentPane().setBackground(Color.WHITE);// changing color of the window by awt package
        setLayout(null); // don't want to use layout of swing

//        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM"); // to adding heading on window
//        heading.setBounds(80, 30, 1200, 60);
//        heading.setFont(new Font("serif", Font.PLAIN, 60)); // setting location of heading
//        heading.setForeground(Color.RED); // setting color of the heading
//        add(heading); // adding component on window or frame

        // using images on frame or window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front_m.jpg"));// getting images from system
        Image i2 = i1.getImage().getScaledInstance(1100, 630, Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2); // converting image into image icon
        JLabel image = new JLabel(i3);  // creating jlabel to insert image on frame
        image.setBounds(0, 0, 1200, 650);// setting location of image of jlabel class
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO LOGIN"); // to add button on frame
        clickhere.setBounds(550, 500, 200, 50);
        clickhere.setBackground(Color.orange);
        clickhere.setForeground(Color.DARK_GRAY);
        clickhere.addActionListener(this);//click on button
        image.add(clickhere);// adding button on w.r.t image


        setSize(1200, 700); // frame size
        setLocation(0,0);  // location of frame on window
        setVisible(true); // frame will be visible

//       while(true) {
//            heading.setVisible(false);   // using to splash heading for 0.5 second
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//
//            }
//
//            heading.setVisible(true);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//
//            }
//        }
    }

    public void actionPerformed(ActionEvent ae) {// overriding the method what to do after clicking on button
        setVisible(false);//current frame close
        new Login();//opens the login frame
    }

    public static void main(String args[]) {
        new Run();
    }
}
