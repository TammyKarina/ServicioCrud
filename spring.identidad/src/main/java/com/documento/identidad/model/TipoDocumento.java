/**
 * 
 */
package com.documento.identidad.model;

/**
 * @author tvelez
 *
 */
public class TipoDocumento {

	public TipoDocumento() {
	}
	
	private String codigo;
	private String nombre;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
