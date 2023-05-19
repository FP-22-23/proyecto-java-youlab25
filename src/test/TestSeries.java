package test;

import java.util.Collection;

import fp.tipos.netflix.Estado;
import fp.tipos.netflix.FactoriaNetflix;
import fp.tipos.netflix.Netflix;
import fp.tipos.netflix.Series;

public class TestSeries {
	
	
	
	private static Series movies = new Series(FactoriaNetflix.leerSeries("data/netflix_originals.csv"));
	private static Collection<Netflix> col = FactoriaNetflix.leerSeries("data/netflix_originals.csv");
	
	private static String s = "Ana;Crime drama;Netflix:Disney;12/03/2020;1;6;Ended;false;28.94760201";
	private static Netflix n1 = new Netflix(s);

	public static void main(String[] args) {
		
		//----------------------------------- ENTREGA 2 -----------------------------------
		
//	//Operaciones básicas
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

	
		
		//----------------------------------- ENTREGA 3 -----------------------------------
				//1
		testExisteSerieConGeneroStream("Fiction"); //Devuelve false
		testExisteSerieConGeneroStream("Drama"); //Devuelve true
				//2
		testGetMediaVisualizacionNetflixStream("Drama");
				//3
		testGetSeriesLargasStream();
				//4
		testGetSerieMundialMaxTemporadas();
				//5
		testGetSerieMundialEstadoOrdenadoFechaVisualizacion(Estado.ENDED);
				//6
		testGetNumeroSeriesPorEstadoStream();  //Función 4 de la entrega 2 con Stream
				//7
		testGetTitulosPorEstadoStream();
				//8
		testGetVisualizacionPorFechaStream();
				//9
		testGetSeriesPeoresPorEstado(3);
				//10
		testGetMejorSeriePorMedia();
		
		
		
		
	}
	
	
	
	
	//----------------------------------- ENTREGA 2 ---------------------------------------------------
	
	
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
			
			
			
			
			//----------------------------------- ENTREGA 3 -----------------------------------------------------

		
				// 1 -> ¿Existe alguna serie con un genero pasado por parámetro?
				private static void testExisteSerieConGeneroStream(String genero) {
					System.out.println("\n----testExisteSerieConGeneroStream----");
					try {
					System.out.println("¿Hay alguna serie con genero " + genero +"?");
					System.out.println(movies.existeSerieConGeneroStream(genero));
					} catch(Exception s) {
						System.out.println("Excepción capturada:\n   " + s);	
					}}
					
				// 2 -> Media de visualizacion de las series con genero pasado por parámetro
					private static void testGetMediaVisualizacionNetflixStream(String genero) {
						System.out.println("\n----testGetMediaVisualizacionNetflixStream(String genero)----");
						try {
						System.out.println("La visualizacion media de las series con genero " + genero +" es: ");
						System.out.print(movies.getMediaVisualizacionNetflixStream(genero)+"\n");
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}}
				
				// 3 -> Selección de series con más de 10 capitulos 
					private static void testGetSeriesLargasStream() {
						System.out.println("\n----testGetSeriesLargasStream()----");
						try {
						System.out.println("Las series largas son: ");
						System.out.print(movies.getSeriesLargasStream()+"\n");
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
				// 4 -> Serie mundial y más temporadas
					private static void testGetSerieMundialMaxTemporadas() {
						System.out.println("\n----testGetSerieMundialMaxTemporadas()----");
						try {
							System.out.println("La serie mundial que tiene más temporadas es: ");
							System.out.println(movies.getSerieMundialMaxTemporadas());
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
				// 5 -> Selección de series mundiales de estado pasado por parámetro 
					//ordenadas por fecha de estreno de la serie y después por visualizacion. 
					private static void testGetSerieMundialEstadoOrdenadoFechaVisualizacion(Estado e) {
						System.out.println("\n----testGetSerieMundialEstadoOrdenadoFechaVisualizacion"
								+ "Visualizacion(Estado e)----");
						try {
							System.out.println("Las series mundiales ordenadas por fecha de "
									+ "estreno y visualizacion son: ");
							System.out.println(movies.getSerieMundialEstadoOrdenadoFechaVisualizacion(e));
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
					
				// 6 -> Diccionario contador: seies por estados
					private static void testGetNumeroSeriesPorEstadoStream() {
						System.out.println("\n----testGetNumeroSeriesPorEstadoStream()----");
						try {
							System.out.println("Diccionario contador: seies por estados ");
							System.out.println(movies.getNumeroSeriesPorEstadoStream());
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
				// 7 -> Diccionario que obtiene por cada estado los titulos de las series.
					private static void testGetTitulosPorEstadoStream() {
						System.out.println("\n----testGetTitulosPorEstadoStream()----");
						try {
							System.out.println("Diccionario que obtiene por cada estado los titulos de las series.\n");
							System.out.println(movies.getTitulosPorEstadoStream());
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
				//8 -> Devuelve un map en el que las claves son los años de la fecha de estreno y 
					//los valores la serie con mayor visualizaciones (max)
					private static void testGetVisualizacionPorFechaStream(){
						System.out.println("\n----testGetVisualizacionPorFechaStream()----");
						try {
							System.out.println("Devuelve un map en el que las claves son los años"
									+ "\n de estreno y los valores la serie con mayor "
									+ "\n visualizaciones (max).\n");
							System.out.println(movies.getVisualizacionPorFechaStream());
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
					
					//9 ->  Devuelve un SortedMap en el que las claves son los estados y los valores 
					//son listas con las n peores series de ese estado.
					private static void testGetSeriesPeoresPorEstado(Integer n){
						System.out.println("\n----testGetSeriesPeoresPorEstado----");
						try {
							System.out.println("Devuelve un SortedMap en el que las claves son los estados y"
									+ "\n los valores son listas con las n peores series de ese estado. ");
							System.out.println(movies.getSeriesPeoresPorEstado(n));
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
				//10 -> Calcula un map con la visualizacion media por genero y devuelve 
					//el genero con mayor visualizacion
					private static void testGetMejorSeriePorMedia(){
						System.out.println("\n----testGetMejorSeriePorMedia()----");
						try {
							System.out.println("Calcula un map con la visualizacion media por genero y devuelve "
									+ "el genero con mayor visualizacion\n");
							System.out.println(movies.getMejorSeriePorMedia());
						} catch(Exception s) {
							System.out.println("Excepción capturada:\n   " + s);	
						}
					}
					
					
					
					
					
		}


				

