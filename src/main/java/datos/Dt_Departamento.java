package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Departamento;

public class Dt_Departamento {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsDepartamento = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsDepartamento(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.Departamento;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsDepartamento = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Departamentos registrados y activos
	public ArrayList<Departamento> listaDepActivos(){
		ArrayList<Departamento> listDep = new ArrayList<Departamento>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.vw_departamento;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Departamento Dep = new Departamento (); //instanciamos a Departamento
				Dep.setId_departamento(rs.getInt("id_departamento"));
				Dep.setNombre_departamento(rs.getString("nombre_departamento"));
				Dep.setId_facultad(rs.getInt("id_facultad"));
				Dep.setNombre_facultad(rs.getString("nombre_facultad"));
				Dep.setEstado(rs.getInt("estado"));
				

				listDep.add(Dep);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Departamentos: "+ e.getMessage());
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
		return listDep;
	}
	
	public boolean addDepartamento(Departamento Dep){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenar_rsDepartamento(c);
			this.rsDepartamento.moveToInsertRow();
			rsDepartamento.updateString("nombre_departamento", Dep.getNombre_departamento());
			rsDepartamento.updateInt("id_facultad", Dep.getId_facultad());
			rsDepartamento.updateInt("estado", Dep.getEstado());
			
			rsDepartamento.insertRow();
			rsDepartamento.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Departamento: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsDepartamento != null){
					rsDepartamento.close();
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


