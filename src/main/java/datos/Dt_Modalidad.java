package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Facultad;
import entidades.Modalidad;

public class Dt_Modalidad {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsModalidad = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsModalidad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.modalidad;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsModalidad = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar modalidades registrados y activos
	public ArrayList<Modalidad> listaModActivos(){
		ArrayList<Modalidad> listMod = new ArrayList<Modalidad>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.modalidad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Modalidad mod = new Modalidad (); //instanciamos a modalidad
				mod.setId_modalidad(rs.getInt("id_modalidad"));
				mod.setNombre_modalidad(rs.getString("nombre_modalidad"));
				mod.setCertificada(rs.getInt("certificada"));
				mod.setDescripcion(rs.getString("descripcion"));
				mod.setEstado(rs.getInt("estado"));
				listMod.add(mod);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Modalidades: "+ e.getMessage());
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
		return listMod;
	}
	
	public boolean addModalidad(Modalidad Mod){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenar_rsModalidad(c);
			this.rsModalidad.moveToInsertRow();
			rsModalidad.updateString("nombre_modalidad", Mod.getNombre_modalidad());
			rsModalidad.updateInt("certificada", Mod.getCertificada());
			rsModalidad.updateString("descripcion", Mod.getDescripcion());
			rsModalidad.updateInt("estado", 1);
			rsModalidad.insertRow();
			rsModalidad.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Modalidad: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsModalidad != null){
					rsModalidad.close();
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


