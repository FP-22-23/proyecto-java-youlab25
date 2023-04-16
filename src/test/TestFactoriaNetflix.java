package test;

import java.util.List;

import fp.tipos.netflix.FactoriaNetflix;
import fp.tipos.netflix.Netflix;

public class TestFactoriaNetflix {

	public static void main(String[] args) {
		testLeerEmpleos("data/netflix_originals.csv");
				}
			
	private static void testLeerEmpleos(String fichero) {
				System.out.println("\nTestLeerJobs =============");
				List<Netflix> movies = FactoriaNetflix.leerSeries(fichero); 
				for (Netflix n: movies) {
					System.out.println(n);
				}

	}

}
