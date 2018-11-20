package grafo;

import java.util.LinkedList;
import java.util.List;

public class Grafo {
	
	private int cantDeClaros;
	private ListaAdyacencia listaDeAdyacencia;
	private int claroPrincesa;
	private int claroPrincipe;
	List<Integer> clarosDragones;
	
	public Grafo(int cantDeClaros, int claroPrincesa, int claroPrincipe,
			List<Integer> clarosDragones) {
		
		this.listaDeAdyacencia = new ListaAdyacencia(cantDeClaros);
		this.cantDeClaros = cantDeClaros;
		this.claroPrincesa = claroPrincesa;
		this.claroPrincipe = claroPrincipe;
		this.clarosDragones = clarosDragones;
	}
	
	//Lo paso decrementado para contemplar nodos/claros desde el 1 y no desde 0 
	public void setCamino(int claroI, int claroJ, int distancia) {
		this.listaDeAdyacencia.setCamino(claroI-1, claroJ-1, distancia);
	}
	
	public SalidaDijkstraPrincesa resolver() {
		List<Integer> camino = new LinkedList<>();
		
		
		return new SalidaDijkstraPrincesa("aa", camino);
	}
	
	
	
	
}
