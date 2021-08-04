package daos;

import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.Conexion;
import modelos.PersonaVO;

public class PersonaDAO {

	public void registrarPersona(PersonaVO miPersona) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO persona VALUES ('" + miPersona.getNombrePersona() + "','"
					+ miPersona.getEdadPersona() + "'," + "'" + miPersona.getProfesionPersona() + "','"
					+ miPersona.getTelefonoPersona() + "')");
			estatuto.close();
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente a " + miPersona.getNombrePersona());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se registro a " + miPersona.getNombrePersona());
		}
	}

}