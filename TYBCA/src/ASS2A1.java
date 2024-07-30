import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ASS2A1 {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "bca");
            c.setAutoCommit(false);
            System.out.println("opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person;");
            while (rs.next()) {
                int pid = rs.getInt("pid");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                float birth_year = rs.getFloat("birth_year");
                System.out.println("PID = " + pid);
                System.out.println("NAME = " + name);
                System.out.println("GENDER = " + gender);
                System.out.println("BIRTH_YEAR = " + birth_year);
                System.out.println();

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
