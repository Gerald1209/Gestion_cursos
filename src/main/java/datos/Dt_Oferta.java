package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Oferta;

public class Dt_Oferta {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsFacultad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.oferta WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Oferta> listaOfActivos(){
		ArrayList<Oferta> listFac = new ArrayList<Oferta>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.oferta WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Oferta of = new Oferta(); //instanciamos a rol
				of.setId_oferta(rs.getInt("id_oferta"));
				of.setNombre(rs.getString("nombre"));
				of.setDescripcion(rs.getString("descripcion"));
				of.setPeriodo(rs.getString("periodo"));
				of.setFecha_inicial(rs.getDate("fecha_inicial"));
				of.setFecha_final(rs.getDate("fecha_final"));
				of.setEstado(rs.getInt("estado"));
				listFac.add(of);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listFac;
	}
	
	public Oferta getoferta(int id){
		Oferta of = new Oferta(); //instanciamos a rol
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT *  from gc_mcgofe.oferta where id_oferta = "+id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			
			of.setId_oferta(rs.getInt("id_oferta"));
			of.setNombre(rs.getString("nombre"));
			of.setDescripcion(rs.getString("descripcion"));
			of.setPeriodo(rs.getString("periodo"));
			of.setFecha_inicial(rs.getDate("fecha_inicial"));
			of.setFecha_final(rs.getDate("fecha_final"));
			of.setEstado(rs.getInt("estado"));
			
			
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return of;
	}
	
	public int getid_oferta(){
		int x = 0;
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT id_oferta from gc_mcgofe.oferta where estado != 3 Order by id_oferta DESC Limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			x = rs.getInt("id_oferta");
			
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return x;
	}

	
	public boolean addOferta(Oferta fc){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llena_rsFacultad(c);
			this.rsOferta.moveToInsertRow();
			rsOferta.updateString("nombre", fc.getNombre());
			rsOferta.updateInt("estado", 1);
			rsOferta.updateDate("fecha_inicial", fc.getFecha_inicial());
			rsOferta.updateDate("fecha_final", fc.getFecha_final());
			rsOferta.updateString("periodo", fc.getPeriodo());
			rsOferta.updateString("descripcion", fc.getDescripcion());
			rsOferta.insertRow();
			rsOferta.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsOferta != null){
					rsOferta.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
}
