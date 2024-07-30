import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prepare {

    public static void main(String[] args) throws Exception {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "bca");

            System.out.println("Open database successfully!");
            PreparedStatement stm = c.prepareStatement("insert into emp1 values(?,?,?)");
            stm.setInt(1, 23);
            stm.setString(2, "abc");
            stm.setString(3, "CEO");
            stm.executeUpdate();
            stmt = c.createStatement();
            String query = "select *from emp1";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID  Name  Job");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                System.out.println(id + " " + name + " " + job);
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

    }
}
