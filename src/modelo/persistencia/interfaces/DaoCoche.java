package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.*;

//La interfaz no es obligatoria pero si recomendable 
//Una interfaz ser�a una colecci�n de m�todos abstractos donde dichos m�todos son p�blicos

//Esta interfaz define un CRUD para el objeto Coche

//Las interfaces nos dicen qu� podemos hacer pero no c�mo, este vendr�a de la mano de la implementaci�n

public interface DaoCoche {
	
	public boolean alta(Coche c);
	public boolean baja(int id);
	public boolean modificar(Coche c);
	public Coche obtener(int id);
	public List<Coche> listar();

}
