package aeroport;
import java.util.List;

public interface IavionCatalogue {

	public List<Avion> getAvionsParMotCle(String mc);
	public void addAvion(Avion a);

}
