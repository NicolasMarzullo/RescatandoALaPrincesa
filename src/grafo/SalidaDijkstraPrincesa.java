package grafo;

import java.util.List;

public class SalidaDijkstraPrincesa {

	private String mensaje;
	private List<Integer> camino;

	public SalidaDijkstraPrincesa(String mensaje, List<Integer> camino) {
		this.mensaje = mensaje;
		this.camino = camino;
	}

	public String getMensaje() {
		return mensaje;
	}

	public List<Integer> getCamino() {
		return camino;
	}
	
	

}
