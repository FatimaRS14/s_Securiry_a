package com.mx.Hobbie.Hobbie.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.Hobbie.Hobbie.Dominio.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, String> {
	
	//Optional<Usuario> findByUsernameIgnoreCase(String username);
	
	@Query("SELECT u FROM Usuario u WHERE UPPER(u.username) = UPPER(:username)")
	Optional<Usuario> findByUsername(@Param("username") String username);


}
