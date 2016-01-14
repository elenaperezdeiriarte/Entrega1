import java.util.Random;
import java.io.Serializable;;


public class Tablero  {

    private Casilla[][] casillas;
    public int contadorPuntos; 
    private Lista enemigos;
    private Protagonista prota;
    private int ancho;
    private int alto;
    private int vidas;
    private int puntos;
    private int puntosComidos;
    private int puntosIniciales;
    private int time;
    private static final int INCREMENTO_PUNTOS = 10;
    private static final int VIDAS_INICIALES = 3;
   
    public Tablero(Lista enemigos, Protagonista prota) {

        this.enemigos = enemigos;
        this.prota = prota;
        
        this.vidas = VIDAS_INICIALES;
        
        this.puntos = 0;
    }
    
   
    public void crearTableroInicial(){
    	
    	int muro = Casilla.TIPO_MURO;
        int pnto = Casilla.TIPO_PUNTO;
        int grda = Casilla.TIPO_GUARIDA;
        int vcia = Casilla.TIPO_VACIA;
        int[][] tmp = new int[][] {
	      	{muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,vcia,muro,muro,vcia,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,vcia,muro,muro,vcia,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,muro,muro,grda,grda,grda,grda,muro,muro,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,vcia,vcia,vcia,muro,muro,muro,muro,muro,muro,muro,muro,vcia,vcia,vcia,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,muro,muro,muro,muro,muro,muro,muro,muro,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,muro,muro,muro,muro,muro,muro,muro,muro,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,muro,muro,muro,muro,muro,pnto,muro,muro,vcia,muro,muro,muro,muro,muro,muro,muro,muro,vcia,muro,muro,pnto,muro,muro,muro,muro,muro,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,muro},
	      	{muro,muro,muro,pnto,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,pnto,muro,muro,muro},
	      	{muro,muro,muro,pnto,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,pnto,muro,muro,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,muro,muro,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro},
	      	{muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
	      	{muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro}};

        this.alto = tmp.length;
        this.ancho = tmp[0].length;
       	int ptos = 0;

        // Crea las casillas y calcula puntos iniciales en el tablero
        this.casillas = new Casilla[this.alto][this.ancho];
        for(int i=0; i<this.alto; i++) {
        	casillas[i] = new Casilla[this.ancho];
            for(int j=0; j<this.ancho; j++) {
                casillas[i][j] = new Casilla(tmp[i][j]);
                if(casillas[i][j].esPunto()) {
                	ptos++;
                }
            }
        }
        this.puntosIniciales=ptos;
    }

    public void crearTableroSecundario(){
    	

    	int muro = Casilla.TIPO_MURO;
        int pnto = Casilla.TIPO_PUNTO;
        int grda = Casilla.TIPO_GUARIDA;
        int vcia = Casilla.TIPO_VACIA;
        int[][] tmp = new int[][] {
        		{muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,grda,grda,grda,grda,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,muro,pnto,muro,muro,pnto,muro,muro,vcia,vcia,vcia,vcia,muro,muro,pnto,muro,muro,pnto,muro,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,muro,muro,muro,muro,muro,pnto,muro,muro,muro,pnto,muro,muro,muro,pnto,muro},
                {muro,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,pnto,muro},
                {muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro,muro}};
       
        this.alto = tmp.length;
        this.ancho = tmp[0].length;
       	int ptos = 0;

        this.casillas = new Casilla[this.alto][this.ancho];
        for(int i=0; i<this.alto; i++) {
        	casillas[i] = new Casilla[this.ancho];
            for(int j=0; j<this.ancho; j++) {
                casillas[i][j] = new Casilla(tmp[i][j]);
                if(casillas[i][j].esPunto()) {
                	ptos++;
                }
            }
        }
        this.puntosIniciales=ptos;
    }

    public void siguienteMovimiento(String teclaPulsada) {
        int protaX = prota.getPosicionX();
        int protaY = prota.getPosicionY();
    	
        if(casillas[prota.getPosicionY()][prota.getPosicionX()].esPunto()) {
            puntos += INCREMENTO_PUNTOS;
            puntosComidos++;
            casillas[prota.getPosicionY()][prota.getPosicionX()].setTipo(Casilla.TIPO_VACIA);
        }
        
        prota.muevete(casillas, teclaPulsada);

        if(casillas[prota.getPosicionY()][prota.getPosicionX()].esPunto()) {
            puntos += INCREMENTO_PUNTOS;
            puntosComidos++;
            casillas[prota.getPosicionY()][prota.getPosicionX()].setTipo(Casilla.TIPO_VACIA);
            
        }

        if(vidaPerdida()) {  
            if(!juegoPerdido()){
            	System.out.println("Has perdido una vida!");
            	nuevaVida();
            }
        }

        for(int i=0; i<enemigos.getLongitud(); i++) {
            enemigos.getEnemigo(i).muevete(casillas,enemigos,protaX,protaY);
        }
        
        if(vidaPerdida()) {
            if(!juegoPerdido()){
            	nuevaVida();
            }
        }
   
    }
    
 
    public void siguienteMovimiento() {
    	
    	setTime(Comienzo.tiempoEspera);
        int protaX = prota.getPosicionX();
        int protaY = prota.getPosicionY();
    	
        if(casillas[prota.getPosicionY()][prota.getPosicionX()].esPunto()) {
            puntos += INCREMENTO_PUNTOS;
            puntosComidos++;
            casillas[prota.getPosicionY()][prota.getPosicionX()].setTipo(Casilla.TIPO_VACIA);
           
        }
        
        prota.muevete(casillas);

        if(casillas[prota.getPosicionY()][prota.getPosicionX()].esPunto()) {
            puntos += INCREMENTO_PUNTOS;
            puntosComidos++;
            casillas[prota.getPosicionY()][prota.getPosicionX()].setTipo(Casilla.TIPO_VACIA);
            
        }

        if(vidaPerdida()) {     
            if (!juegoPerdido()){
          	nuevaVida();
            }
        }

        for(int i=0; i<enemigos.getLongitud(); i++) {
            enemigos.getEnemigo(i).muevete(casillas,enemigos,protaX,protaY);
        }
        
        if(vidaPerdida()) {        
        	if(!juegoPerdido()) {              
          	nuevaVida();
            }
        }
        Random aleatorio = new Random(System.currentTimeMillis());
        int metodo=aleatorio.nextInt(5);
        switch(metodo){
	        case 0:{
	            enemigos.burbuja(enemigos.getLongitud()-1);
	        	break;
	        }
	       
        }
        
    }

  
    public boolean vidaPerdida() {
        for(int i=0; i<enemigos.getLongitud(); i++) {
            if(enemigos.getEnemigo(i).coincide(prota)) {
            	vidas--;
                return true;
            }
        }
        return false;
    }

    public boolean juegoPerdido() {
        return vidas==0;
    }

    public boolean juegoGanado() {
        for(int i=0; i<alto; i++) {
            for(int j=0; j<ancho; j++) {
                if(casillas[i][j].esPunto()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void nuevaVida() {
        for(int i=0; i<enemigos.getLongitud(); i++) {
            enemigos.getEnemigo(i).situarInicio();
        }
        prota.situarInicio();
    }

   

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Lista getEnemigos() {
        return enemigos;
    }

    public Protagonista getProta() {
        return prota;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getPuntos() {
        return puntos;
    }
 
    public void setPuntos(int ptos) {
        puntos=ptos;
    }  
  
    public int getVidas() {
    	return vidas;
    }
  
    public void setTime(int time) {
    	this.time=time;
    }
  
    public int getTime() {
    	return time;
    }
  
    public int getContadorPuntos() {
    	return contadorPuntos;
    }
  
    public void setContadorPuntos(int contadorPuntos) {
    	this.contadorPuntos=contadorPuntos;
    }   
}
