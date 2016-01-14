import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/** M�todos �tiles para base de datos.
 * Clase con m�todos est�ticos para gestionar una sola base de datos
 * @author Andoni Egu�luz Mor�n
 * Facultad de Ingenier�a - Universidad de Deusto
 */
public class BD {

	// ------------------------------------
	// VALIDO PARA CUALQUIER BASE DE DATOS
	// ------------------------------------
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static String nombreJugador = "";

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexi�n!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexi�n!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	public static void conexion() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:pacman.db");
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table USUARIOS (Nombre varchar(255), PuntuacionMaxima integer)");
			} catch (SQLException e) {
				if (!e.getMessage().equals("table USUARIOS already exists"))  // Este error s� es correcto si la tabla ya existe
					e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Cierra la conexi�n con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	// -----------------------
	// PARTICULAR DEL PACMAN
	// -----------------------
	
	/** Crea una tabla de cat�logo multimedia en una base de datos, si no exist�a ya.
	 * Debe haberse inicializado la conexi�n correctamente.
	 */
	public static void crearTablaBD() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table USUARIOS (Nombre string, Puntuaci�nM�xima int)" );
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
		
	public static boolean anadirUsuario(String nombre, int puntuacion) throws SQLException 
		{
		try {
			String sentSQL = "insert into USUARIOS values(" +"'" + nombre + "', " + puntuacion + ")";

			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = statement.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que a�adir 1 - error si no
			else {
				JOptionPane.showMessageDialog(null, "Usuario a�adido");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		
 public static ResultSet mostrarTabla (String table_name) {
	 
	 ResultSet resultSet = null;
	 try {
            String Query = "SELECT * FROM " + table_name;           
            resultSet = statement.executeQuery(Query);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisici�n de datos");
        }
        return resultSet;
    }
	
	public static int puntuacionJugador (String nombre)
	{
		ResultSet resultSet = null;
		int puntuacion = 0;
		try {
            String Query = "SELECT * FROM USUARIOS WHERE Nombre = '" + nombre + "'";           
            resultSet = statement.executeQuery(Query);
            resultSet.next();
            puntuacion = resultSet.getInt("PuntuacionMaxima");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisici�n de datos");
        }
		return puntuacion;
	}
	
	public static void actualizar (String nombre, int puntuacion)
	{
		
		try {
            String Query = "UPDATE USUARIOS SET PuntuacionMaxima=" + puntuacion + " WHERE Nombre='" + nombre + "'";     
            statement.executeUpdate(Query);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en actualizar");
        }
	}

}
