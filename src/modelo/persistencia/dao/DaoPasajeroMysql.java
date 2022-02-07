package modelo.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMysql implements DaoPasajero {
	
	
private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "safdar";
		String password = "root";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean altaPax(Pasajero p) {
		
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into personas (id_personas,nombre,edad,peso,coches_id) "
				+ " values(?,?,?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			//ps.setInt(1, c.getId());
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setInt(3, p.getEdad());
			ps.setInt(4, p.getPeso());
			ps.setInt(5, p.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
		
		
		
	}

	@Override
	public boolean bajaPax(int id) {
		
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from personas where id_personas = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
		
		
		
	}

	@Override
	public Pasajero obtenerPax(int id) {
		
		Pasajero pax2 = new Pasajero();
		
		if(!abrirConexion()){
			return null;
		}		
		
		
		String query = "select id_personas,nombre,edad,peso from personas "
				+ "where id_personas = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				
				pax2.setId(rs.getInt(1));
				pax2.setNombre(rs.getString(2));
				pax2.setEdad(rs.getInt(3));
				pax2.setPeso(rs.getInt(4));
			
				
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "pasajero con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return pax2;
	}

	@Override
	public List<Pasajero> listarPax() {
		
		if(!abrirConexion()){
			return null;
		}		
		List<Pasajero> listaPax = new ArrayList<>();
		
		String query = "select id_personas,nombre,edad,peso from personas";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Pasajero pax = new Pasajero();
				
				pax.setId(rs.getInt(1));
				pax.setNombre(rs.getString(2));
				pax.setEdad(rs.getInt(3));
				pax.setPeso(rs.getInt(4));
				
				
				listaPax.add(pax);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los "
					+ "coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPax;
		
	}

	@Override
	public boolean addPax(int id, int idCoche) {
		
		
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update autos set ID=?, "
				+ " WHERE id_personas=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setInt(1, idCoche);
			ps.setInt(2, id);
			
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar el "
					+ " coche " );
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
		
		
		
	}

	
	@Override
	public boolean eliminarDeCoche(int id, int idCoche) {
		
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete personas_id from autos where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
		
		
		
	}

	@Override
	public List<Pasajero> listarPaxCoche(int id) {
		if(!abrirConexion()){
			return null;
		}
		
		List<Pasajero> ListaPax = new ArrayList<>();
		String query = "select id_personas,nombre,edad,peso from personas where coches_id=?";
			try { 
				PreparedStatement ps = conexion.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				 while (rs.next()) {
					 Pasajero pasajero = new Pasajero();
					 pasajero.setId(rs.getInt(1));
					 pasajero.setNombre(rs.getString(2));
					 pasajero.setEdad(rs.getInt(3));
					 pasajero.setPeso(rs.getInt(4));
					 
					ListaPax.add(pasajero);
					 
				 }
			}catch (SQLException e) {
				System.out.println("Error al listar los pasajeros");
				e.printStackTrace();
			}finally {
				cerrarConexion();
			}
			
			return ListaPax;
		
	}
	

	
	
	

}
