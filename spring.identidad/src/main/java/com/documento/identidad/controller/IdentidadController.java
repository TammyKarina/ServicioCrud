/**
 * 
 */
package com.documento.identidad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.documento.identidad.model.Identificacion;
import com.documento.identidad.repository.IdentificacionRepository;

/**
 * @author tvelez
 *
 */
@CrossOrigin(origins = "http://localhost:9044")
@RestController
@RequestMapping("/identidad")
public class IdentidadController {

	@Autowired
	private IdentificacionRepository repo;

	@PostMapping("/guardar")
	public ResponseEntity<Identificacion> guardarIdentidad(@RequestBody Identificacion identificacion) {
		try {
			Identificacion _identificacion = repo.save(new Identificacion(identificacion.getFechaEmision(),
					identificacion.getFechaExpiracion(), identificacion.getNumero(), identificacion.getTipoDocumento()));
			return new ResponseEntity<>(_identificacion, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<Optional<Identificacion>> consultarIdentidad(@PathVariable("id") String id) {
		try {
			Optional<Identificacion> identificacion = repo.findById(id);
			return new ResponseEntity<>(identificacion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultarTodo")
	public ResponseEntity<List<Identificacion>> consultarTodo() {
		try {
			List<Identificacion> identificaciones = repo.findAll();
			return new ResponseEntity<>(identificaciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Identificacion> actualizarIdentidad(@PathVariable("id") String id,
			@RequestBody Identificacion identificacion) {
		try {
			Optional<Identificacion> identificacionData = repo.findById(id);
			if (identificacionData != null) {
				Identificacion _identificacion = identificacionData.get();
				_identificacion.setNumero(identificacion.getNumero());
				_identificacion.setFechaEmision(identificacion.getFechaEmision());
				_identificacion.setFechaExpiracion(identificacion.getFechaExpiracion());
				_identificacion.setNumero(identificacion.getNumero());
				_identificacion.setTipoDocumento(identificacion.getTipoDocumento());
				return new ResponseEntity<>(repo.save(_identificacion), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<HttpStatus> eliminarIdentidad(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
