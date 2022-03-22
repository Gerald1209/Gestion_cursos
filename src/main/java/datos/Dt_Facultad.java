package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Facultad;

public class Dt_Facultad {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsFacultad = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsFacultad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.facultad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsFacultad = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Facultad> listaFacActivos(){
		ArrayList<Facultad> listFac = new ArrayList<Facultad>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.facultad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Facultad fac = new Facultad(); //instanciamos a rol
				fac.setId_facultad(rs.getInt("id_facultad"));
				fac.setNombre_facultad(rs.getString("nombre_facultad"));
				fac.setEstado(rs.getInt("estado"));
				listFac.add(fac);
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
	
	public boolean addFacultad(Facultad fc){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llena_rsFacultad(c);
			this.rsFacultad.moveToInsertRow();
			rsFacultad.updateString("nombre_facultad", fc.getNombre_facultad());
			rsFacultad.updateInt("estado", 1);
			rsFacultad.insertRow();
			rsFacultad.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR facultad: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsFacultad != null){
					rsFacultad.close();
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
