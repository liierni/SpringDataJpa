package com.edix.primeval.modelo.dao;

import java.util.List;

import com.edix.primeval.modelo.entitybeans.Perfile;

public interface PerfilDao {
	
	List<Perfile> findAll();

	Perfile findById(int idPerfil);


	int altaPerfil (Perfile perfil);
	
	int modificarPerfil(Perfile perfil);

	int eliminarPerfil (Perfile perfil);

}
