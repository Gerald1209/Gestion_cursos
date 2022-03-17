package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Oferta;
import entidades.Oferta_Detalle;

public class Dt_Oferta_Det {
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsOFerta_Det(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.oferta_detalle;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Oferta_Detalle> listaOD_id(int id){
		ArrayList<Oferta_Detalle> listFac = new ArrayList<Oferta_Detalle>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_oferta_det WHERE id_oferta = "+ id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Oferta_Detalle ofd = new Oferta_Detalle(); //instanciamos a rol
				ofd.setId_oferta(rs.getInt("id_oferta"));
				ofd.setFecha_inicial(rs.getDate("fecha_inicial"));
				ofd.setFecha_final(rs.getDate("fecha_final"));
				ofd.setHora_inicio(rs.getString("hora_inicio"));
				ofd.setHora_final(rs.getString("hora_final"));
				ofd.setDias(rs.getString("dias"));
				ofd.setPublico(rs.getInt("publico"));
				ofd.setId_oferta(rs.getInt("id_oferta"));
				ofd.setId_capacitacion(rs.getInt("id_capacitacion"));
				ofd.setId_facilitador(rs.getInt("id_facilitador"));
				ofd.setCapacitacion(rs.getString("nombre"));
				ofd.setFacilitador(rs.getString("nombre_completo"));
				listFac.add(ofd);
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
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listFac;
	}
	
	public boolean addOferta(Oferta_Detalle fc){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOFerta_Det(c);
			this.rsOferta.moveToInsertRow();
			
			rsOferta.updateDate("fecha_inicial", fc.getFecha_inicial());
			rsOferta.updateDate("fecha_final", fc.getFecha_final());
			rsOferta.updateString("hora_inicio", fc.getHora_inicio());
			rsOferta.updateString("hora_final", fc.getHora_final());
			rsOferta.updateString("dias", fc.getDias());
			rsOferta.updateInt("publico", fc.getPublico());
			rsOferta.updateInt("id_oferta", fc.getId_oferta());
			rsOferta.updateInt("id_capacitacion", fc.getId_capacitacion());
			rsOferta.updateInt("id_facilitador", fc.getId_facilitador());
			
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
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	public ArrayList<Oferta_Detalle> listaODActivos(){
		ArrayList<Oferta_Detalle> listFac = new ArrayList<Oferta_Detalle>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_oferta_det;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Oferta_Detalle fac = new Oferta_Detalle(); //instanciamos a rol
				fac.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				fac.setId_oferta(rs.getInt("id_oferta"));
				fac.setFecha_inicial(rs.getDate("fecha_inicial"));
				fac.setFecha_final(rs.getDate("fecha_final"));
				fac.setHora_inicio(rs.getString("hora_inicio"));
				fac.setHora_final(rs.getString("hora_final"));
				fac.setDias(rs.getString("dias"));
				fac.setPublico(rs.getInt("publico"));
				fac.setId_oferta(rs.getInt("id_oferta"));
				fac.setId_capacitacion(rs.getInt("id_capacitacion"));
				fac.setId_facilitador(rs.getInt("id_facilitador"));
				fac.setCapacitacion(rs.getString("nombre"));
				fac.setFacilitador(rs.getString("nombre_completo"));
				listFac.add(fac);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR OD: "+ e.getMessage());
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
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listFac;
	}
}
