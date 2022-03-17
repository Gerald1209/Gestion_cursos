package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Capacitacion;
import entidades.Vw_Capacitacion;

public class Dt_capacitacion {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsCarrera = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsCapacitacion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.capacitacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCarrera = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_Capacitacion> listaCapActivos(){
		ArrayList<Vw_Capacitacion> listCar = new ArrayList<Vw_Capacitacion>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_capacitacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_Capacitacion car = new Vw_Capacitacion(); //instanciamos a rol
				car.setId_capacitacion(rs.getInt("id_capacitacion"));
				car.setNombre(rs.getString("nombre"));
				car.setEstado(rs.getInt("estado"));
				car.setModalidad(rs.getString("nombre_modalidad"));
				listCar.add(car);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR carreras: "+ e.getMessage());
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
		return listCar;
	}
	
	public boolean addCapacitacion(Capacitacion ca){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsCapacitacion(c);
			this.rsCarrera.moveToInsertRow();
			rsCarrera.updateString("nombre", ca.getNombre());
			rsCarrera.updateInt("estado", 1);
			rsCarrera.updateInt("id_modalidad", ca.getId_modalidad());
			rsCarrera.insertRow();
			rsCarrera.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR facultad: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsCarrera != null){
					rsCarrera.close();
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
