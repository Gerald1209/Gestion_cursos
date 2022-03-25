package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Facultad;
import entidades.Tipo_Capacitacion;

public class Dt_Tipo_Capacitacion {
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsTipoCapacitacion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenar_rsTipoCapacitacion(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gestio_docente.tipo_capacitacion;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsTipoCapacitacion = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR TIPO DE CAPACITACIÓN "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar tipcapalidades registrados y activos
	public ArrayList<Tipo_Capacitacion> listaTipCapActivos(){
		ArrayList<Tipo_Capacitacion> listTipCap = new ArrayList<Tipo_Capacitacion>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("SELECT * FROM gestio_docente.tipo_capacitacion WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Tipo_Capacitacion tipcap = new Tipo_Capacitacion (); //instanciamos a tipo capacitación
				tipcap.setId_tipo_capacitacion(rs.getInt("id_tipo_capacitacion"));
				tipcap.setTipo_capacitacion(rs.getString("tipo_capacitacion"));
				tipcap.setCertificada(rs.getInt("certificada"));
				tipcap.setDescripcion(rs.getString("descripcion"));
				tipcap.setEstado(rs.getInt("estado"));
				listTipCap.add(tipcap);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR tipcapalidades: "+ e.getMessage());
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
		return listTipCap;
	}
	
	public boolean addTipoCapacitacion(Tipo_Capacitacion tipcap){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenar_rsTipoCapacitacion(c);
			this.rsTipoCapacitacion.moveToInsertRow();
			rsTipoCapacitacion.updateString("tipo_capacitacion", tipcap.getTipo_capacitacion());
			rsTipoCapacitacion.updateInt("certificada", tipcap.getCertificada());
			rsTipoCapacitacion.updateString("descripcion", tipcap.getDescripcion());
			rsTipoCapacitacion.updateInt("estado", 1);
			rsTipoCapacitacion.insertRow();
			rsTipoCapacitacion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR TIPO DE CAPACITACION: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsTipoCapacitacion != null){
					rsTipoCapacitacion.close();
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


