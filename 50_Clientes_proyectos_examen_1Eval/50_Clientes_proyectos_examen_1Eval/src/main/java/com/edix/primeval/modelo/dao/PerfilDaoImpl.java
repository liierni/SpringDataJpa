package com.edix.primeval.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.primeval.modelo.entitybeans.Perfile;
import com.edix.primeval.repository.PerfilRepository;

@Repository
public class PerfilDaoImpl implements PerfilDao{
	
	@Autowired
	private PerfilRepository prepo;

	@Override
	public List<Perfile> findAll() {
		return prepo.findAll();
	}

	@Override
	public Perfile findById(int idPerfil) {
		return prepo.findById(idPerfil).orElse(null);

	}

	@Override
	public int altaPerfil(Perfile perfil) {
		if (!prepo.existsById(perfil.getIdPerfil())) {
			prepo.save(perfil);
		return 1;
		}
		return 0;
	}

	@Override
	public int modificarPerfil(Perfile perfil) {
		if (!prepo.existsById(perfil.getIdPerfil())) {
			prepo.save(perfil);
		return 1;
		}
		return 0;
	}

	@Override
	public int eliminarPerfil(Perfile perfil) {
		if (!prepo.existsById(perfil.getIdPerfil())) {
			prepo.delete(perfil);
		return 1;
		}
		return 0;
	}
}
