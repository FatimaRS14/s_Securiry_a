package com.mx.Hobbie.Hobbie.Service;

import java.util.List;

import com.mx.Hobbie.Hobbie.Dominio.Hobbie;

public interface IHobbieService {
	//CRUD
	void guardar(Hobbie hobbie);
	
	List<Hobbie> listar();
	
	void editar(Hobbie hobbie);
	
	void eliminar(Hobbie hobbie);
	
	Hobbie burcarId(Hobbie hobbie);
	
}
