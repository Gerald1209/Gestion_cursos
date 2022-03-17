package entidades;

import java.sql.Date;

public class Oferta_Detalle {
	private int id_oferta_detalle; 
	private Date fecha_inicial; 
	private Date fecha_final; 
	private String hora_inicio; 
	private String hora_final;
	private String dias; 
	private int publico; 
	private int id_oferta; 
	private int id_capacitacion;
	private String capacitacion;
	private int id_facilitador;
	private String facilitador;
	
	public int getId_oferta_detalle() {
		return id_oferta_detalle;
	}
	public void setId_oferta_detalle(int id_oferta_detalle) {
		this.id_oferta_detalle = id_oferta_detalle;
	}
	public Date getFecha_inicial() {
		return fecha_inicial;
	}
	public void setFecha_inicial(Date fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_final() {
		return hora_final;
	}
	public void setHora_final(String hora_final) {
		this.hora_final = hora_final;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public int getPublico() {
		return publico;
	}
	public void setPublico(int publico) {
		this.publico = publico;
	}
	public int getId_oferta() {
		return id_oferta;
	}
	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}
	public int getId_capacitacion() {
		return id_capacitacion;
	}
	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}
	public int getId_facilitador() {
		return id_facilitador;
	}
	public void setId_facilitador(int id_facilitador) {
		this.id_facilitador = id_facilitador;
	}
	public String getCapacitacion() {
		return capacitacion;
	}
	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}
	public String getFacilitador() {
		return facilitador;
	}
	public void setFacilitador(String facilitador) {
		this.facilitador = facilitador;
	}
	
	
}
