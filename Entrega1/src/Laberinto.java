
public class Laberinto {

	private final int LARGO_IMAGENES = 10;
	private final int ALTURA_IMAGENES = 10;
	
    public String LaberintoActual[][] = {
        {"ESI", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "EII", "CA", "CA", "ESI", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "IZ", "EII"},
        {"AR","ME","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","ME","ME","ME","AB","CA","CA","AR","ME","ME","ME","DE","DE","DE","DE","DE","DE","ME","ME","DE","DE","DE","DE","DE","DE","ME","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","ESD","EID","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","EII","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESI","EII","CA","CA","CA","CA","CA","CA","ESI","EII","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","ME","ME","AB","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","EID","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","DE","DE","DE","DE","EID","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","IZ","IZ","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","EII","CA","CA","ESI","IZ","IZ","IZ","ME","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESD","DE","DE","DE","DE","DE","DE","EID","CA","CA","ESD","DE","DE","EID","CA","CA","AR","AB","CA","CA","ESD","DE","DE","DE","ME","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","EII","CA","CA","AR","AB","CA","CA","ESI","EII","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"ESD","EID","CA","CA","ESD","DE","DE","EID","CA","CA","AR","ME","ME","AB","CA","CA","ESD","DE","ME","AB","CA","CA","AR","AB","CA","CA","ESD","EID","CA","CA","AR","AB","CA","CA","ESD","EID","CA","CA","AR","AB"},
        {"CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","CA","CA"},
        {"CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","CA","CA"},
        {"ESI","IZ","IZ","IZ","IZ","IZ","IZ","EII","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","ME","IZ","IZ","IZ","EII","CA","CA","AR","ME","IZ","IZ","IZ","EII","CA","CA","ESI","EII"},
        {"AR","ME","DE","DE","DE","DE","DE","EID","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","ME","DE","DE","DE","EID","CA","CA","AR","ME","DE","DE","DE","EID","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","ESI","IZ","IZ","EII","CA","CA","AR","ME","ME","AB","CA","CA","ESI","IZ","ME","AB","CA","CA","AR","AB","CA","CA","ESI","EII","CA","CA","AR","AB","CA","CA","ESI","EII","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","EID","CA","CA","AR","AB","CA","CA","ESD","EID","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESI","IZ","IZ","IZ","IZ","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","EII","CA","CA","AR","AB","CA","CA","ESI","IZ","IZ","IZ","ME","AB","CA","CA","AR","AB"},
        {"ESD","EID","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","DE","DE","DE","DE","DE","DE","EID","CA","CA","ESD","DE","DE","EID","CA","CA","ESD","EID","CA","CA","ESD","DE","DE","DE","ME","AB","CA","CA","ESD","EID"},
        {"CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA"},
        {"CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA"},
        {"ESI","EII","CA","CA","ESI","IZ","IZ","IZ","IZ","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","EII","CA","CA","ESI","IZ","IZ","IZ","IZ","EII","CA","CA","AR","AB","CA","CA","ESI","EII"},
        {"AR","AB","CA","CA","AR","ME","DE","DE","DE","DE","DE","EID","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","DE","DE","DE","EID","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","AR","AB","CA","CA","ESI","IZ","IZ","EII","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","AR","AB","CA","CA","ESI","EII","CA","CA","AR","AB","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","ESD","EID","CA","CA","ESD","DE","DE","EID","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","ESD","EID","CA","CA","AR","AB","CA","CA","ESD","EID","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","AB","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","CA","AR","ME","ME","AB","CA","CA","AR","ME","ME","AB","CA","CA","CA","CA","CA","CA","AR","AB","CA","CA","CA","CA","CA","CA","AR","AB"},
        {"AR","ME","IZ","IZ","IZ","IZ","IZ","IZ","IZ","IZ","IZ","IZ","IZ","IZ","ME","ME","ME","AB","CA","CA","AR","ME","ME","ME","IZ","IZ","IZ","IZ","IZ","IZ","ME","ME","IZ","IZ","IZ","IZ","IZ","IZ","ME","AB"},
        {"ESD","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","EID","CA","CA","ESD","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","DE","EID"}
    };
	
	public int DevolverLargoImagenes(){return LARGO_IMAGENES;}
	public int DevolverAlturaImagenes(){return ALTURA_IMAGENES;}
    public int DevolverCantidadFilasLaberinto(){return LaberintoActual.length;}
    public int DevolverCantidadColumnasLaberinto(){return LaberintoActual[0].length;}    
    public String DeolverCodigoImagenMatriz(int Fila, int Columna){return LaberintoActual[Fila][Columna];}
}
