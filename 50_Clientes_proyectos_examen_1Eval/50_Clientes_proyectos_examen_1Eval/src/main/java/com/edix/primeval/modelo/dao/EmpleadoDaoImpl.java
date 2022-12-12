package com.edix.primeval.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edix.primeval.modelo.entitybeans.Empleado;
import com.edix.primeval.repository.EmpleadoRepository;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao{
	
	@Autowired
	private EmpleadoRepository erepo;

	@Override
	public List<Empleado> findAll() {
		return erepo.findAll();
	}

	@Override
	public Empleado findById(int idEmpl) {
		return erepo.findById(idEmpl).orElse(null);
	}

	@Override
	public int comprobarLogin(String correo, String password) {
        for (Empleado ele : erepo.findAll()) {
            if ((ele.getCorreo().equals(correo)) && (ele.getPassword().equals(password))) {
                    return 1;
                }
            }		return 0;
	}


	@Override
	public int altaEmpleado(Empleado empleado) {
		try {
			erepo.save(empleado);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int bajaEmpleado(Empleado empleado) {
		try {
			erepo.delete(empleado);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	@Override
	public int modificarEmpleado(Empleado empleado) {
		try {
			erepo.save(empleado);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Empleado> findEmplByDepar(int idDepar) {
		return erepo.findEmplByDepar(idDepar);
	}

	@Override
	public Empleado findByCorreo(String correo) {
		return erepo.findByCorreo(correo);
	}
}
