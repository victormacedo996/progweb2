package br.com.senac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;

@Service
public class EstudanteService {
	
	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	public ResponseEntity<Estudante> buscaEstudantePorId(Long id){
		Estudante estudante = listaEstudantes.get(id);
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		List<Estudante> estudantes = new ArrayList<>(listaEstudantes.values());
		
		if (estudantes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(estudantes);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		listaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
		Estudante result = listaEstudantes.replace(id, estudante);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<String> removerUsuario(long id){
		Estudante result = listaEstudantes.get(id);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		listaEstudantes.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("Removido com louvor!");
	}
}
