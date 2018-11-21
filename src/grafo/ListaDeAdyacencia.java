package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaDeAdyacencia {

	private List<List<Arista>> listaAdyacencia;;

	public ListaDeAdyacencia(int cantidadDeClaros) {

		listaAdyacencia = new ArrayList<>();
		for (int i = 0; i < cantidadDeClaros; i++) {
			listaAdyacencia.add(new LinkedList<>());
		}

	}

	public void setDistancia(int claroI, int claroJ, int distancia) {
		if (claroI == claroJ)
			return;

		// Doble porque es no dirigido
		
		this.listaAdyacencia.get(claroJ-1).add(new Arista(claroI-1, distancia));
		this.listaAdyacencia.get(claroI-1).add(new Arista(claroJ-1, distancia));
	}

	public int getDistancia(int claroI, int claroJ) {

		if (claroI == claroJ)
			return -1;
		
		for(Arista a: listaAdyacencia.get(claroI-1)) {
			if(a.getNodoDestino() == claroJ-1)
				return a.getDistancia();
		}
		
		return -1;
	}

	public List<Arista> getAdyacentes(int claro) {
		return this.listaAdyacencia.get(claro-1);
	}
}
