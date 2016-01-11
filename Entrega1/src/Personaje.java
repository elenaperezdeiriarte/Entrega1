import java.io.Serializable;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.*;


public class Personaje implements Serializable {
	
	protected ImageIcon Imagen;
    protected static int posicionX;
    protected static int posicionY;
    protected static int direccion;
    protected static int velocidad;
  
    protected int inicialX;
    protected int inicialY;
 
  
    protected static final int DIRECCION_ARRIBA = 0;
    protected static final int DIRECCION_ABAJO = 1;
    protected static final int DIRECCION_IZQUIERDA = 2;
    protected static final int DIRECCION_DERECHA = 3;
    
    public Personaje(int posicionX, int posicionY, int direccion) {
    	this.posicionX = posicionX;
    	this.inicialX =posicionX;
    	this.posicionY = posicionY;
    	this.inicialY = posicionY;
    	this.direccion = direccion;}
    
   
    
    public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public int getInicialX() {
		return inicialX;
	}
	public void setInicialX(int inicialX) {
		this.inicialX = inicialX;
	}
	public int getInicialY() {
		return inicialY;
	}
	public void setInicialY(int inicialY) {
		this.inicialY = inicialY;
	}
	public static int getDireccionArriba() {
		return DIRECCION_ARRIBA;
	}
	public static int getDireccionAbajo() {
		return DIRECCION_ABAJO;
	}
	public static int getDireccionIzquierda() {
		return DIRECCION_IZQUIERDA;
	}
	public static int getDireccionDerecha() {
		return DIRECCION_DERECHA;
	}
	
	protected void AumentarPosicionX(){posicionX = posicionX + velocidad;}
    protected void DisminuirPosicionX(){posicionX = posicionX - velocidad;}
    protected void AumentarPosicionY(){posicionY = posicionY + velocidad;}
    protected void DisminuirPosicionY(){posicionY = posicionY - velocidad;}
    protected void CambiarVelocidad(int NuevoValor){velocidad = NuevoValor;}
    protected ImageIcon ObtenerImagen(){return Imagen;}
    protected boolean CambioDireccion = true;
    
    
	public void comienzo ()
    {
    	posicionX=inicialX;
    	posicionY=inicialY;
    }
    public boolean coincide(Personaje otro) {
    	return otro.getPosicionX() == posicionX && otro.getPosicionY() == posicionY;
    	}

   
}
