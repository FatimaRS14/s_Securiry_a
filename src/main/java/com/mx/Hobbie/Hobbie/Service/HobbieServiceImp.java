package com.mx.Hobbie.Hobbie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Hobbie.Hobbie.DAO.IHobbieDAO;
import com.mx.Hobbie.Hobbie.Dominio.Hobbie;
@Service
public class HobbieServiceImp implements IHobbieService {
	
	@Autowired //Inyecta dependencias, metodo,instancia, etc
	private IHobbieDAO dao;
	
	
	@Override
	public void guardar(Hobbie hobbie) {
		// TODO Auto-generated method stub
		dao.save(hobbie);
	}

	@Override
	public List<Hobbie> listar() {
		// TODO Auto-generated method stub
		return (List<Hobbie>) dao.findAll();
	}

	@Override
	public void editar(Hobbie hobbie) {
		dao.save(hobbie);
		
	}

	@Override
	public void eliminar(Hobbie hobbie) {
		dao.delete(hobbie);
		
	}

	@Override
	public Hobbie burcarId(Hobbie hobbie) {
		return dao.findById(hobbie.getIdHobbie()).orElse(null);
	}

}
