package grafo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {

	private int cantDeClaros;
	private ListaAdyacencia listaDeAdyacencia;
	private int claroPrincesa;
	private int claroPrincipe;
	List<Integer> clarosDragones;
	private static final int INFINITO = 2147483647;

	public Grafo(int cantDeClaros, int claroPrincesa, int claroPrincipe, List<Integer> clarosDragones) {

		this.listaDeAdyacencia = new ListaAdyacencia(cantDeClaros);
		this.cantDeClaros = cantDeClaros;
		this.claroPrincesa = claroPrincesa;
		this.claroPrincipe = claroPrincipe;
		this.clarosDragones = clarosDragones;
	}

	// Lo paso decrementado para contemplar nodos/claros desde el 1 y no desde 0
	public void setCamino(int claroI, int claroJ, int distancia) {
		this.listaDeAdyacencia.setCamino(claroI, claroJ, distancia);
	}

	public SalidaDijkstraPrincesa resolver() {
		List<Integer> camino = new LinkedList<>();
		int[] vectorDeCostos = new int[this.cantDeClaros];
		PriorityQueue<Arista> colaDeAristas = new PriorityQueue<>();
		int claroActual = this.claroPrincesa, costoDirecto, costoPasandoPorIntermedio, claroAdyacenteAlActual;

		//Lo lleno con infinitos
		Arrays.fill(vectorDeCostos, Grafo.INFINITO);

		// Cargo costos iniciales de la princesa
		for(Arista a: this.listaDeAdyacencia.getCaminos(claroActual)) {
			vectorDeCostos[a.getNodoDestino()] = a.getDistancia();
		}
		
		camino.add(claroActual);
		
		while (camino.size() != this.cantDeClaros) {

			for (Arista a : this.listaDeAdyacencia.getCaminos(claroActual)) {
				colaDeAristas.add(a);
			}
			
			// Saco la arista de menor peso
			claroActual = colaDeAristas.poll().getNodoDestino();
			camino.add(claroActual++);

			for (Arista a : this.listaDeAdyacencia.getCaminos(claroActual)) {
				claroAdyacenteAlActual = a.getNodoDestino(); // i
				costoDirecto = vectorDeCostos[claroAdyacenteAlActual];
				costoPasandoPorIntermedio = vectorDeCostos[claroActual-1]
						+ this.listaDeAdyacencia.getDistancia(claroActual, claroAdyacenteAlActual);

				if (costoPasandoPorIntermedio < costoDirecto) {
					vectorDeCostos[claroAdyacenteAlActual] = costoPasandoPorIntermedio;
				}
			}
			colaDeAristas.clear();
		}

		return new SalidaDijkstraPrincesa("aa", camino);
	}

}
