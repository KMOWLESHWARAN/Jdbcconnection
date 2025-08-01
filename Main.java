import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Main{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","MOULY@2005");
        if(con!=null){
            System.out.println("Connection Established");
        }else{
            System.out.println("Failed to Establsh");
        }
        con.close();
    }
}
