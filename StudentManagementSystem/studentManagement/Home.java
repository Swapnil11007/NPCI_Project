package studentManagement;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

//        JLabel heading = new JLabel("Student Management System");
//        heading.setBounds(620, 20, 400, 40);
//        heading.setFont(new Font("TAHOMA", Font.BOLD, 25));
//        image.add(heading);

        add = new JButton("Add Student");
        add.setBounds(245, 140, 150, 40); //
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Student");
        view.setBounds(730, 140, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Student");
        update.setBounds(245, 487, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Student");
        remove.setBounds(730, 487, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(50, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {  // tell which button is pressed or gives the source that which button is pressed
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewStudent();
        } else {
            setVisible(false);
            new RemoveStudent();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
