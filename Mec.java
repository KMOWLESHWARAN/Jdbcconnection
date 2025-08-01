import java.sql.*;

public class Mec {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mec";
    private static final String USER = "root";
    private static final String PASS = "MOULY@2005";

    public static void main(String[] args) {
        String insertsql = "INSERT INTO employees(name,salary) VALUES (?,?)";
        String selectsql = "SELECT id,name,salary FROM employees";
        try(
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement insertStmt = conn.prepareStatement(insertsql);
        ){
            System.out.println("---Executing Insert Operation---");
            insertStmt.setString(1, "Mohan");
            insertStmt.setDouble(2, 70000.00);
            int rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted Successfully");
            insertStmt.setString(1, "Hema");
            insertStmt.setDouble(2, 68000.00);
            rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted Successfully");
            System.out.println("\n---Executing Select Operation---");
            try(
                PreparedStatement selectStmt = conn.prepareStatement(selectsql);
                ResultSet rs = selectStmt.executeQuery();
            )
            {
                System.out.println("Employee Date: ");
                System.out.println("-------------------------");
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    System.out.printf("ID : %d, Name : %s, Salary : $%.2f\n",id,name,salary);
                }
            }
        }
        catch(SQLException e){
            System.out.println("SQL Exception Occured "+e.getMessage());
            e.printStackTrace();
        }
    }
}
