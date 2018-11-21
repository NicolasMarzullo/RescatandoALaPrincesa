package tests;

import java.io.FileNotFoundException;

import org.junit.Test;

import grafo.Grafo;
import princesa.Archivo;

public class PrincesaTests {

	@Test
	public void testCasoEnunciado() {
		try {
			Grafo grafo = Archivo.cargarArchivo("tests/lotes/in/01_CasoEnunciado.in");
			Archivo.imprimirSalida("tests/lotes/out/01_CasoEnunciado.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testPrincipePuedeRescatarla() {
		try {
			Grafo grafo = Archivo.cargarArchivo("tests/lotes/in/02_CasoPrincipePuedeRescatarla.in");
			Archivo.imprimirSalida("tests/lotes/out/02_CasoPrincipePuedeRescatarla.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
