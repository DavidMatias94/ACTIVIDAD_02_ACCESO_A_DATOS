package test;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.dao.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;
import modelo.persistencia.dao.DaoPasajeroMysql;
import modelo.persistencia.interfaces.DaoPasajero;


public class principal {

	public static void main(String[] args) {
		
		
		//List<Coche> listaCoches = new ArrayList<Coche>();
		Coche ch = new Coche();
		Pasajero ps = new Pasajero();
		Scanner leer = new Scanner(System.in);
		boolean hacer = false;
		
		do {


			System.out.println("Elija una opción: " + "\n" +"1.Añadir nuevo coche" + "\n"+"2.Borrar coche por id"+
					"\n"+"3.Consultar coches por id"+"\n"+"4.Modificar coche por id"+"\n"+"5.Listado de coches"+"\n"+"6.Gestión del Pasajero"+"\n"+"7.Terminar el programa");	 



			DaoCoche dc = new DaoCocheMySql();
			DaoPasajero dp = new DaoPasajeroMysql();

			int opcion = leer.nextInt();


			switch (opcion) {


			case 1:
				
				
			//	System.out.println("Introduzca id:");
				//int addId = leer.nextInt();
			//	ch.setId(addId);

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
				
				
				//ch.setId(ch.getId());
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
				System.out.println("Elija una opción: "+"\n"+"1.Añadir nuevo Pasajero"+"\n"+"2.Borrar Pasajero por id"+"\n"+"3.Consultar Pasajero por id"+"\n"+"4.Listar todos los pasajeros"+"\n"
			+"5.Añadir Pasajero a coche"+"\n"+"6.Eliminar pasajero de un coche"+"\n"+"7.Listar todos los pasajeros de un coche");
				
				
				int opcion2 = leer.nextInt();
				
				switch(opcion2) {
				
				case 1:
					
					System.out.println("Introduzca el id :");
					int addId = leer.nextInt();
					ps.setId(addId);
					
					System.out.println("Introduzca el nombtre");
					String addNombre = leer.next();
					ps.setNombre(addNombre);
					
					System.out.println("Introduzca la edad : ");
					int addEdad = leer.nextInt();
					ps.setEdad(addEdad);
					
					System.out.println("Introduzca el peso: ");
					int addPeso = leer.nextInt();
					ps.setPeso(addPeso);
					
					System.out.println("Introduzca el id del coche:");
					
					ps.setId(addId);
					
					ps.setId(ps.getId());
					ps.setNombre(ps.getNombre());
					ps.setEdad(ps.getEdad());
					ps.setPeso(ps.getPeso());
					ps.setId(ps.getId());
					
					boolean altaPax = dp.altaPax(ps);
					if(altaPax){
						System.out.println("El pasajero se ha dado de alta");
					}else{
						System.out.println("El pasajero NO se ha dado de alta");
					}
					
					
					break;
					
					
				case 2:
					
					
					System.out.println("Introduzca un Id para dar de baja el pasajero:");
					int borrarPax = leer.nextInt();
					boolean bajaPax = dp.bajaPax(borrarPax);
					if(bajaPax){
						System.out.println("El Pasajero se ha dado de baja");
					}else{
						System.out.println("El Pasajero NO se ha dado de baja");
					}
					break;
					
				case 3:
					
					System.out.println("Introduzca un id para consultar un pasajero: ");
					int consultarPax = leer.nextInt();
					Pasajero ps2 = dp.obtenerPax(consultarPax);
					System.out.println(ps2);
					
					
					break;
					
				case 4 :
					
					System.out.println("****** LISTANDO PASAJEROS ******");
					
					List<Pasajero> listaPax2 = dp.listarPax();
					for(Pasajero p : listaPax2){
						System.out.println(p);
					}
					
					break;
					
					
				case 5 :
					
					System.out.println("Introduzca id de pasajero:");
					int modificarPorId2 = leer.nextInt();

					
					System.out.println("Introduzca un id de coche: ");
					int modificarPorid3 = leer.nextInt();
					
					
					
					
					boolean modificar2 = dp.addPax(modificarPorId2, modificarPorid3);
					
					if(modificar2){
						System.out.println("El coche se ha modificado");
					}else{
						System.out.println("El coche NO se ha modificado");
					}
					
					
					break;
					
				case 6 : 
					
					System.out.println("Introduzca el id del pasajero que quiere borrar : ");
					int borrarPax2 = leer.nextInt();
					
					System.out.println("Introduzca el coche del que quiere borrar el pasajero: ");
					int borrardeCoche = leer.nextInt();
					
					boolean eliminarDeCoche = dp.eliminarDeCoche(borrarPax2,borrardeCoche);
					if(eliminarDeCoche){
						System.out.println("El pasajero se ha dado de baja");
					}else{
						System.out.println("El pasajero NO se ha dado de baja");
					}
					break;
				case 7: 
					
					System.out.println("Introduzca un id del coche");
					
					int idLista = leer.nextInt();
					
					List<Pasajero> listaCoches3 = dp.listarPaxCoche(idLista);
					for(Pasajero p : listaCoches3){
						System.out.println(p);
					}
					break;
				
				}
				
				
				break;
			case 7:
				

				hacer=true;
				System.out.println("Terminaste");
				break;
			default:

				System.out.println("Elija otra opción");
			}

		}while(!hacer);


	}

}
