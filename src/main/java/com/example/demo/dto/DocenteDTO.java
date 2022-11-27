package com.example.demo.dto;

public class DocenteDTO {

    private String documento;
    private String primerNombre;
    private String primerApellido;
    private String codigo;
    private String email;
    private String clave;
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public DocenteDTO(String documento, String primerNombre, String primerApellido, String codigo, String email,
			String clave) {
		super();
		this.documento = documento;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.codigo = codigo;
		this.email = email;
		this.clave = clave;
	}
	public DocenteDTO(String email) {
		super();
		this.email = email;
	}
	
	public DocenteDTO() {
		super();
	}
	
}
