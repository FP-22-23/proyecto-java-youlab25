package fp.tipos.netflix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import common.TipoClasificacion;
import utiles.Checkers;

public class Netflix {
	private String titulo;
	private String genero;
	private List<String> plataforma;
	private LocalDate fEstreno;
	private Integer temporadas;
	private Integer capitulos;
	private Estado estado;
	private Boolean mundial;
	private Double visualizaciones;
	
	
	//CONSTRUCTOR 1
		public Netflix(String titulo, String genero, LocalDate fEstreno,
				Integer temporadas,Integer capitulos, Estado estado,Boolean mundial, 
				Double visualizaciones) {
			Checkers.check("El nombre de la serie no puede estar vacio", 
					titulo.trim() != "");
			Checkers.check("El numero de capitulos tiene que ser mayor que 0",
					capitulos > 0);
			
			this.titulo=titulo;
			this.genero=genero;
			this.plataforma=null;
			this.fEstreno=fEstreno;
			this.temporadas=temporadas;
			this.capitulos=capitulos;
			this.estado=estado;
			this.mundial=mundial;
			this.visualizaciones=visualizaciones;
		}
		
	//CONSTRUCTOR 2
		public Netflix(String s) {
			String[] sp = s.split(";");
			if (sp.length != 9) {
				//System.out.println(sp.length);
				throw new IllegalArgumentException(
						"Cadena con formato no válido");
			}
			
			Checkers.check("El nombre de la serie no puede estar vacio", 
					sp[0].trim() != "");
			Checkers.check("El numero de empleados tiene que ser mayor que 0",
					Integer.valueOf(sp[5].trim()) > 0);
			
			this.titulo = sp[0].trim();
			this.genero = sp[1].trim();
			List<String> lista = new LinkedList<String>();
			String[] plataforma = sp[2].trim().split(":");
			for (String h : plataforma) {
				lista.add(h);
			}
			this.plataforma = lista;
			this.fEstreno = LocalDate.parse(sp[3].trim(), DateTimeFormatter.ofPattern("d/M/yyyy"));
			this.temporadas = Integer.valueOf(sp[4].trim());
			this.capitulos = Integer.valueOf(sp[5].trim());
			this.estado = Estado.valueOf(sp[6].trim().toUpperCase());
			this.mundial = Boolean.valueOf(sp[7].trim());
			this.visualizaciones = Double.valueOf(sp[8].trim()); 
		}
		
		//-----Parseo-----
		
		public Estado formateoEnum(String s) {
			Estado res = null;
			switch (s) {
			case "Ended":
				res = Estado.ENDED;
				break;
			case "Miniseries":
				res = Estado.MINISERIES;
				break;
			case "Pending":
				res = Estado.PENDING;
				break;
			default:
				res = Estado.RENEWED;
				
			}
			return res;
		}
		
		//-----GETTERS AND SETTERS-----;

		public String getTitulo() {
			return titulo;
		}

		public String getGenero() {
			return genero;
		}

		public List<String> getPlataforma() {
			return plataforma;
		}

		public LocalDate getfEstreno() {
			return fEstreno;
		}

		public Integer getTemporadas() {
			return temporadas;
		}

		public Integer getCapitulos() {
			return capitulos;
		}

		public Estado getEstado() {
			return estado;
		}

		public Boolean getMundial() {
			return mundial;
		}

		public Double getVisualizaciones() {
			return visualizaciones;
		}
		
		//-------------------

		public void setTitulo(String titulo) {
			Checkers.check("El nombre de la serie no puede estar vacio", 
					titulo.trim() != "");
			this.titulo = titulo;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		public void setVisualizaciones(Double visualizaciones) {
			this.visualizaciones = visualizaciones;
		}
		
		
		public TipoClasificacion getTipoClasificacion() {
			TipoClasificacion res= TipoClasificacion.A;
			if(getTemporadas()<2) {
				res= TipoClasificacion.C;
			}
			else if (getTemporadas()<= 4) {
				res= TipoClasificacion.B;
			}
			return res;
			
		}
		
		//-----FormatoCorto ----- (propiedad derivada)-----
		public String getFormatoCorto() {
			String res = getTitulo();
			if (getfEstreno() != null) {
				res += ", fue estrenada en el año " + getfEstreno().getYear();
			}
			if (getVisualizaciones() != null) {
				res += ", tiene visualizaciones" + getVisualizaciones()+"/5" ;
			}
			return res;
		}

		@Override
		public String toString() {
			return "Netflix [titulo=" + titulo + ", genero=" + genero + ", plataforma=" + plataforma + ", fEstreno="
					+ fEstreno + ", temporadas=" + temporadas + ", capitulos=" + capitulos + ", estado=" + estado
					+ ", mundial=" + mundial + ", visualizaciones=" + visualizaciones + "]";
		}

		
		
		@Override
		public int hashCode() {
			return Objects.hash(capitulos, estado, fEstreno, mundial, temporadas, titulo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Netflix other = (Netflix) obj;
			return Objects.equals(capitulos, other.capitulos) && estado == other.estado
					&& Objects.equals(fEstreno, other.fEstreno) && Objects.equals(mundial, other.mundial)
					&& Objects.equals(temporadas, other.temporadas) && Objects.equals(titulo, other.titulo);
		}

		//-----CompareTo-----
		public int compareTo(Netflix n1) {
			int r = this.getTitulo().compareTo(n1.getTitulo());
			if (r==0) {
				r = this.getTemporadas().compareTo(n1.getTemporadas());
			}
			if (r==0) {
				r = this.getCapitulos().compareTo(n1.getCapitulos());
			}
			if (r==0) {
				r = this.getfEstreno().compareTo(n1.getfEstreno());
			}
			return r;
		}
		
			
		
		
}
