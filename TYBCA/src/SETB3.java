import java.sql.*;
import java.io.*;

public class SETB3 {
    public static void main(String[] args) throws Exception {
        Connection con;
        ResultSet rs;
        Statement t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "bca");
        do {
            System.out.println("\n1.Insert\n2.Modify\n3.Delete\n4.Search\n5.View all\n6.Exit");
            System.out.println("Enter the choice");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    System.out.println("Enter the name");
                    String n = br.readLine();
                    System.out.println("Enter the area");
                    String a = br.readLine();
                    System.out.println("Enter the population");
                    int p = Integer.parseInt(br.readLine());
                    t = con.createStatement();
                    t.executeUpdate("insert into district values('" + n + "','" + a + "'," + p + ")");
                    break;
                case 2:
                    System.out.println("Enter the name for update record");
                    n = br.readLine();
                    System.out.println("Enter the area");
                    a = br.readLine();
                    System.out.println("Enter the population");
                    p = Integer.parseInt(br.readLine());
                    t = con.createStatement();
                    t.executeUpdate("update district set n='" + n + "',p=" + p + " where a='urban';");
                    break;
                case 3:
                    System.out.println("Enter the  population for delete record");
                    n = br.readLine();
                    t = con.createStatement();
                    t.executeUpdate("delete from district where p=1000;");
                    break;
                case 4:
                    System.out.println("Enter the area for search");
                    n = br.readLine();
                    t = con.createStatement();
                    rs = t.executeQuery("select * from district where a='urban';");
                    while (rs.next()) {
                        System.out.println("name=" + rs.getString(1));
                        System.out.println("area=" + rs.getString(2));
                        System.out.println("population=" + rs.getInt(3));
                    }
                    break;
                case 5:
                    t = con.createStatement();
                    rs = t.executeQuery("select * from district");
                    while (rs.next()) {
                        System.out.println("name=" + rs.getString(1));
                        System.out.println("area=" + rs.getString(2));
                        System.out.println("population=" + rs.getInt(3));
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
