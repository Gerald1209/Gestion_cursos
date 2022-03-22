package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Vw_userrol;
import entidades.UserRol;

public class Dt_userrol {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsUserRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodo para llenar el RusultSet //para insert, update and delete
	public void llena_rsUserRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.usuariorol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUserRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR tbl_userrol "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
		//Metodo para visualizar usuarios registrados y activos
		public ArrayList<Vw_userrol> listarUserRol(){
		ArrayList<Vw_userrol> listUserRol = new ArrayList<Vw_userrol>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_userrol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_userrol vwur = new Vw_userrol(); //instanciamos a Vw_userrol
				vwur.setId_user(rs.getInt("id_usuario"));
				vwur.setUser(rs.getString("nombre_real"));
				vwur.setRol(rs.getString("nombre_rol"));
				vwur.setId_rol(rs.getInt("id_rol"));
				listUserRol.add(vwur);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR vwuserrol "+ e.getMessage());
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
		return listUserRol;
	}
		
		
		//Metodo para asignar un rol a un usuario
		public boolean asignaRol(UserRol tur){
			boolean guardado = false;
			
			try{
				c = PoolConexion.getConnection();
				this.llena_rsUserRol(c);
				this.rsUserRol.moveToInsertRow();
				rsUserRol.updateInt("id_usuario", tur.getId_user());
				rsUserRol.updateInt("id_rol", tur.getId_rol());
				rsUserRol.insertRow();
				rsUserRol.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR tbl_userrol "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsUserRol != null){
						rsUserRol.close();
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
