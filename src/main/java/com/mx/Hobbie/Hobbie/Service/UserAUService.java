package com.mx.Hobbie.Hobbie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.Hobbie.Hobbie.DAO.IUsuarioDao;
import com.mx.Hobbie.Hobbie.Dominio.Usuario;

@Service
public class UserAUService implements UserDetailsService {
	
	@Autowired
	private IUsuarioDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    System.out.println("Buscando usuario: " + username);

	    Usuario usuario = dao.findByUsername(username)
	        .orElseThrow(() -> {
	            System.out.println("Usuario no encontrado: " + username);
	            return new UsernameNotFoundException("Usuario no encontrado: " + username);
	        });

	    System.out.println("Usuario encontrado: " + usuario.getUsername() + ", rol: " + usuario.getRol());

	    return User.builder()
	            .username(usuario.getUsername())
	            .password(usuario.getPassword())
	            .roles(usuario.getRol()) 
	            .build();
	}

	}


