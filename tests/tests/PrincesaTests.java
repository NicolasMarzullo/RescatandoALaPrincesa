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
			grafo.resolver();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
