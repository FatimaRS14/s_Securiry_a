package com.mx.Hobbie.Hobbie.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Hobbie.Hobbie.Dominio.Hobbie;
@Repository
public interface IHobbieDAO extends CrudRepository<Hobbie, Integer>{
	
}
