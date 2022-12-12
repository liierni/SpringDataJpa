package com.edix.primeval.modelo.dao;

import java.util.List;

import com.edix.primeval.modelo.entitybeans.Departamento;

public interface DepartamentoDao {
	
	List<Departamento> findAll();
	Departamento findById(int idDepar);
	int altaDepto (Departamento departamento);
	int modificarDepto (Departamento departamento);

}
