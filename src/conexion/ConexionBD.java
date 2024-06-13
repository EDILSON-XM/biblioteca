package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**Clase que permite conexion con la base de datos registrando un driver de  tipo MariaDB**/
// proyecto creado pero no acorde a especificacion

public class ConexionBD {
/**Propiedades de la conexión**/
	//cambiar el dato para conectar a otra base de datos
	private  static String database="biblioteca"; // base de datos correcta
	private static String usuario="root";
	private static String contraseña="";
	private static String url="jdbc:mariadb://localhost/"+database;
	
	//Objeto connection que debemos usar en JDBC
	
	private Connection conexion=null;
	
	/** EL METODO DE LA CLASE QUE DEVUELVE EL OBJETO 
	 * CONNECTION NESESARIO PARA OPERAR CON LA BASE DE DATOS Y 
	 * DEVUELVE EL OBJETO CONNECTION**/
			
	public Connection getConexion() {
		if(this.conexion!=null) {
			//ya esta la conexion creada, la devuelvo
			return this.conexion;
		}
		// INICIALIZAMOS LA CONEXION ALA BASE DE DATOS
		
		
		try {
			
			//registrar el driver.Previamente habra que haber
		//añadido el driver al proyecto(Buil path)
			
			// conector añadido y en la ruta de construccion
			Class.forName("org.mariadb.jdbc.Driver");
			//obtenemos el objeto connection de la clase
			//DRiverManager.lANZARA UNA EXCEPTION
			// SQLExcetion si no se puede conetar
			
			this.conexion=DriverManager.getConnection(url,usuario,contraseña);
			System.out.println("Conexion a base de datos correcta");
			
		} catch (ClassNotFoundException e) {
		System.out.println("error al registrar el driver");
		
		} catch (SQLException e) {
			System.out.println("No se puede conectar con la base de datos" + e.getLocalizedMessage());
		}
		return this.conexion;
	}
	
	
		/**
		 * Metodo de la clase que libera los recursos asociados  a la conexión
		 */
	public void desconectar() {
		if(this.conexion!=null) {
			try {
				this.conexion.close();
			} catch (SQLException e) {
			
				System.out.println("Error no se puede liberar la conexión");
			}
		}
	}
	
	
	}
