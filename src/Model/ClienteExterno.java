package Model;

import java.time.LocalDate;

public class ClienteExterno extends Pessoa {

	public ClienteExterno() {
		
	}
	public ClienteExterno( String nome, String telefone, LocalDate dataDeNascimento ) {
		setNome(nome);
		setTelefone(telefone);
		setDataDeNascimento(dataDeNascimento);
	}
	public String toString() {
		return getNome() + ":" + getTelefone() + ":" + getDataDeNascimento().format(Pessoa.formatter) ; 
	}
}
