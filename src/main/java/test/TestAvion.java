package test;
import java.util.List;

import aeroport.Avion;
import aeroport.AvionImpl;

public class TestAvion {

	public static void main(String[] args) {
		AvionImpl avion= new AvionImpl();
		List<Avion> avio = avion.getAvionsParMotCle("boeing");
		for (Avion a : avio)
		System.out.println(a.getNomAvion());
	}
}
