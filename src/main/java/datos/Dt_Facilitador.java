package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Facilitador;

public class Dt_Facilitador {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsFacilitador = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsFacilitador(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.facilitador;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsFacilitador = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Facilitadores registrados y activos
	public ArrayList<Facilitador> listaFaciActivos(){
		ArrayList<Facilitador> listFaci = new ArrayList<Facilitador>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.Facilitador;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Facilitador Faci = new Facilitador (); //instanciamos a Facilitador
				Faci.setId_facilitador(rs.getInt("id_facilitador"));
				Faci.setEmail(rs.getString("email"));
				Faci.setGrado_academico(rs.getString("grado_academico"));
				Faci.setId_uca(rs.getString("id_uca"));
				Faci.setNombre_completo(rs.getString("nombre_completo"));
				Faci.setTelefono_contacto(rs.getString("telefono_contacto"));

				listFaci.add(Faci);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facilitadores: "+ e.getMessage());
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
		return listFaci;
	}
	
	public boolean addFacilitador(Facilitador Faci){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenar_rsFacilitador(c);
			this.rsFacilitador.moveToInsertRow();
			rsFacilitador.updateString("email", Faci.getEmail());
			rsFacilitador.updateString("grado_academico", Faci.getGrado_academico());
			rsFacilitador.updateString("id_uca", Faci.getId_uca());
			rsFacilitador.updateString("nombre_completo", Faci.getNombre_completo());
			rsFacilitador.updateString("telefono_contacto", Faci.getTelefono_contacto());
			
			rsFacilitador.insertRow();
			rsFacilitador.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Facilitador: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsFacilitador != null){
					rsFacilitador.close();
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


