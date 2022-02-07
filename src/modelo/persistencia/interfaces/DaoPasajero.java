package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Pasajero;
import modelo.entidad.Coche;

public interface DaoPasajero {
	
	public boolean altaPax(Pasajero p);
	public boolean bajaPax(int id);
	
	public Pasajero obtenerPax(int id);
	public List<Pasajero> listarPax();
	public boolean addPax(int id, int idCoche);
	public boolean eliminarDeCoche(int id, int idCoche);
	public List<Coche> listarPaxCoche(int id);
	
	

}
