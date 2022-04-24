/**
 * 
 */
package com.documento.identidad.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tvelez
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Identidad")

public class Identificacion {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String numero;	
	private Date fechaEmision;
	private String fechaExpiracion;	
	private TipoDocumento tipoDocumento;

	public Identificacion(Date fechaEmision, String fechaExpiracion, String numero, TipoDocumento tipoDocumento) {
		super();
		this.fechaEmision = fechaEmision;
		this.fechaExpiracion = fechaExpiracion;
		this.numero = numero;
		this.tipoDocumento = tipoDocumento;
		this.id = numero;
	}

	/**
	 * @return the fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the fechaExpiracion
	 */
	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	/**
	 * @param fechaExpiracion the fechaExpiracion to set
	 */
	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
