package br.com.teste.teste.sucurity;

import javax.xml.bind.DatatypeConverter;

import br.com.teste.teste.model.Usuario;

public class Autenticator {

	private static final String PREFIXO = "*GeNeRaTiOn|";

	public static String criptografando(Usuario usuario) {
		// a variavel "str" recebe o conteudo de "PREFIXO" mais o JSON de "Usuario"
		String str = PREFIXO + usuario.toString();
		// esta linha transforma o valor concatenado acima em bites e logo depois em
		// hexadecimal
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		// e retorna a variavel com o dado criptografado
		return token;
	}

	// este metodo descriptografa
	public static boolean isValid(String token) {

		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String novaString = new String(vetor);
		if (novaString.startsWith(PREFIXO)) {
			return true;
		} else {
			return false;
		}
	}

}
