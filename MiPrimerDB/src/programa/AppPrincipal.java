package programa;

import daos.PersonaDAO;
import database.Conexion;
import modelos.PersonaVO;

public class AppPrincipal {

	public static void main(String[] args) {
		PersonaDAO pd = new PersonaDAO();
		PersonaVO p1 = new PersonaVO("Diego Vercelli", 27, "Analista Programador", 152156125);
		pd.registrarPersona(p1);
	}

}