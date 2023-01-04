package studentManagement;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tffee, tfdepart;
    JDateChooser dcdob;
    JComboBox cbcourse;
    JLabel lblroll;
    JButton add, back;

    AddStudent() {
    	 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0, 900, 700);
         add(image);
         
        
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

//        JLabel heading = new JLabel("Add Student Details");
//        heading.setBounds(320, 30, 500, 50);
//        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
//        image.add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        image.add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        image.add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeldob);

        dcdob = new JDateChooser();// using date chooser
        dcdob.setBounds(200, 200, 150, 30);
        image.add(dcdob);

        JLabel labelfee = new JLabel("Annual Fee");
        labelfee.setBounds(400, 200, 150, 30);
        labelfee.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelfee);

        tffee = new JTextField();
        tffee.setBounds(600, 200, 150, 30);
        image.add(tffee);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        image.add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        image.add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        image.add(tfemail);

        JLabel labeleducation = new JLabel("Course");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbcourse = new JComboBox(courses);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(600, 300, 150, 30);
        image.add(cbcourse);

        JLabel labeldepart = new JLabel("Department");
        labeldepart.setBounds(50, 350, 150, 30);
        labeldepart.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeldepart);

        tfdepart = new JTextField();
        tfdepart.setBounds(200, 350, 150, 30);
        image.add(tfdepart);

        JLabel labelaadhar = new JLabel("Aadhaar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        image.add(tfaadhar);

        JLabel labelroll = new JLabel("Roll No.");
        labelroll.setBounds(50, 400, 150, 30);
        labelroll.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelroll);

        lblroll = new JLabel("" + number);
        lblroll.setBounds(200, 400, 150, 30);
        lblroll.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblroll);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);

        setSize(900, 700);
        setLocation(100, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();// taking the dob from
            String fee = tffee.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = (String) cbcourse.getSelectedItem();// returns object 
            String depart = tfdepart.getText();
            String aadhar = tfaadhar.getText();
            String roll = lblroll.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into student values('"+name+"', '"+fname+"', '"+dob+"', '"+fee+"', '"+address+"', '"+phone+"', '"+email+"', '"+course+"', '"+depart+"', '"+aadhar+"', '"+roll+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
