package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Rpt_Certificadas;

public class Dt_Reportes {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public ArrayList<Rpt_Certificadas> reporteCertificados(Rpt_Certificadas rpt){
		ArrayList<Rpt_Certificadas> listRpt = new ArrayList<Rpt_Certificadas>();
		try{
			c = PoolConexion.getConnection(); //obtenemos una PoolConexion del pool
			ps = c.prepareStatement("Select * from gc_mcgofe.rpt_certf where ("
					+ " ano_inscripcion='"+rpt.getAno_inscripcion()+"' "
					+ "AND sexo="+rpt.getSexo()
					+ " AND (id_facultad="+rpt.getId_facultad() 
					+ " OR id_departamento="+rpt.getId_departamento() 
					+" OR id_carrera="+rpt.getId_carrera()+ ") "
					+ "AND periodo='" + rpt.getPeriodo()
					+ "' AND certificada =1);", 
					
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			System.out.print(ps);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Rpt_Certificadas rpte = new Rpt_Certificadas(); //instanciamos a rol
				rpte.setAno_inscripcion(rs.getString("ano_inscripcion"));
				
				rpte.setNombre_real(rs.getString("nombre_real"));
				rpte.setNombre_facultad(rs.getString("nombre_facultad"));
				rpte.setNombre_departamento(rs.getString("nombre_departamento"));
				rpte.setNombre_carrera(rs.getString("nombre_carrera"));
				rpte.setCapacitacion(rs.getString("capacitacion"));
				rpte.setNombre_modalidad(rs.getString("nombre_modalidad"));
				listRpt.add(rpte);
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
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listRpt;
	}

}
