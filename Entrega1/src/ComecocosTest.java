

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


public class ComecocosTest {

	Comecocos c;
	
	
	@Test
	
	public void anadirUsuarioTest ()
	{
		BD.conexion();
		ResultSet resultSet = BD.mostrarTabla("USUARIOS");
		int i=0;
		int a=0;
		
		try {
			while (resultSet.next())
			{
				i++;
			}
			BD.anadirUsuario("paula", 100);
			
			resultSet = BD.mostrarTabla("USUARIOS");
		
			
			while (resultSet.next())
			{
				a++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		assertEquals (i+1, a);
	}

}
