import java.sql.*;
public class Conn1{
    Connection c;
    Statement s;
    public Conn1(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///shashidhar", "root", "shashi3927");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
