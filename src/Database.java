import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) {
        String databaseURL = "jdbc:mysql://sistemascomputacionaisdistribuidos.czdpkebctadn.us-east-2.rds.amazonaws.com:3306/sistcomp";
        String user = "admin";
        String password = "sistemas12345";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) { // ESTÃ� CONECTADO AO BANCO DE DADOS.
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("select * from medicamento"); // QUERY DE SELECT
                // int result = stmt.executeUpdate("insert into medicamento(id, nome,
                // principioAtivo) values (1, â€˜dorflexâ€™, â€˜dipironaâ€™);"); // QUERY DE INSERT
                if (!resultSet.next()) {
                    System.out.println("NÃ£o hÃ¡ dados na table");
                } else { // Query de select funcionou,
                    // Peguei esse cÃ³digo da net, se quiserem seguir ver como o Renato fez
                    ResultSetMetaData rsmd = resultSet.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();
                    do {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1)
                                System.out.print(",  ");
                            String columnValue = resultSet.getString(i);
                            System.out.print(columnValue + " " + rsmd.getColumnName(i));
                        }
                    } while (resultSet.next());
                }

                System.out.println("Connected to the database");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}