package br.com.senac.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estudante {
	
	@Getter
	@Setter
	private Long id;
	
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private LocalDate dataNascimento;
	
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
