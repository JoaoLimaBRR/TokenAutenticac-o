package br.com.teste.teste.controller;

//esta classe ira controlar a listagem de aluno
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.teste.model.Aluno;
import br.com.teste.teste.sucurity.Autenticator;

@RestController
public class AlunoController {

	// este metodo lista todos os alunos na tela simulando uma interação com banco
	// de dados
	@GetMapping("/aluno/todos")
	// no cabeçalho do metodo e chamada a response entity para respostas http
	// e criado uma lista do tipo aluno
	// e que espera por parametro um token do tipo String
	public ResponseEntity<ArrayList<Aluno>> getAllAluno(@RequestParam String token) {
		if (Autenticator.isValid(token)) {
			// criando uma array list do tipo aluno

			ArrayList<Aluno> lista = new ArrayList<Aluno>();
			// este for serve para popular o objeto aluno "setando" suas variaveis
			for (int i = 0; i < 20; i++) {
				Aluno a = new Aluno();
				a.setRa(i);
				a.setNome("Aluno" + i);
				a.setEmail("Aluno" + i + "@gmail.com");
				a.setCurso("DEV JAVA");
				a.setTelefone("645" + i + i + "488");
				lista.add(a);
			}
			return ResponseEntity.ok(lista);
		} else

		{
			return ResponseEntity.status(403).build();
		}
	}
}
