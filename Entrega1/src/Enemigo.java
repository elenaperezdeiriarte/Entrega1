

import java.io.Serializable;

public class Enemigo extends Individuo implements Serializable {
    public static final int COLOR_VERDE = Temporizador.ICONO_ENEMIGO_VERDE;
    public static final int COLOR_AZUL = Temporizador.ICONO_ENEMIGO_AZUL;
    public static final int COLOR_ROJO = Temporizador.ICONO_ENEMIGO_ROJO;
    public static final int COLOR_CYAN = Temporizador.ICONO_ENEMIGO_CYAN;


    private int idEnemigo;
    private String nombre;
    private int color;
    private int distancia;
    private static int contadorEnemigos = 0;

    public Enemigo(int posicionX, int posicionY, int direccion) {
        super(posicionX, posicionY, direccion);
        contadorEnemigos++;
        this.idEnemigo = contadorEnemigos;
    }

  
    public Enemigo(int posicionX, int posicionY, int direccion, String nombre, int color) {
        super(posicionX, posicionY, direccion);
        contadorEnemigos++;
        this.idEnemigo = contadorEnemigos;
        this.nombre = nombre;
        this.color = color;
        this.distancia = 0;
    }

    public String getInicial() {
        return nombre.substring(0,1);
    }
 
    public boolean resuelveCamino(int x0, int y0, Casilla[][] casillas, Lista enemigos, int x1, int y1, int i) {
    	if(x0==x1 && y0==y1){
    		
    		distancia = i;
    		return true;
    	}
    
    	i++;
    	
    	casillas[y0][x0].setPisable(false);
    	
    	Movimiento[] movimientos = new Movimiento[4];
   		movimientos[0] = new Movimiento(x0,y0-1,DIRECCION_ARRIBA,x1,y1);
   		movimientos[1] = new Movimiento(x0,y0+1,DIRECCION_ABAJO,x1,y1);      
  		movimientos[2] = new Movimiento(x0-1,y0,DIRECCION_IZQUIERDA,x1,y1);
  		movimientos[3] = new Movimiento(x0+1,y0,DIRECCION_DERECHA,x1,y1);  		
 

       	ListaMovimientos lista = new ListaMovimientos(movimientos);
       	lista.ordenar(lista.getLongitud()-1);
        for(int j=0; j<lista.getLongitud(); j++) {
        	Movimiento m = lista.getMovimiento(j);
        	
          	if (esPisable(m.getPosicionX(),m.getPosicionY(),casillas,enemigos,i)){
          		
          		boolean tmp = resuelveCamino(m.getPosicionX(),m.getPosicionY(),casillas,enemigos,x1,y1,i);    			
          		
          		if (tmp){ 
    				direccion = m.getDireccion(); 
    				if (!casillas[y0][x0].esGuarida())casillas[y0][x0].setPisable(true);
    				return true;
    			}
    		}
    	}

		if (!casillas[y0][x0].esGuarida())casillas[y0][x0].setPisable(true);
    	return false;
    } 	

    public void muevete(Casilla[][] casillas, Lista enemigos, int x, int y) {
    	boolean encontrado = resuelveCamino(posicionX,posicionY,casillas,enemigos,x,y,0);
    	if (encontrado) super.muevete(casillas);
    }
 
    private boolean esPisable(int x, int y, Casilla[][] casillas, Lista enemigos,int numMovimiento) {
    	boolean pisable = casillas[y][x].esPisable();
        if (pisable && numMovimiento==1){
        	
        	for(int i=0; i<enemigos.getLongitud(); i++) {
        		if(enemigos.getEnemigo(i).coincide(x,y)) {
        			pisable = false;
        			break;
        		}
        	}
        }
        return pisable;
    }
 
  
    public int getIdEnemigo() {
        return idEnemigo;
    }

 
    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        switch(color) {
            case COLOR_ROJO:
                return "roj";   
           case COLOR_VERDE:
            	return "ver";
           case COLOR_AZUL:
				return "azu";
            case COLOR_CYAN:
				return "cya";
           default:
                return "";
        }
    }
    
    public int getDistancia() {
        return distancia;
    }

    public boolean esEnemigo(String nombre) {
	if (this.nombre.equals(nombre)) return true;
	else return false;
    }

    public boolean menor(Enemigo e) {
	if (this.distancia<e.getDistancia()) return true;
	else return false;
    }

    public boolean mayor(Enemigo e) {
	if (this.distancia>e.getDistancia()) return true;
	else return false;
    }

    public boolean igual(Enemigo e) {
	if (this.distancia==e.getDistancia()) return true;
	else return false;
    }

    public int getColorInt() {    	
    	return this.color;
    }    
}
