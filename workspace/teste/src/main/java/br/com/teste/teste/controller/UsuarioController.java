package br.com.teste.teste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.teste.model.Usuario;
import br.com.teste.teste.sucurity.Autenticator;
import br.com.teste.teste.sucurity.Token;
@RestController 
@CrossOrigin //este "@CrossOrigin" deixa com que servidores externos possam se conectar
public class UsuarioController {

	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
		if(usuario.getEmail().equals("joao@gmail.com") && usuario.getSenha().equals("123456")) {
			usuario.setId(1);
			usuario.setNome("Joao Vitor");
		
			//contruindo o token de segurança
			//o metodo "CRIPTOGRAFANDO" ira receber o usuario, usar o seu JSON c
			//Concatenar com uma variavel pre-definida e transformala para Bytes e depois
			//para Hexadecimal
			String tk = Autenticator.criptografando(usuario);
			Token token = new Token();
			//como iremos usar o metodo pots para login temos que colocar o dado criptografado
			//em um objeto, entao a objeto "Token" recebe o valor criptografado 
			token.setStrToken(tk);
			//e o metodo termina retornando o Token
			return ResponseEntity.ok(token);
		}else {
			return 	ResponseEntity.status(403).build();
		}
	}
	
}
