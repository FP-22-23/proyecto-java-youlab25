package fp.tipos.netflix;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoriaNetflix {
	
	//devuelve un objeto de tipo Netflix a partir de una cadena
	public static Netflix leerNetflix(String cadena) {
		Netflix res= new Netflix(cadena);
		return res;
	}
	
	//Devuelve una lista de objetos del tipo Job
	public static List<Netflix> leerSeries(String nombreFichero) {
			List<Netflix> res= new ArrayList<Netflix>();
			try { 
				List<String> lineas=Files.readAllLines(Paths.get(nombreFichero));
				for (String linea:lineas) {
					if(lineas.indexOf(linea) != 0) {
					System.out.println(linea);
					res.add(new Netflix(linea));	//Constructor a partir de String
				}}
			}catch (IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		

}
