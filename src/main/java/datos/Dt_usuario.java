package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entidades.Usuario;



public class Dt_usuario {
	
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsUsuario_Det(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.usuario;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Usuario: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Usuario> listaUs_id(){
		ArrayList<Usuario> listUs = new ArrayList<Usuario>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_usuario_departamento_facultad", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Usuario us = new Usuario(); //instanciamos a usuario
				us.setId_usuario(rs.getInt("id_usuario"));
				us.setId_uca(rs.getString("id_uca"));
				us.setNombre_real(rs.getString("nombre_real"));
				us.setNombre_usuario(rs.getString("nombre_usuario"));
				us.setPwd(rs.getString("pwd"));
				us.setCorreo_institucional(rs.getString("correo_institucional"));
				us.setCorreo_personal(rs.getString("correo_personal"));
				us.setTelefono_contacto(rs.getString("telefono_contacto"));
				
				us.setId_facultad(rs.getInt("id_facultad"));
				us.setNombre_facultad(rs.getString("nombre_facultad"));
				us.setId_departamento(rs.getInt("id_departamento"));
				us.setNombre_departamento(rs.getString("nombre_departamento"));
				us.setId_carrera(rs.getInt("id_carrera"));
				us.setNombre_carrera(rs.getString("nombre_carrera"));
				us.setEstado(rs.getInt("estado"));
				listUs.add(us);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Usuarios: "+ e.getMessage());
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
		return listUs;
	}
	
	public boolean addUsuario(Usuario uso){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsUsuario_Det(c);
			this.rsUsuario.moveToInsertRow();
			
			rsUsuario.updateString("id_uca", uso.getId_uca());
			rsUsuario.updateString("nombre_real", uso.getNombre_real());
			rsUsuario.updateString("nombre_usuario", uso.getNombre_usuario());
			rsUsuario.updateString("pwd", uso.getPwd());
			rsUsuario.updateString("correo_institucional", uso.getCorreo_institucional());
			rsUsuario.updateString("correo_personal", uso.getCorreo_personal());
			rsUsuario.updateInt("sexo", uso.getSexo());
			rsUsuario.updateString("cargo", uso.getCargo());
			rsUsuario.updateString("telefono_contacto", uso.getTelefono_contacto());
			rsUsuario.updateInt("id_facultad",uso.getId_facultad());
			rsUsuario.updateInt("id_departamento", uso.getId_departamento());
			rsUsuario.updateInt("id_carrera", uso.getId_carrera());
			rsUsuario.updateInt("estado",1);
			rsUsuario.insertRow();
			rsUsuario.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Usuario: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsUsuario != null){
					rsUsuario.close();
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
