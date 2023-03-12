package test;

import java.time.LocalDate;

import fp.tipos.netflix.Estado;
import fp.tipos.netflix.Netflix;

public class TestNetflix {

	public static void main(String[] args) {
		Netflix n1 = new Netflix("Hemlock Grove", "Horror", "Netflix", LocalDate.of(2016, 2, 26), 3, 20, Estado.RENEWED, true, 21.72387539);
		Netflix n2 = new Netflix("Hemlock Grove","Horror","Netflix", LocalDate.of(2016, 2, 26), 12, false, 21.72387539);
		Netflix n3 = new Netflix("House of Cards","Political drama","Netflix", LocalDate.of(2013, 2, 3), 10, true, 33.38184514);
		System.out.println(n1);
		n1.setEstado(Estado.PENDING);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println("Codigo hash de n1:" + n1.hashCode());
		System.out.println("Codigo hash de n2:" + n2.hashCode());
		System.out.println("Codigo hash de n3:" + n3.hashCode());
		System.out.println("Son n1 y n2 iguales?:" + n1.equals(n2));
		System.out.println("Son n1 y n3 iguales?:" + n1.equals(n3));
		System.out.println("resultado n1.comparateTo(n2): " + n1.compareTo(n2));
		System.out.println("resultado n2.comparateTo(n3): " + n2.compareTo(n3));
		Netflix n4 = new Netflix(null, "Horror", "Netflix", LocalDate.of(2016, 2, 26), 3, 20, Estado.RENEWED, true, 21.72387539);
		System.out.println(n4); //comprobacion de la restriccion 1
		Netflix n5 = new Netflix("Hemlock Grove", "Horror", "Netflix", LocalDate.of(2016, 2, 26), 3, 20, Estado.RENEWED, true, -21.72387539);
		System.out.println(n4); //comprobacion de la restriccion 2

	}

}

