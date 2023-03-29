package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;
import br.com.senac.repository.EstudanteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {
	
//	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	@Autowired
	private EstudanteRepository repository;
	
	public ResponseEntity<Estudante> buscaEstudantePorId(Long id){
		
		if (repository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		List<Estudante> lst = repository.findAll();
		
		if (lst != null) {
			return ResponseEntity.status(HttpStatus.OK).body(lst);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
		
		if(repository.existsById(id)) {
			repository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(estudante);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}
	
	public ResponseEntity<String> removerUsuario(long id){
		
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Removido com louvor");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tá perdidão");
	}
	
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		repository.save(estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	public Page<Estudante> buscarEstudantePaginacao(PageRequest page){
		return repository.findAll(page);
	}
}
