
import java.io.Serializable;

public class Movimiento implements Serializable{

	
	private double valor;
    protected int posicionX;
    protected int posicionY;
    protected int direccion; 
	
  
	public Movimiento(int x,int y,int direccion,int a,int b){
		posicionX=x;
		posicionY=y;
		this.direccion=direccion;
		valor=estimarDistancia(x,y,a,b);
	}
 
    public int abs(int a){
		if (a<0) a=-a;
		return a;
	}

    public double estimarDistancia(int a, int b, int x, int y) {
    	return abs(a-x)+abs(b-y);
    }

	public void setPosicionX(int x) {
	    this.posicionX = x;
	}
	

	public int getPosicionX() {
	    return posicionX;
	}
	
	public void setPosicionY(int y) {
	    this.posicionY = y;
	}
	
	public int getPosicionY() {
	    return posicionY;
	}
	

	public void setDireccion(int direccion) {
	    this.direccion = direccion;
	}

	public int getDireccion() {
	    return direccion;
	}

	public void setValor(double valor) {
	    this.valor = valor;
	}

	public double getValor() {
	    return valor;
	}

	public boolean menor(Movimiento m) {
	if (this.valor<m.getValor()) return true;
	else return false;
	}

	public boolean mayor(Movimiento m) {
	if (this.valor>m.getValor()) return true;
	else return false;
	}

}
