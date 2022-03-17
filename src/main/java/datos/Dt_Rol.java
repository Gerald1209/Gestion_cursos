package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Rol;

public class Dt_Rol {
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.rol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Rols registrados y activos
	public ArrayList<Rol> listaRolActivos(){
		ArrayList<Rol> listRol = new ArrayList<Rol>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.Rol;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Rol Rol = new Rol (); //instanciamos a Rol
				Rol.setId_rol(rs.getInt("id_rol"));
				Rol.setNombre_rol(rs.getString("nombre_Rol"));
				Rol.setEstado(rs.getInt("estado"));
				Rol.setDescripcion(rs.getString("descripcion"));
				

				listRol.add(Rol);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Rols: "+ e.getMessage());
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
		return listRol;
	}
	
	public boolean addRol(Rol Rol){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llenar_rsRol(c);
			this.rsRol.moveToInsertRow();
			rsRol.updateString("nombre_Rol", Rol.getNombre_rol());
			rsRol.updateInt("estado", Rol.getEstado());
			rsRol.updateString("descripcion", Rol.getDescripcion());

			
			rsRol.insertRow();
			rsRol.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Rol: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsRol != null){
					rsRol.close();
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

