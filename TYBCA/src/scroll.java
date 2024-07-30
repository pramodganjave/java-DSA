import java.sql.*;


public class scroll
{

    public static void main(String[] args) throws Exception
{
    Connection c=null;
    Statement stmt=null;    
       
    Class.forName("org.postgresql.Driver");
    c=DriverManager.getConnection("jdbc:postgresql://localhost/pg", "postgres", "bca");
                System.out.println("Open database successfully!");
    stmt=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs=stmt.executeQuery("select * from emp");
    rs.absolute(1);
    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
    c.close();
            }
    
}