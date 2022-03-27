package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Facultad;
import datos.Dt_Tipo_Capacitacion;
import entidades.Facultad;
import entidades.Tipo_Capacitacion;

@WebServlet("/Sl_Tipo_Capacitacion")

public class Sl_Tipo_Capacitacion extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Tipo_Capacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Tipo_Capacitacion TipCap = new Tipo_Capacitacion();
		Dt_Tipo_Capacitacion dttc = new Dt_Tipo_Capacitacion();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		TipCap.setTipo_capacitacion(request.getParameter("tipo_capacitacion"));
		 int certif = Integer.parseInt(request.getParameter("certificada"));
		TipCap.setCertificada(certif);
		TipCap.setDescripcion(request.getParameter("descripcion"));
		TipCap.setEstado(1);
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				
				if(dttc.addTipoCapacitacion(TipCap)) {
					response.sendRedirect("production/tbl_TipCapalidad.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_TipCapalidad.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			//codigo
			break;
		default:
			//codigo
			break;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
