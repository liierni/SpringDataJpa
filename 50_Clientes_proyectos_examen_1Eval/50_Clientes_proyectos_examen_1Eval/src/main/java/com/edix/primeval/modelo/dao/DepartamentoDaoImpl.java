package com.edix.primeval.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.primeval.modelo.entitybeans.Departamento;
import com.edix.primeval.repository.DepartamentoRepository;

@Repository
public class DepartamentoDaoImpl implements DepartamentoDao{
	
	@Autowired
	private DepartamentoRepository drepo;


	@Override
	public List<Departamento> findAll() {
		return drepo.findAll();
	}

	@Override
	public Departamento findById(int idDepar) {
		return drepo.findById(idDepar).orElse(null);
	}

	@Override
	public int altaDepto(Departamento departamento) {
		
		if (!drepo.existsById(departamento.getIdDepar())) {
			drepo.save(departamento);
			return 1;
		}
			return 0;
	}

	@Override
	public int modificarDepto(Departamento departamento) {
		
		if (!drepo.existsById(departamento.getIdDepar())) {
			drepo.save(departamento);
			return 1;
		}
			return 0;
	}
	
}
