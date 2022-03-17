package entidades;

import java.sql.Date;

public class Usuario {
	
	private int id_usuario;
	private String id_uca;
	private String nombre_real;
	private String nombre_usuario;
	private String pwd;
	private String correo_institucional;
	private String correo_personal;
	private int sexo;
	private String cargo;
	
	private String telefono_contacto;
	private int id_facultad;
	private String nombre_facultad;
	private int id_departamento;
	private String nombre_departamento;
	private int id_carrera;
	private String nombre_carrera;
	private int estado;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getId_uca() {
		return id_uca;
	}
	public void setId_uca(String id_uca) {
		this.id_uca = id_uca;
	}
	public String getNombre_real() {
		return nombre_real;
	}
	public void setNombre_real(String nombre_real) {
		this.nombre_real = nombre_real;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	public String getCorreo_personal() {
		return correo_personal;
	}
	public String getCorreo_institucional() {
		return correo_institucional;
	}
	
	public void setCorreo_institucional(String correo_institucional) {
		this.correo_institucional = correo_institucional;
	}
	public void setCorreo_personal(String correo_personal) {
		this.correo_personal = correo_personal;
	}
	public String getTelefono_contacto() {
		return telefono_contacto;
	}
	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}
	public int getId_facultad() {
		return id_facultad;
	}
	public void setId_facultad(int id_facultad) {
		this.id_facultad = id_facultad;
	}
	public String getNombre_facultad() {
		return nombre_facultad;
	}
	public void setNombre_facultad(String nombre_facultad) {
		this.nombre_facultad = nombre_facultad;
	}
	
	
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public String getNombre_departamento() {
		return nombre_departamento;
	}
	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}
	public int getId_carrera() {
		return id_carrera;
	}
	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}
	public String getNombre_carrera() {
		return nombre_carrera;
	}
	public void setNombre_carrera(String nombre_carrera) {
		this.nombre_carrera = nombre_carrera;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	

	
	}


