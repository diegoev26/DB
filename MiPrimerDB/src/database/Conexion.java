package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String db = "clientes";
	static String Login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + db;

	Connection conn = null;

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, Login, password);
			if(conn != null) {
				System.out.println("Se logro conectar a la DB " + db);
			}

		} catch (SQLException e) {
			System.out.println("error al intentar obtener la conexion a la DB " + db);
			e.printStackTrace();
			e.getCause();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al intentar obtener el Driver de la conexion");
			e.printStackTrace();
			e.getCause();
		} catch (Exception e) {
			System.out.println("Sucedio un error inesperado");
			e.printStackTrace();
			e.getCause();
		}
	}
	public Connection getConnection() {
		return conn;
	}
	public void desconectar() {
		try {
			if(conn != null)conn.close();
			System.out.println("Se logro desconectar de la db, el recurso fue liberado");
		} catch (Exception e) {
			System.out.println("no se logro cerrar la conexion a la DB " + db);
			e.printStackTrace();
		}
	}
}