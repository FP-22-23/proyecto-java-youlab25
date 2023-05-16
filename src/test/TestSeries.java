package test;

import java.util.Collection;

import fp.tipos.netflix.FactoriaNetflix;
import fp.tipos.netflix.Netflix;
import fp.tipos.netflix.Series;

public class TestSeries {
	
	
	
	private static Series movies = new Series(FactoriaNetflix.leerSeries("data/netflix_originals.csv"));
	private static Collection<Netflix> col = FactoriaNetflix.leerSeries("data/netflix_originals.csv");
	
	private static String s = "Ana;Crime drama;Netflix:Disney;12/03/2020;1;6;Ended;false;28.94760201";
	private static Netflix n1 = new Netflix(s);

	public static void main(String[] args) {
		testOperacionesBasicas();
		
		
		//Tratamientos secuenciales 
					//1
		testExisteSerieConGenero("Drama"); //Devuelve true
		testExisteSerieConGenero("Romantica"); //Devuelve false
					//2
		testGetMediaVisualizacionNetflix("Superhero fiction");
					//3
		testGetSeriesLargas();
					//4
		testGetSeriesPorCategoria();
					//5
		testGetNumeroSeriesPorEstado();
				
			}
	
	//Test operaciones básicas
		private static void testOperacionesBasicas() {
			System.out.println("\n----TestVariasOperaciones----");
			try {
			//Obtener el número de elementos
			System.out.println("El numero de elementos del contenedor es: " + movies.getNumeroSeries()+"\n");
			
			//b -->	Añadir un elemento
			System.out.println("Añado n1 al contenedor");
			movies.anadirSerie(n1);
			System.out.println("Series contiene a n1: " + movies.getMovies().contains(n1) +
					"\nAhora el numero de elemetos es: " + movies.getNumeroSeries()+ "\n");

			//c --> Añadir una colección de elementos
			System.out.println("Añado una colección de elementos");
			movies.anadirColeccion(col);
			System.out.println("Ahora el numero de elemetos es: " + movies.getNumeroSeries()+ "\n");
			
			//d --> Eliminar un elemento
			System.out.println("Elimino n1 del contenedor");
			movies.eliminarSerie(n1);
			System.out.println("Series contiene a n1: " + movies.getMovies().contains(n1) +
					"\nAhora el numero de elemetos es: " + movies.getNumeroSeries()+ "\n");

			} catch(Exception e) {
				System.out.println("Excepción capturada:\n   " + e);	
			}
		}
		
		//Test Tratamientos secuenciales
				// 1 -> ¿Existe alguna serie  con el genero pasado por parámetro?
			private static void testExisteSerieConGenero(String genero) {
				System.out.println("\n----TestExisteSerieConGenero----");
				try {
				System.out.println("¿Hay alguna serie con genero " + genero +"?"+"\n");
				System.out.println(movies.existeSerieConGenero(genero));
				} catch(Exception e) {
					System.out.println("Excepción capturada:\n   " + e);	
				}
			}
				// 2 -> Media de visualizacion de la serie pasada por parámetro 
			private static void testGetMediaVisualizacionNetflix(String genero) {
				System.out.println("\n----testGetMediaVisualizacionNetflix(String genero)----");
				try {
					System.out.println("La visualizacion media del genero " + genero +" es: ");
					System.out.print(movies.getMediaVisualizacionNetflix(genero)+"\n");
				} catch(Exception e) {
					System.out.println("Excepción capturada:\n   " + e);	
				}
			}
				// 3 -> Selección de series con más de 10 capitulos
			
			private static void testGetSeriesLargas() {
				System.out.println("\n----testGetSeriesLargas()----");
				try {
					System.out.println("Las series largas son: ");
					System.out.print(movies.getSeriesLargas()+"\n");
				} catch(Exception e) {
					System.out.println("Excepción capturada:\n   " + e);	
				}
			}
				// 4 -> Agrupa series por categoria
			
			private static void testGetSeriesPorCategoria() {
				System.out.println("\n----testGetSeriesPorCategoria----");
				try {
					System.out.println("Las series agrupados por categoria son ");
					System.out.println(movies.getSeriesPorCategoria());
				} catch(Exception e) {
					System.out.println("Excepción capturada:\n   " + e);	
				}
			}
				// 5 -> Diccionario contador: series por estado
			
			private static void testGetNumeroSeriesPorEstado() {
				System.out.println("\n----testGetNumeroSeriesPorEstado()----");
				try {
					System.out.println("El número de series por estado es: ");
					System.out.println(movies.getNumeroSeriesPorEstado());
				} catch(Exception e) {
					System.out.println("Excepción capturada:\n   " + e);	
				}
			}

	

}

