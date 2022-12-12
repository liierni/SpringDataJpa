package com.edix.primeval.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.primeval.modelo.dao.EmpleadoDao;
import com.edix.primeval.modelo.entitybeans.Empleado;

@Controller
public class HomeController {
	
	@Autowired
	private EmpleadoDao edao; 
	
	@GetMapping("/inicio")
	public String login () {
		return "Inicio";
	}
	
	@PostMapping("/inicio")
	public String formLogin (Model model, RedirectAttributes rattr, HttpSession sesion, @RequestParam("correo") String correo) {
		
		Empleado empleado = edao.findByCorreo(correo);
		
		if (edao.comprobarLogin(empleado.getCorreo(), empleado.getPassword()) == 1) {
			sesion.setAttribute("usuarioLogeado", empleado);
			model.addAttribute("mensaje", "Usuario logeado");
			
			return "panel";
		}
			rattr.addFlashAttribute("mensaje", "Usuario NOOOOOOO logeado");
			return "redirect:/inicio";
	}
	
	@GetMapping("/cerrarSesion")
	public String procCerrarSesion(HttpSession sesion) {
		sesion.setAttribute("usuarioLogeado", null);
		// System.out.println(sesion.getAttribute("usuarioLogeado"));
		return "forward:/inicio";
	}
}
