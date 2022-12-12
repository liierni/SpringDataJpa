package com.edix.primeval.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.primeval.modelo.dao.DepartamentoDao;
import com.edix.primeval.modelo.dao.EmpleadoDao;
import com.edix.primeval.modelo.dao.PerfilDao;
import com.edix.primeval.modelo.entitybeans.Departamento;
import com.edix.primeval.modelo.entitybeans.Empleado;
import com.edix.primeval.modelo.entitybeans.Perfile;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoDao edao;
	
	@Autowired
	private PerfilDao pdao;
	
	@Autowired DepartamentoDao ddao;


	@GetMapping("")
	public String panel () {
		return "panel";
	}
	
	
	@GetMapping("/lista")
	public String procListaEmpl (Model model, Empleado empleado) {
		
		List<Empleado> listaEmpleados = edao.findAll();
		model.addAttribute("listaEmpleados", listaEmpleados);
	
		return "ListaEmpleados";
	}
	
	@GetMapping("/editar/{id}")
	public String procEditarEmpl (Model model, Empleado empleado, @PathVariable("id") int idEmpl) {
		
		List<Perfile> listaPerfiles = pdao.findAll();
		model.addAttribute("listaPerfiles", listaPerfiles);
		
		List<Departamento> listaDepartamentos = ddao.findAll();
		model.addAttribute("listaDepartamentos", listaDepartamentos);
		
		return "Editar";
	}
	
	@PostMapping("/editar/{id}")
	public String procEditar (Model model, RedirectAttributes rattr, @PathVariable("id") int idEmpl, Empleado empleado) {
		empleado.setFechaIngreso(new Date());
		if (edao.modificarEmpleado(empleado) == 1) {
			rattr.addFlashAttribute("mensajeEditar", "Empleado editado correctamente");
			return "redirect:/empleado";
		} else
			rattr.addFlashAttribute("mensajeEditar", "Empleado NOOOO editado.");
			return "redirect:/empleado/lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpl (Empleado empleado, Model model, @PathVariable("id") int idEmpl) {
		
		if (edao.bajaEmpleado(empleado) == 1) {
		model.addAttribute("mensajeBaja", "Usuario dado de baja");
		return "forward:/empleado/lista";
		} else 
			model.addAttribute("mensajeBaja", "Usuario NOOOO dado de baja");
		return "forward:/empleado";
	}
	
	@GetMapping("/alta")
	public String procAltaEmpl (Model model) {
		
		List<Perfile> listaPerfiles = pdao.findAll();
		model.addAttribute("listaPerfiles", listaPerfiles);
		
		List<Departamento> listaDepartamentos = ddao.findAll();
		model.addAttribute("listaDepartamentos", listaDepartamentos);
		
		return "FormAltaEmpl";
	}
	
	@PostMapping("/alta")
	public String procAltaEmplForm (Model model, Empleado empleado, RedirectAttributes rattr) {
		if (edao.altaEmpleado(empleado) == 1) {
			rattr.addFlashAttribute("mensajeAlta", "Alta de empleado realizada.");
			return "redirect:/empleado";
		} else
			model.addAttribute("mensajeAlta", "Alta de empleado NO realizada.");
			return "forward:/empleado/alta";
	}
	
	@GetMapping("/{id}")
	public String verEmpleado (Empleado empleado, Model model, @PathVariable("id") int idEmpl, HttpSession sesion) {
		
		Empleado empl =(Empleado) sesion.getAttribute("usuarioLogeado");
		model.addAttribute("usuarioLogeado", empl);
		model.addAttribute("empleado", edao.findById(empl.getIdEmpl()));
		return "panel";
	}
	
	@InitBinder // Con este método se soluciona el parseo del formato de la fecha.
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

}
