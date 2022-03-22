package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.EscalaCalificacion;

public class Dt_EscalaCalificacion {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsEscalaCal = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	//Metodo para llenar el RusultSet //para insert, update and delete
		public void llena_rsEscalaCalificacion(Connection c){
			try{
				ps = c.prepareStatement("SELECT * FROM gc_mcgofe.escalacalificacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsEscalaCal = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA CALIFICACIONES "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		//Metodo para visualizar usuarios registrados y activos
		public ArrayList<EscalaCalificacion> listaEscActivos(){
			ArrayList<EscalaCalificacion> listEsc = new ArrayList<EscalaCalificacion>();
			try{
				c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
				ps = c.prepareStatement("SELECT * FROM gc_mcgofe.escalacalificacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					EscalaCalificacion esc = new EscalaCalificacion(); //instanciamos a escalacalificacion
					esc.setId_escala(rs.getInt("id_escala"));
					esc.setCalificacion(rs.getString("calificacion"));
					esc.setDescripcion(rs.getString("descripcion"));
					esc.setEstado(rs.getInt("estado"));
					listEsc.add(esc);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR ESCALA CALIFICACIONES: "+ e.getMessage());
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
			return listEsc;
		}
				
		public boolean addEscalaCalificacion(EscalaCalificacion ec){
			boolean guardado = false;
			
			try{
				c = PoolConexion.getConnection();
				this.llena_rsEscalaCalificacion(c);
				this.rsEscalaCal.moveToInsertRow();
				rsEscalaCal.updateString("calificacion", ec.getCalificacion());
				rsEscalaCal.updateString("descripcion", ec.getDescripcion());
				rsEscalaCal.updateInt("estado", 1);
			
				rsEscalaCal.insertRow();
				rsEscalaCal.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR ESCALA CALIFICACIONES: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsEscalaCal != null){
						rsEscalaCal.close();
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