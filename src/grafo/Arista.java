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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distancia;
		result = prime * result + nodoDestino;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (distancia != other.distancia)
			return false;
		if (nodoDestino != other.nodoDestino)
			return false;
		return true;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

}
