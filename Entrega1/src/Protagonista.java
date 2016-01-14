
public class Protagonista extends Individuo {

    public Protagonista(int posicionX, int posicionY, int direccion) {
        super(posicionX, posicionY, direccion);
    }

    public void muevete(Casilla[][] casillas, String teclaPulsada) {

        if(teclaPulsada.equals("T") || teclaPulsada.equals("t")) {
            direccion = DIRECCION_ARRIBA;
        }
        else if(teclaPulsada.equals("V") || teclaPulsada.equals("v")) {
            direccion = DIRECCION_ABAJO;
        }
        else if(teclaPulsada.equals("F") || teclaPulsada.equals("f")) {
            direccion = DIRECCION_IZQUIERDA;
        }
        else if(teclaPulsada.equals("G") || teclaPulsada.equals("g")) {
            direccion = DIRECCION_DERECHA;
        }

        super.muevete(casillas);
    }

    public void cambiaDireccion(String teclaPulsada) {

    	 if(teclaPulsada.equals("T") || teclaPulsada.equals("t")) {
             direccion = DIRECCION_ARRIBA;
         }
         else if(teclaPulsada.equals("V") || teclaPulsada.equals("v")) {
             direccion = DIRECCION_ABAJO;
         }
         else if(teclaPulsada.equals("F") || teclaPulsada.equals("f")) {
             direccion = DIRECCION_IZQUIERDA;
         }
         else if(teclaPulsada.equals("G") || teclaPulsada.equals("g")) {
             direccion = DIRECCION_DERECHA;
         }
        
    }

}
