import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    
    public static void main(String Args[])
    {
    	BD.conexion();
    	BD.actualizar("fff", 7);
    	Inicio inicio = new Inicio();
		inicio.setVisible(true);
		BD.close();
    }
}
