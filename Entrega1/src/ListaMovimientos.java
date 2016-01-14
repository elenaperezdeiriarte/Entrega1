public class ListaMovimientos{

	    private Movimiento[] lista;
	    public ListaMovimientos() {
	        lista = null;
	    }
	    public ListaMovimientos(Movimiento[] m) {
	        lista = m;
	    }
	    public boolean esVacia() {
	        return lista == null;
	    }

	    public int getLongitud(){
	        return lista.length;
	    }
	        
	    public Movimiento getMovimiento(int pos){
	        return lista[pos];
	    }
	    
	    public void ordenar (int ultimo){
	        Movimiento aux;
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

