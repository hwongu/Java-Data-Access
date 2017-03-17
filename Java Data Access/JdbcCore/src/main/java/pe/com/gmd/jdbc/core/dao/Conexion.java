package pe.com.gmd.jdbc.core.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

class Conexion {
	
	//Variable para conectarme  a la base de datos
	protected Connection cn = null;
	//Vaiable para ejecutar sentecias
	protected PreparedStatement pr = null;
	protected CallableStatement cl = null;
	//Variable que almacena la informacion de la base de datos
	protected ResultSet rs = null;
	
	
	protected Connection obtenerConexion() throws Exception{
		ResourceBundle rb = ResourceBundle.getBundle("sesion");
		//Indicar con que motor de base de datos conectarme
		Class.forName(rb.getString("conexion.driverClass"));
		String url = rb.getString("conexion.url");
		String usuario = rb.getString("conexion.usuario");
		String clave = rb.getString("conexion.clave");
		return DriverManager.getConnection(url, usuario, clave);
	}
	
	protected void cerrar(Connection cn){
		try {
			cn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void cerrar(PreparedStatement pr){
		try {
			pr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void cerrar(CallableStatement cl){
		try {
			cl.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void cerrar(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
