package princesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import grafo.Grafo;
import grafo.SalidaDijkstraPrincesa;

public class Archivo {

	public static Grafo cargarArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		int cantClaros, cantCaminos, cantDragones, claroPrincesa, claroPrincipe;
		cantClaros = sc.nextInt();
		cantCaminos = sc.nextInt();
		cantDragones = sc.nextInt();
		claroPrincesa = sc.nextInt();
		claroPrincipe = sc.nextInt();
		List<Integer> dragones = new LinkedList<>();
		for(int i=0; i<cantDragones;i++) {
			dragones.add(sc.nextInt());
		}
		
		Grafo grafo = new Grafo(cantClaros, claroPrincesa, claroPrincipe, dragones); 
		
		for(int i=0;i<cantCaminos;i++) {
			grafo.setDistancia(sc.nextInt(), sc.nextInt(),sc.nextInt());
		}
		
		sc.close();
		
		return grafo;
	}
	
	public static void imprimirSalida(String path, SalidaDijkstraPrincesa salida) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		
		
		if(salida.getCamino() == null) {
			pw.println(salida.getMensaje());
		}else {
			for(Integer i: salida.getCamino()) {
				pw.print(i + "  ");
			}
		}
			
		pw.close();
	}

}
