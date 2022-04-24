/**
 * 
 */
package com.documento.identidad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.documento.identidad.model.Identificacion;

/**
 * @author tvelez
 *
 */
public interface IdentificacionRepository extends MongoRepository<Identificacion, String> {
	Identificacion findByNumero(String numero);
	void deleteByNumero(String numero);
}
