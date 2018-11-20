package grafo;

public class Arista implements Comparable<Arista> {

	private int nodoDestino;
	private int distancia;

	public Arista(int nodoDestino, int distancia) {
		this.nodoDestino = nodoDestino;
		this.distancia = distancia;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	public int getDistancia() {
		return distancia;
	}

	@Override
	public String toString() {
		return "Arista [nodoDestino=" + nodoDestino + ", distancia=" + distancia + "]";
	}

	@Override
	public int compareTo(Arista otra) {
		return this.distancia - otra.distancia;
	}

}
