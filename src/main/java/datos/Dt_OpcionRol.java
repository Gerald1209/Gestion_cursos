package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Opcion;
import entidades.Rol;
import entidades.OpcionRol;

public class Dt_OpcionRol {
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOpcionRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsOpcionRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.opcionrol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOpcionRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR OPCION ROL: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//Metodo para visualizar usuarios registrados y activos
		public ArrayList<OpcionRol> listaOpcRolActivos(){
			ArrayList<OpcionRol> listOpcRol = new ArrayList<OpcionRol>();
			try{
				c = poolConexion.getConnection(); //obtenemos una conexion del pool
				ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_opcionrol", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery();
				while(rs.next()){
					OpcionRol or = new OpcionRol(); //instanciamos a opcionrol
					or.setId_opcion_rol(rs.getInt("id_opcion_rol"));
					or.setId_opcion(rs.getInt("id_opcion"));
					or.setNombre_opcion(rs.getString("nombre_opcion"));
					or.setId_rol(rs.getInt("id_rol"));
					or.setNombre_rol(rs.getString("nombre_rol"));
					
					listOpcRol.add(or);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR OPCION ROL: "+ e.getMessage());
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
			return listOpcRol;
		}
		
		
		public boolean addOpcionRol(OpcionRol op){
			boolean guardado = false;
			
			try{
				c = poolConexion.getConnection();
				this.llena_rsOpcionRol(c);
				this.rsOpcionRol.moveToInsertRow();
				
				rsOpcionRol.updateInt("id_opcion", op.getId_opcion());
				rsOpcionRol.updateInt("id_rol", op.getId_rol());
				
				rsOpcionRol.insertRow();
				rsOpcionRol.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR OPCION ROL: "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsOpcionRol != null){
						rsOpcionRol.close();
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
}

