package entidades;

public class Modalidad {
	
	private int id_modalidad;
	private String nombre_modalidad;
	private int certificada;
	private String Descripcion;
	private int estado;
	public int getId_modalidad() {
		return id_modalidad;
	}
	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}
	public String getNombre_modalidad() {
		return nombre_modalidad;
	}
	public void setNombre_modalidad(String nombre_modalidad) {
		this.nombre_modalidad = nombre_modalidad;
	}
	public int getCertificada() {
		return certificada;
	}
	public void setCertificada(int certificada) {
		this.certificada = certificada;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}
