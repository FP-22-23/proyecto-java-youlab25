package test;

import java.time.LocalDate;

import fp.tipos.netflix.Estado;
import fp.tipos.netflix.Netflix;

public class TestNetflix {

	public static void main(String[] args) {
		//Constructor 1
				Netflix d1 = new Netflix("Kido","Drama",LocalDate.of(2016,9,15),4,12, Estado.MINISERIES,true, 17.87488); 
				
				System.out.println(d1);
				/*
				System.out.println(d2.getTitulo());
				System.out.println(d2.getGenero());
				System.out.println(d2.getPlataforma());
				System.out.println(d2.getMundial());
				System.out.println(d2.getCapitulos());
				System.out.println(d2.getTemporadas());
				System.out.println(d2.getVisualizaciones());
				System.out.println(d2.getEstado());
				System.out.println(d2.getfEstreno());
				System.out.println(d2.getTipoClasificacion());
				*/
				
				//System.out.println(d1.getFormatoCorto());
				

				//Constructor 2
				Netflix d2 = new Netflix("Kido; Drama; Netflix:HBO; 15/09/2016;	4; 12; Miniseries; true; 17.87488");
				
				System.out.println(d2);
				/*
				System.out.println(d2.getTitulo());
				System.out.println(d2.getGenero());
				System.out.println(d2.getPlataforma());
				System.out.println(d2.getMundial());
				System.out.println(d2.getCapitulos());
				System.out.println(d2.getTemporadas());
				System.out.println(d2.getVisualizaciones());
				System.out.println(d2.getEstado());
				System.out.println(d2.getfEstreno());
				System.out.println(d2.getTipoClasificacion());
				*/
		
				//System.out.println(d2.getFormatoCorto());
				
				Netflix d3 = new Netflix("The Lions; Social Drama; Netflix:Amazon; 12/12/2009;	2; 11; Ended; false; 22.97487");
				System.out.println(d3);
				
				
				
				
				System.out.println(d1==d2);
				System.out.println(d1==d3);
				System.out.println(d3==d2);
				
				
				
				System.out.println(d1.equals(d2)); 
				System.out.println(d1.equals(d3));
				System.out.println(d3.equals(d2));
				
				
				/*
				System.out.println(d2.hashCode() == d1.hashCode());
				System.out.println(d2.hashCode() == d3.hashCode()); 
				*/
				
				
				System.out.println(d1.compareTo(d2)); 
				System.out.println(d1.compareTo(d3)); // 
				
				

	}

}
