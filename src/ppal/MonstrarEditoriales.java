package ppal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class MonstrarEditoriales {

	public static void main(String[] args) {
		
		ConexionBD conexion= new ConexionBD();
		
		
		System.out.println("conectando ala base de datos...");
		//Paso 1. Obtener la conexión
		Connection con= conexion.getConexion();
		
		
		//Objetos nesesarios para hacer una consulta
		
		Statement sentencia=null;
		ResultSet resultado=null;
		
		
		
		//Algun procesamiento con la base de datos
	
		
		
	
		
		try {	
			// Paso 2 .OBTENER EL Statement
			sentencia=con.createStatement();
			
			//Paso 3 . Ejecutar la Sentencia
			
			resultado=sentencia.executeQuery("select codEditorial,nombre,anio from editoriales");
			
			System.out.println("cod.Editorial\tnombre\tanio");
			
			//Paso 4. RECOGER EL RESULTADO
			while(resultado.next()) {
				int codEditorial=resultado.getInt("codEditorial");
				String nombre=resultado.getString("nombre");
				int anio=resultado.getInt("anio");
				
				
				System.out.println(codEditorial+"\t" + nombre + "\t"+ anio);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Error al consultar datos."+e.getMessage());
			
		}finally{ try {
			
			resultado.close();
			sentencia.close();
			
		} catch (SQLException e) {
			
			System.out.println("Error al liberar los recursos");
		}
		
		}

			
		
		
		//liberamos la conexión
		System.out.println("Desconectando de la base de datos");
		conexion.desconectar();

	}

}
