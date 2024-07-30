import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class ASS1A2 {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "bca");
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("select * from person");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Number of columns available: " + rsmd.getColumnCount());
            System.out.println("Type of first column: " + rsmd.getColumnTypeName(1));
            System.out.println("Type of second column: " + rsmd.getColumnTypeName(2));
            System.out.println("Type of third column: " + rsmd.getColumnTypeName(3));
            System.out.println("Type of fourth column: " + rsmd.getColumnTypeName(4));
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}