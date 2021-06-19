package DataModel;

import java.sql.*;

public class Conecciones {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASS = "admin";

    public static Connection establecerConexion() throws SQLException {
        // --Class.forname - Especifica la clase con la que vamos a trabajar con mysql(Permite conectar via JDBC)
        // --No es requerido pero puede ser usado en WEB (Class.forName)
        //Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    // -- Permite cerrar la conexion del ResulSet
    public static void close (ResultSet rs) throws SQLException {
        rs.close();
    }

    // -- Permite cerrar la conexion del Statement
    public static void close (Statement stmt) throws SQLException{
        stmt.close();
    }

    // -- Permite cerrar la conexion del PrepareStatement
    public static void close (PreparedStatement stmt) throws SQLException{
        stmt.close();
    }

    // -- Permite cerrar la conexion de la conexion
    public static void close (Connection conexion) throws SQLException{
        conexion.close();
    }
}
