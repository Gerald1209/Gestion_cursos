package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Opcion;


public class Dt_opcion {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOpcion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsOpcion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.opciones WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOpcion = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR OpcionS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Opcion> listaopActivos(){
		ArrayList<Opcion> listop = new ArrayList<Opcion>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.opciones WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Opcion car = new Opcion(); //instanciamos a rol
				car.setId_opcion(rs.getInt("id_opcion"));
				car.setNombre_opcion(rs.getString("nombre_opcion"));
				car.setEstado(rs.getInt("estado"));
				car.setDescripcion(rs.getString("descripcion"));
				listop.add(car);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Opcion: "+ e.getMessage());
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
		return listop;
	}
	
	public boolean addOpcion(Opcion tur){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsOpcion(c);
			this.rsOpcion.moveToInsertRow();
			rsOpcion.updateString("nombre_opcion", tur.getNombre_opcion());
			rsOpcion.updateString("descripcion", tur.getDescripcion());
			rsOpcion.updateInt("estado", 1);
			rsOpcion.insertRow();
			rsOpcion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Opcion "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsOpcion != null){
					rsOpcion.close();
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
