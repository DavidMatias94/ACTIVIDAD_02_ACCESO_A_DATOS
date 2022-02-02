package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.*;

//La interfaz no es obligatoria pero si recomendable 
//Una interfaz sería una colección de métodos abstractos donde dichos métodos son públicos

//Esta interfaz define un CRUD para el objeto Coche

//Las interfaces nos dicen qué podemos hacer pero no cómo, este vendría de la mano de la implementación

public interface DaoCoche {
	
	public boolean alta(Coche c);
	public boolean baja(int id);
	public boolean modificar(Coche c);
	public Coche obtener(int id);
	public List<Coche> listar();

}
