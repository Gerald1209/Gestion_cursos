package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Vw_Inscripcion;

public class Dt_Evaluar {

	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsCarrera = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public void llena_rsCapacitacion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.inscripcion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCarrera = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CARRERAS "+ e.getMessage());
			e.printStackTrace();
		}
	}

	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Vw_Inscripcion> listaInscripNul(){
		ArrayList<Vw_Inscripcion> listCar = new ArrayList<Vw_Inscripcion>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_inscripcion where id_escala is null;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_Inscripcion car = new Vw_Inscripcion(); //instanciamos a rol
				car.setId_inscripcion(rs.getInt("id_inscripcion"));
				car.setId_capacitacion(rs.getInt("id_capacitacion"));
				car.setNombre(rs.getString("nombre"));
				car.setNombre_modalidad(rs.getString("nombre_modalidad"));
				car.setDescripcion(rs.getString("descripcion"));
				car.setNombre_carrera(rs.getString("nombre_carrera"));
				car.setNombre_departamento(rs.getString("nombre_departamento"));
				car.setNombre_facultad(rs.getString("nombre_facultad"));
				//car.setSexo(rs.getInt("sexo"));
				car.setNombre_real(rs.getString("nombre_real"));
				listCar.add(car);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR vw_Inscripciones: "+ e.getMessage());
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
		return listCar;
	}
}