package fp.tipos.netflix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Series {
	
	private List<Netflix> movies;
	
	
	public Series() {
		this.movies= new ArrayList<Netflix>();
	}
	
	
	
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
	// 1 -> ¿Existe alguna serie en una plataforma pasada por parámetro?
	public Boolean existeSerieEnPlataforma(String plataforma) {
		Boolean res = false;
		for(Netflix n: movies) {
			if (n.getPlataforma().equals(plataforma)){
				res = true;
				break;
			}
		}
		return res;
	}
	// 2 -> Media de visualizacion de la Serie pasada por parámetro
	public Double getMediaVisualizacionNetflix(String titulo) {
			Double total = 0.0;
			Integer contador = 0;
			for (Netflix n: movies) {
				if (n.getTitulo().equals(titulo)) {
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
	
	
	
	

	
	
	

}
