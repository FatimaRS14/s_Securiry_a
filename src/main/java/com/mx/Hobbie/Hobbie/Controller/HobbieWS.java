package com.mx.Hobbie.Hobbie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Hobbie.Hobbie.Dominio.Hobbie;
import com.mx.Hobbie.Hobbie.Service.HobbieServiceImp;

@RestController
@RequestMapping(path = "/api/hobbie")
@CrossOrigin

public class HobbieWS {

	// http://192.168.0.198:8000/api/hobbie

	@Autowired
	private HobbieServiceImp service;

	@GetMapping(path = "/listar")
	public List<Hobbie> listar() {
		List<Hobbie> hobbies = service.listar();
		return hobbies;
	}

//Guardar----------------------------------------------------------> http://
//hobbie----------------------------------------------------------JSON back(servidor)
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Hobbie hobbie) {
		service.guardar(hobbie);
	}

//Editar-------------------------------------------------------------
	@PutMapping(path = "/editar")
	public void editar(@RequestBody Hobbie hobbie) {
		service.editar(hobbie);
	}

//Eliminar
	@DeleteMapping(path = "/eliminar")
	public void eliminar(@RequestBody Hobbie hobbie) {
		service.eliminar(hobbie);
	}

	// Buscar
	@PostMapping(path = "/buscar")
	public Hobbie buscar(@RequestBody Hobbie hobbie) {
		return service.burcarId(hobbie);
	}

}
