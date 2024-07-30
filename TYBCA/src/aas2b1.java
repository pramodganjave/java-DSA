import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class aas2b1 {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "kali");

            stmt = c.createStatement();
            String sql = "UPDATE course set number_of_students = 1000 WHERE department = 'bca science';";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM course;");
            while (rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int number_of_students = rs.getInt("number_of_students");

                System.out.println("code = " + code);
                System.out.println("name = " + name);
                System.out.println("department = " + department);
                System.out.println("number_of_students = " + number_of_students);
                System.out.println("--------------------------------------------");

            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}