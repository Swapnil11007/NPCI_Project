package studentManagement;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//connecting driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "NPCI1234", "NPCI1234");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
