package com.edix.primeval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.primeval.modelo.entitybeans.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	@Query("SELECT e from Empleado e where e.departamento.idDepar = ?1")
	public List<Empleado> findEmplByDepar(int idDepar);
	
	@Query("SELECT e from Empleado e where e.correo = ?1")
	public Empleado findByCorreo(String correo);
}
