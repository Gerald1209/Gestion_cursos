package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;



import entidades.Inscripcion;
import entidades.Vw_Inscripcion;

public class Dt_inscripcion {

	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsInscripcion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsInscripcion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.inscripcion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsInscripcion = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR InscripcionS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Inscripcion> listaInActivos(){
		ArrayList<Inscripcion> listIn = new ArrayList<Inscripcion>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.inscripcion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Inscripcion car = new Inscripcion(); //instanciamos a rol
				car.setId_inscripcion(rs.getInt("id_inscripcion"));
				car.setAno_inscripcion(rs.getString("ano_inscripcion"));
				car.setEstado(rs.getInt("estado"));
				car.setId_carrera(rs.getInt("id_carrera"));
				car.setId_departamento(rs.getInt("id_departamento"));
				car.setId_facultad(rs.getInt("id_facultad"));
				car.setId_escala(rs.getInt("id_escala"));
				car.setId_usuario(rs.getInt("id_usuario"));
				car.setId_oferta_detalle(rs.getInt("id_oferta_detalle"));
				listIn.add(car);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Inscripcions: "+ e.getMessage());
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
		return listIn;
	}
	public ArrayList<Vw_Inscripcion> listaInActivos2(){
		ArrayList<Vw_Inscripcion> listIn2 = new ArrayList<Vw_Inscripcion>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_inscripcion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Vw_Inscripcion car = new Vw_Inscripcion();
				car.setId_inscripcion(rs.getInt("id_inscripcion"));
				car.setAno_inscripcion(rs.getString("ano_inscripcion"));			
				car.setId_carrera(rs.getInt("id_carrera"));
				car.setNombre_carrera(rs.getString("nombre_carrera"));
				car.setId_departamento(rs.getInt("id_departamento"));
				car.setNombre_departamento(rs.getString("nombre_departamento"));
				car.setId_facultad(rs.getInt("id_facultad"));
				car.setNombre_facultad(rs.getString("nombre_facultad"));
				car.setId_escala(rs.getInt("id_escala"));
				car.setDescripcion(rs.getString("descripcion"));
				car.setId_usuario(rs.getInt("id_usuario"));
				car.setNombre_real(rs.getString("nombre_real"));
				car.setSexo(rs.getString("sexo"));
				car.setId_capacitacion(rs.getInt("id_capacitacion"));
				car.setNombre(rs.getString("nombre"));
				car.setId_modalidad(rs.getInt("id_modalidad"));
				car.setNombre_modalidad(rs.getString("nombre_modalidad"));
				car.setId_oferta(rs.getInt("id_oferta"));
				car.setNombre_oferta(rs.getString("nombre_oferta"));
				car.setId_facilitador(rs.getInt("id_facilitador"));
				car.setNombre_completo(rs.getString("nombre_completo"));
				listIn2.add(car);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Inscripciones: "+ e.getMessage());
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
		return listIn2;
	}
	
	public boolean addInscripcion(Inscripcion ca){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsInscripcion(c);
			this.rsInscripcion.moveToInsertRow();
			rsInscripcion.updateInt("id_inscripcion", ca.getId_inscripcion());
			rsInscripcion.updateString("ano_inscripcion", ca.getAno_inscripcion());
			rsInscripcion.updateInt("estado", 1);
			rsInscripcion.updateInt("id_carrera", ca.getId_carrera());
			rsInscripcion.updateInt("id_departamento", ca.getId_departamento());
			rsInscripcion.updateInt("id_facultad", ca.getId_facultad());
			rsInscripcion.updateInt("id_usuario", ca.getId_usuario());

			rsInscripcion.updateInt("id_oferta_detalle", ca.getId_oferta_detalle());
			rsInscripcion.insertRow();
			rsInscripcion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR I: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsInscripcion != null){
					rsInscripcion.close();
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
