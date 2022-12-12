package com.edix.primeval.modelo.dao;

import java.util.List;

import com.edix.primeval.modelo.entitybeans.Empleado;

public interface EmpleadoDao {

	List<Empleado> findAll();

	Empleado findById(int idEmpl);

	int comprobarLogin(String correo, String password);

	int altaEmpleado(Empleado empleado);
	
	int modificarEmpleado(Empleado empleado);

	int bajaEmpleado(Empleado empleado);
	
	List<Empleado> findEmplByDepar(int idDepar);
	
	public Empleado findByCorreo(String correo);

}
