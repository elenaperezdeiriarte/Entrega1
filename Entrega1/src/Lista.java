import java.io.Serializable;

public class Lista {

    private Enemigo[] lista;
    public Lista() {
        lista = null;
    }

    public Lista(Enemigo[] listaE) {
        lista = listaE;
    }

    public int getLongitud(){
        return lista.length;
    }
  
    public Enemigo getEnemigo(int pos){
        return lista[pos];
    }
    
    public Enemigo[] getEnemigos() {
    	return lista;
    }
 
    public void burbuja (int ultimo){

        Enemigo aux;
        boolean cambio = true;

        for (int i=1; i<=ultimo && cambio; i++){
            cambio = false;
            for (int j=0; j<=ultimo-i; j++){
                if (!lista[j].menor(lista[j+1])){
                    cambio = true;
                    aux = lista [j+1];
                    lista [j+1] = lista [j];
                    lista [j] = aux;
                }
            }
        }
    }
 }