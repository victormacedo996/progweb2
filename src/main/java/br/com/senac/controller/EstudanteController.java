package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.com.senac.domain.Estudante;
import br.com.senac.service.EstudanteService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import br.com.senac.commons.ExampleValues;

@RestController()
@RequestMapping("estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> getEstudantePorId(@PathVariable("id") @Schema(example = ExampleValues.idEstudante) Long id) {
		return estudanteService.buscaEstudantePorId(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		return estudanteService.buscarTodosEstudantes();
	}
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(content= @Content(examples = {
					@ExampleObject(name="Exemplo de Paciente",value = ExampleValues.exeploEstudante)
			}))
			@RequestBody Estudante estudante){
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	@PutMapping
	public ResponseEntity<Estudante> atualizarEstudante(@RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerEstudante(@PathVariable Long id){
		return estudanteService.removerUsuario(id);
	}
}
