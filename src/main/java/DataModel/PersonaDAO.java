package DataModel;

import domain.Persona;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    //DAO Data Access Object -- Operaciones a realizar sobre la entidad Persona

    private static final String SQL_SELECCIONAR = "SELECT id_persona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERTAR = "INSERT INTO test.persona (id_persona,nombre, apellido, email, telefono) VALUES (?,?,?,?,?)";
    private static final String SQL_ACTUALIZAR = "UPDATE test.persona SET id_persona = ?, nombre = ?, apellido = ?, email = ?, telefono = ? WHERE (id_persona = ?)";
    private static final String SQL_BORRAR = "DELETE FROM test.persona WHERE (id_persona = ?)";




    public int borrar (Persona persona){
        Connection connectionToDb = null;
        PreparedStatement stmt = null;
        int registros=0;

        try {
            connectionToDb = Conecciones.establecerConexion();
            stmt = connectionToDb.prepareStatement(SQL_BORRAR);
            stmt.setInt(1,persona.getIdPersona());
            registros= stmt.executeUpdate();
            System.out.println("Cantidad de registros eliminados: " + registros);
            System.out.println("Id del registro eliminado: " + persona.getIdPersona());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                assert stmt != null;
                stmt.close();
                connectionToDb.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return registros;

    }

    public int actualizar (Persona persona){
        Connection connectionToDb =null;
        PreparedStatement stmt = null;
        int regitstros=0;

        try {
            connectionToDb = Conecciones.establecerConexion();
            stmt = connectionToDb.prepareStatement(SQL_ACTUALIZAR);
            stmt.setInt(1,persona.getIdPersona());
            stmt.setString(2,persona.getNombre());
            stmt.setString(3,persona.getApellido());
            stmt.setString(4,persona.getEmail());
            stmt.setString(5,persona.getTelefono());
            stmt.setInt(6,persona.getIdPersona());
            regitstros= stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                assert stmt != null;
                stmt.close();
                connectionToDb.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return regitstros;
    }



    public int insertar (Persona persona){
        Connection connectionToDb =null;
        PreparedStatement stmt = null;
        //-- variable registros almacena numero de registros actualizados que regresa la funcion executeUpdate
        //-- el metodo executeUpdate puede ejecutar sentencias UPDATE, DELETE o INSERT
        int registros =0;

        try {
            connectionToDb = Conecciones.establecerConexion();
            stmt = connectionToDb.prepareStatement(SQL_INSERTAR);
            stmt.setInt(1,persona.getIdPersona());
            stmt.setString(2,persona.getNombre());
            stmt.setString(3,persona.getApellido());
            stmt.setString(4,persona.getEmail());
            stmt.setString(5,persona.getTelefono());
            registros= stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                assert stmt != null;
                stmt.close();
                connectionToDb.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return registros;

    }

    public List<Persona> seleccionar (){
        //-- Objeto para iniciar la conexion
        Connection connectionToDb = null;
        //-- Objeto para la ejecucion de la sentencia SQL
        PreparedStatement stmt = null;
        //-- Objeto para almacenar registros que cumplan el SQL
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            connectionToDb = Conecciones.establecerConexion();
            stmt = connectionToDb.prepareStatement(SQL_SELECCIONAR);
            rs = stmt.executeQuery();

            while (rs.next()){
                int idPersona =  rs.getInt("id_Persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona (idPersona,nombre,apellido,email,telefono);

                personas.add(persona);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                assert rs != null;
                rs.close();
                stmt.close();
                connectionToDb.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return personas;
    }
}
