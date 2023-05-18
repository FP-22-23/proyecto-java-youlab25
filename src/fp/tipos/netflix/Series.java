package fp.tipos.netflix;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Series {
	
	private List<Netflix> movies;
	
	//Constructor 1: construye una colección vacía
	public Series() {
		this.movies= new ArrayList<Netflix>();
	}
	
	
	//Constructor 2: construye una colección con todos los elementos
	public Series(Collection<Netflix> Series) {
		this.movies=new ArrayList<Netflix>(Series);
	}
	
	//Getters y Setters
	public List<Netflix> getMovies() {
		return movies;
	}

	public void setMovies(List<Netflix> movies) {
		this.movies = movies;
	}



	//HashCode
	public int hashCode() {
		return Objects.hash(movies);
	}



	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		return Objects.equals(movies, other.movies);
	}



	//toString
	public String toString() {
		return "Series [movies=" + movies + "]";
	}
	
	// Obtener el número de elementos
	public Integer getNumeroSeries() {
		return movies.size();
	}
					
	//Añadir un elemento
	public void anadirSerie(Netflix n) {
			movies.add(n);	
	}
			
	//Añadir una colección de elementos
	public void anadirColeccion(Collection<Netflix> c) {
		movies.addAll(c);
	}
			
	//Eliminar un elemento
	public void eliminarSerie(Netflix n) {;
		movies.remove(n);
	}
	
	//Tratamientos secuenciales 
	// 1 -> ¿Existe alguna serie con un genero pasado por parámetro?
	public Boolean existeSerieConGenero(String genero) {
		Boolean res = false;
		for(Netflix n: movies) {
			if (n.getGenero().equals(genero)){
				res = true;
				break;
			}
		}
		return res;
	}
	// 2 -> Media de visualizacion de la Serie pasada por parámetro
	public Double getMediaVisualizacionNetflix(String genero) {
			Double total = 0.0;
			Integer contador = 0;
			for (Netflix n: movies) {
				if (n.getGenero().equals(genero)) {
					total += n.getVisualizaciones();
					contador ++;
				}}
			if (contador != 0 ) {
				Double res = total/contador;
				return res;
			}
			else { 
				return null;
			}
				
	}	
	// 3 -> Selección de series con más de 10 capitulos 
	public HashSet<String> getSeriesLargas(){
			HashSet<String> res = new HashSet<String>();
			for (Netflix n : movies) {
					if(n.getCapitulos() >10) {
						res.add(n.getTitulo());
						}
					}
			return res;
	}
	
	
	// 4 -> Agrupa series por categoria
	public Map<String, Set<Netflix>> getSeriesPorCategoria(){
			Map<String, Set<Netflix>> dicc = new HashMap<String, Set<Netflix>>();
			for (Netflix n: movies) {
					String key = n.getTitulo();
					
					if(dicc.containsKey(key)){
						Set<Netflix> value = dicc.get(key);
						value.add(n);
						dicc.put(key, value);
					}
					else {
						Set<Netflix> value = new HashSet<Netflix>();
						value.add(n);
						dicc.put(key, value);		
					}
				}
			return dicc;
				
	}
	
	
	// 5 -> Diccionario contador: series por estado
	public Map<Estado, Integer> getNumeroSeriesPorEstado(){
			Map<Estado, Integer> res = new HashMap<Estado, Integer>();
			for (Netflix n :movies) {
					Estado key = n.getEstado();
					
					if(res.containsKey(key)) {
						Integer value = res.get(key);
						value ++;
						res.put(key, value);
						
					}
					else {
						Integer value = 1;
						res.put(key, value);
					}
			}
			return res;
	}
	
	
	
	//----------------------------------- 3ª ENTREGA -----------------------------------
			//Constructor 3: crea un objeto del tipo contenedor con todos los elementos del stream.
			public Series(Stream<Netflix> movies) {
				this.movies = movies.collect(Collectors.toList());
			}
			
			//BLOQUE I	
			//1 -> ¿Existe alguna serie con un genero pasado por parámetro?
				public Boolean existeSerieConGeneroStream(String genero) {
					Boolean res = movies.stream()
							.anyMatch(e -> e.getGenero().equals(genero));
					return res;
				}
				// 2 -> Media de visualizacion de la Serie pasada por parámetro
				public Double getMediaVisualizacionNetflixStream(String genero) {
					OptionalDouble opt = movies.stream()
							.filter(e -> e.getGenero().equals(genero))
							.mapToDouble(e -> e.getVisualizaciones())
							.average();
					return opt.orElse(0.);
							
						}
			// 3 ->  Selección de series con más de 10 capitulos 
				public Set<String> getSeriesLargasStream(){
					Set<String> res = movies.stream()
							.filter(e -> e.getCapitulos() > 10)
							.map(Netflix::getTitulo)
							.collect(Collectors.toSet());
					return res;
				}
			// 4 -> Serie mundial y más temporadas
				public Netflix getSerieMundialMaxTemporadas() {
					Netflix res = movies.stream()
							.filter(e -> e.getMundial().equals(true))
							.max(Comparator.comparing(Netflix::getTemporadas))
							.orElse(null);
					return res;
				}
			// 5 -> Selección de series mundiales de estado pasado por parámetro 
				//ordenadas por fecha de estreno de la serie y después por visualizacion.
				public Set<Netflix> getSerieMundialEstadoOrdenadoFechaVisualizacion(Estado s){
					Set<Netflix> res = movies.stream()
							.filter(e -> e.getMundial().equals(true))
							.filter(e -> e.getEstado().equals(s))
							.sorted(Comparator.comparing(Netflix::getfEstreno) 
							.thenComparing(Comparator.comparing(Netflix::getVisualizaciones)))
							.collect(Collectors.toSet());
					return res;
				}
				
				//BLOQUE II	
				
				// 6 -> Diccionario contador: seies por estados
					public Map<Estado, Long> getNumeroSeriesPorEstadoStream(){
						return movies.stream()
								.collect(Collectors.groupingBy(Netflix::getEstado, Collectors.counting()));
						
					}
					
				// 7 -> Diccionario que obtiene por cada estado los titulos de las series..
					//(Collectors.mapping()
					public Map<Estado, Set<String>> getTitulosPorEstadoStream(){
						return movies.stream()
								.collect(Collectors.groupingBy(Netflix::getEstado,
										Collectors.mapping(Netflix::getTitulo, Collectors.toSet())));
					}
					
				// 8 -> Devuelve un map en el que las claves son los años de la fecha de estreno y 
					//los valores la serie con mayor visualizaciones (max)
					public Map<Integer, Double> getVisualizacionPorFechaStream(){
							Map<Integer, Set<Double>> aux =  movies.stream()
											.collect(Collectors.groupingBy(n -> n.getfEstreno().getYear(),
													Collectors.mapping(Netflix::getVisualizaciones, Collectors.toSet())));
							
							return aux.entrySet().stream()
											.collect(Collectors.toMap(
													entry-> entry.getKey(), 
													entry -> Collections.max(entry.getValue())));
					}
					
				//9-> Devuelve un SortedMap en el que las claves son los estados y los valores 
					//con listas con las n peores series de ese estado.
					public Map<Estado, List<String>> getSeriesPeoresPorEstado(Integer n){
						return movies.stream()
								.collect(Collectors.groupingBy(Netflix::getEstado, 
										TreeMap::new,
										Collectors.collectingAndThen(Collectors.toList(), 
												list -> getSeriesVisualizacion(list, n))
										));
					}
					
					//aux
					public List<String> getSeriesVisualizacion(List<Netflix> l, Integer n){
						return l.stream()
						.sorted(Comparator.comparing(Netflix::getVisualizaciones))
						.limit(n)
						.map(Netflix::getTitulo)
						.collect(Collectors.toList());
						
					}
					
					//10 -> Calcula un map con la visualizacion media por serie y devuelve 
					//la serie con mayor visualizacion
					public String getMejorSeriePorMedia() {
						
						Map<String, Double> aux = movies.stream()
								.collect(Collectors.groupingBy(Netflix::getTitulo, 
										Collectors.averagingDouble(Netflix::getVisualizaciones)));
				
						return aux.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
					}
					
}
