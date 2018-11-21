package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaAdyacencia {

	List<List<Arista>> adyacencia;

	public ListaAdyacencia(int cantidadDeClaros) {
		this.adyacencia = new ArrayList<>();
		
		for(int i = 0;i<cantidadDeClaros;i++) {
			this.adyacencia.add(new LinkedList<>());
 		}
	}
	
	public void setCamino(int claroI, int claroJ, int distancia) {
		if(claroI == claroJ)
			return;
					
		//Doble porque es no dirigido
		this.adyacencia.get(claroI-1).add(new Arista(claroJ-1, distancia));
		this.adyacencia.get(claroJ-1).add(new Arista(claroI-1, distancia));
	}
	
	public List<Arista> getCaminos(int claro){
		return this.adyacencia.get(claro-1);
	}
	
	public int getDistancia(int claroI, int claroJ) {
		for(Arista a: this.adyacencia.get(claroI-1)) {
			if(claroJ-1 == a.getNodoDestino()) {
				return a.getDistancia();
			}
		}
		
		return -1;
	}
}
