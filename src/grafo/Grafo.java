package grafo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {

	private int cantDeClaros;
	private ListaDeAdyacencia matrizAdyacencia;
	private int claroPrincesa;
	private int claroPrincipe;
	List<Integer> clarosDragones;
	static final int INFINITO = 2147483647;

	public Grafo(int cantDeClaros, int claroPrincesa, int claroPrincipe, List<Integer> clarosDragones) {

		this.matrizAdyacencia = new ListaDeAdyacencia(cantDeClaros);
		this.cantDeClaros = cantDeClaros;
		this.claroPrincesa = claroPrincesa;
		this.claroPrincipe = claroPrincipe;
		this.clarosDragones = clarosDragones;
	}

	// Lo paso decrementado para contemplar nodos/claros desde el 1 y no desde 0
	public void setDistancia(int claroI, int claroJ, int distancia) {
		this.matrizAdyacencia.setDistancia(claroI, claroJ, distancia);
	}

	public SalidaDijkstraPrincesa resolver() {
		PriorityQueue<Arista> colaCostoArista = new PriorityQueue<>();
		int[] vectorDeDistancias = new int[this.cantDeClaros];
		int[] vecDePredecesores = new int[this.cantDeClaros];
		
		int claroActual = this.claroPrincesa, claroAdyacenteAlActual, distanciaDirecta, distanciaPorIntermedio;
		boolean esInterceptado = false;

		Arrays.fill(vectorDeDistancias, Grafo.INFINITO);
		
		for (Arista a : this.matrizAdyacencia.getAdyacentes(claroActual)) {
				colaCostoArista.add(a);
				vectorDeDistancias[a.getNodoDestino()] = a.getDistancia();
		}
		
		vectorDeDistancias[claroActual-1] = 0;

		while (!colaCostoArista.isEmpty()) {
			claroActual = colaCostoArista.poll().getNodoDestino() + 1;

			for (Arista a : this.matrizAdyacencia.getAdyacentes(claroActual)) {
				claroAdyacenteAlActual = a.getNodoDestino() + 1;

				distanciaDirecta = vectorDeDistancias[claroAdyacenteAlActual - 1];
				distanciaPorIntermedio = vectorDeDistancias[claroActual - 1]
						+ this.matrizAdyacencia.getDistancia(claroActual, claroAdyacenteAlActual);

				if (distanciaPorIntermedio < distanciaDirecta) {
					vecDePredecesores[claroAdyacenteAlActual-1] = claroActual-1;
					vectorDeDistancias[claroAdyacenteAlActual - 1] = distanciaPorIntermedio;
					colaCostoArista.remove(new Arista(claroAdyacenteAlActual, distanciaDirecta));
					colaCostoArista.add(new Arista(claroAdyacenteAlActual, distanciaPorIntermedio));
				}
			}
		}
		
		//me fijo si las distancias de la princesa al principe es menor que
		//la distancia de la princesa a los dragones
		
		for(Integer claroDragon: this.clarosDragones) {
			if(vectorDeDistancias[claroDragon-1] < vectorDeDistancias[claroPrincipe-1]) {
				esInterceptado = true;
				break;
			}
		}
		
		if(esInterceptado){
			return new SalidaDijkstraPrincesa("INTERCEPTADO", null);
		}
		
		if(vectorDeDistancias[claroPrincipe-1] == Grafo.INFINITO) {
			return new SalidaDijkstraPrincesa("NO HAY CAMINO", null);
		}
		
		//Armo el camino (si no fue interceptado y ese camino existe)
		List<Integer> caminoSeguro = new LinkedList<>();
		
		caminoSeguro.add(claroPrincipe);
		int k = claroPrincipe;
		while(vecDePredecesores[k] !=0) {
			k = vecDePredecesores[k-1];
			caminoSeguro.add(k+1);
		}
		
		caminoSeguro.add(claroPrincesa);
		return new SalidaDijkstraPrincesa(null, caminoSeguro);
	}

}
