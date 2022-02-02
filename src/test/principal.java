package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.entidad.Coche;
import modelo.persistencia.dao.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;


public class principal {

	public static void main(String[] args) {
		
		
		//List<Coche> listaCoches = new ArrayList<Coche>();
		Coche ch = new Coche();
		Scanner leer = new Scanner(System.in);
		boolean hacer = false;
		
		do {


			System.out.println("Elija una opción: " + "\n" +"1.Añadir nuevo coche" + "\n"+"2.Borrar coche por id"+
					"\n"+"3.Consultar coches por id"+"\n"+"4.Modificar coche por id"+"\n"+"5.Listado de coches"+"\n"+"6.Terminar el programa");	 



			DaoCoche dc = new DaoCocheMySql();

			int opcion = leer.nextInt();


			switch (opcion) {


			case 1:
				
				
				System.out.println("Introduzca id:");
				int addId = leer.nextInt();
				ch.setId(addId);

				System.out.println("Introduzca matrícula:");
				String addMatricula = leer.next();
				ch.setMatricula(addMatricula);

				System.out.println("Introduca la marca: ");
				String addMarca= leer.next();
				ch.setMarca(addMarca);

				System.out.println("Introduzca modelo:");
				String addModelo= leer.next();
				ch.setModelo(addModelo);

				System.out.println("Introduzca color:");
				String addColor=leer.next();
				ch.setColor(addColor);


				//listaCoches.add(ch);
				
				
				ch.setId(ch.getId());
				ch.setMatricula(ch.getMatricula());
				ch.setMarca(ch.getMarca());
				ch.setModelo(ch.getModelo());
				ch.setColor(ch.getColor());
				
				
				
				boolean alta = dc.alta(ch);
				if(alta){
					System.out.println("El coche se ha dado de alta");
				}else{
					System.out.println("El coche NO se ha dado de alta");
				}
				

				break;
			case 2:
				
				System.out.println("Introduzca un Id para dar de baja el vehículo:");
				int borrarVehiculo = leer.nextInt();
				boolean baja = dc.baja(borrarVehiculo);
				if(baja){
					System.out.println("El coche se ha dado de baja");
				}else{
					System.out.println("El coche NO se ha dado de baja");
				}
				

				break;
			case 3:
				
				
				System.out.println("Introduzca un id para consultar un vehículo: ");
				int consultarVehiculo = leer.nextInt();
				Coche coche2 = dc.obtener(consultarVehiculo);
				System.out.println(coche2);
				
				
				
				break;
			case 4:
				
				Coche c2 = new Coche();
				
				System.out.println("Introduzca id:");
				int modificarPorId = leer.nextInt();
				c2.setId(modificarPorId);

				System.out.println("Introduzca matrícula:");
				String modificarMatricula = leer.next();
				c2.setMatricula(modificarMatricula);

				System.out.println("Introduca la marca: ");
				String modificarMarca= leer.next();
				c2.setMarca(modificarMarca);

				System.out.println("Introduzca modelo:");
				String modificarModelo= leer.next();
				c2.setModelo(modificarModelo);

				System.out.println("Introduzca color:");
				String modicarColor=leer.next();
				c2.setColor(modicarColor);
				
				
				
				
				boolean modificar = dc.modificar(c2);
				
				if(modificar){
					System.out.println("El coche se ha modificado");
				}else{
					System.out.println("El coche NO se ha modificado");
				}
				
				break;
			case 5 :
				
				System.out.println("********* LISTANDO TODOS LOS COCHES **********");
				
				List<Coche> listaCoches2 = dc.listar();
				for(Coche c : listaCoches2){
					System.out.println(c);
				}
				
				break;
			case 6:
				

				hacer=true;
				System.out.println("Terminaste");
				break;
			default:

				System.out.println("Elija otra opción");
			}

		}while(!hacer);


	}

}
