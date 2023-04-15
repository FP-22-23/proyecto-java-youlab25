package fp.tipos.netflix;

import java.time.LocalDate;
import java.util.Objects;

import utiles.Checkers;

public class Netflix implements Comparable<Netflix>{
	private String titulo;
	private String genero;
	private String plataforma;
	private LocalDate fEstreno;
	private Integer temporadas;
	private Integer capitulos;
	private Estado estado;
	private Boolean mundial;
	private Double visualizaciones;
	
	
	
	//CONSTRUCTOR 1
	public Netflix(String titulo, String genero, String plataforma, LocalDate fEstreno,
			Integer temporadas,Integer capitulos, Estado estado,Boolean mundial, 
			Double visualizaciones) {
		//RESTRICCION
		Checkers.check("Error en titulo", titulo != null);
		this.titulo=titulo;
		this.genero=genero;
		this.plataforma=plataforma;
		this.fEstreno=fEstreno;
		this.temporadas=temporadas;
		this.capitulos=capitulos;
		this.estado=estado;
		this.mundial=mundial;
		this.visualizaciones=visualizaciones;
				
	}
	
	//CONSTRUCTOR 2
	public Netflix(String titulo, String genero, String plataforma, LocalDate fEstreno,
			Integer capitulos, Boolean mundial, 
			Double visualizaciones) {
		this.titulo=titulo;
		this.genero=genero;
		this.plataforma=plataforma;
		this.fEstreno=fEstreno;
		this.temporadas=null;
		this.capitulos=capitulos;
		estado=Estado.ENDED;
		this.mundial=mundial;
		this.visualizaciones=visualizaciones;
				
	}
	
	//GETTERS Y SETTERS

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public LocalDate getfEstreno() {
		return fEstreno;
	}

	public Integer getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	public Integer getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Integer capitulos) {
		this.capitulos = capitulos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Boolean getMundial() {
		return mundial;
	}

	public void setMundial(Boolean mundial) {
		this.mundial = mundial;
	}

	public Double getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(Double visualizaciones) {
		//RESTRICCION 
		Checkers.check("Error en las visualizaciones", visualizaciones >0);
		this.visualizaciones = visualizaciones;
	}

	public String toString() {
		return "Netflix [titulo=" + titulo + ", genero=" + genero + ", plataforma=" + plataforma + ", fEstreno="
				+ fEstreno + ", temporadas=" + temporadas + ", capitulos=" + capitulos + ", estado=" + estado
				+ ", mundial=" + mundial + ", visualizaciones=" + visualizaciones + getTipoClasificacion() + "]";
	}

	/**
	 * dos series son iguales si su titulo y fecha de estreno son iguales.
	 */
	public int hashCode() {
		return Objects.hash(fEstreno, titulo);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Netflix other = (Netflix) obj;
		return Objects.equals(fEstreno, other.fEstreno) && Objects.equals(titulo, other.titulo);
	}
	
	/**
	 * @return La clasificación de la serie según las visualizaciones.
	 */
	public TipoClasificacion getTipoClasificacion() {
		TipoClasificacion res= TipoClasificacion.A;
		if(getVisualizaciones()<10) {
			res= TipoClasificacion.C;
		}
		else if (getVisualizaciones()<= 30) {
			res= TipoClasificacion.B;
		}
		return res;
		
	}
	/**
	 * Las series se ordenan por titulo y fecha de estreno.
	 */
		
	public int compareTo(Netflix n) {
			int r;
			r = getTitulo().compareTo(n.getTitulo());
			if (r == 0) {
				r = getfEstreno().compareTo(n.getfEstreno());
			}
			return r;
	
}
	
	
//	JKK
//	KJK

}





//ghgergjtrjhyh



