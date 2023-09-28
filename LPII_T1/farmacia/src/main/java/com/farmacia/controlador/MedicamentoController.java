package com.farmacia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farmacia.modelo.Medicamento;
import com.farmacia.repositorio.MedicamentoRepositorio;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {

	@Autowired
	private MedicamentoRepositorio medicamentoRepositorio; // Inyeccion de dependencias

	@GetMapping("/")
	public String listarMedicamentos(Model model) {
		List<Medicamento> medicamentos = medicamentoRepositorio.findAll();
		model.addAttribute("medicamentos", medicamentos);
		return "listarmedicamentos"; // nombre de la vista
	}
	
	@GetMapping("/nuevo")
	public String nuevoMedicamento(Model model) {
		model.addAttribute("medicamento", new Medicamento());
		return "nuevo"; // nombre de la vista
	}
	
	@PostMapping("/guardar")
	public String guardarmedicamento(@ModelAttribute Medicamento medicamento) {
		medicamentoRepositorio.save(medicamento);
		return "redirect:/medicamentos/"; // redirecciona para ver la lista
	}
	
	@GetMapping("/editar/{id}")
	public String editarMedicamento(@PathVariable Integer id, Model model) {
		Medicamento medicamento = medicamentoRepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de medicamento no válido"));
		model.addAttribute("medicamento", medicamento);
		return "editamedicamento"; // Vista de edición
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMedicamento(@PathVariable Integer id) {
		medicamentoRepositorio.deleteById(id);
		return "redirect:/medicamentos/";
	}
}
