import java.awt.event.KeyEvent;
import java.io.Serializable;


public class Pacman extends Personaje implements Serializable {
	
	public Pacman(int posicionX, int posicionY, int direccion) {
		super(posicionX, posicionY, direccion);
		}
	private static final long serialVersionUID = 1L;
	Pacman individuo= new Pacman(posicionX, posicionY, direccion);
	public void mover()
    {
    	switch (direccion)
    	{ 
    	case DIRECCION_ARRIBA: individuo.setPosicionX(posicionX);
    	individuo.setPosicionY(posicionY - 1);
    	case DIRECCION_ABAJO: individuo.setPosicionX(posicionX);
    	individuo.setPosicionY(posicionY + 1);
    	case DIRECCION_IZQUIERDA: individuo.setPosicionX(posicionX - 1);
    	individuo.setPosicionY(posicionY);
    	case DIRECCION_DERECHA: individuo.setPosicionX(posicionX + 1);
    	individuo.setPosicionY(posicionY);
    	}
    }
	
	
	
	
	public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37: //Izquierda
            {
            	Pacman.direccion= DIRECCION_IZQUIERDA;
                break;
            }
            case 38: //Arriba
            {
            	Pacman.direccion =DIRECCION_ARRIBA;
                break;
            }
            case 39: //Derecha
            {
            	Pacman.direccion = DIRECCION_DERECHA;
                break;
            }
            case 40: //Abajo
            {
            	Pacman.direccion = DIRECCION_ABAJO;
                break;
            }
        }
    }
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37: //Izquierda
            {
                Pacman.direccion= DIRECCION_IZQUIERDA;
                break;
            }
            case 38: //Arriba
            {
                Pacman.direccion =DIRECCION_ARRIBA;
                break;
            }
            case 39: //Derecha
            {
                Pacman.direccion = DIRECCION_DERECHA;
                break;
            }
            case 40: //Abajo
            {
                Pacman.direccion = DIRECCION_ABAJO;
                break;
            }
        }
	
}

}
