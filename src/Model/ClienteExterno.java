package Model;

import java.time.LocalDate;

public class ClienteExterno extends Pessoa {

	public ClienteExterno() {
		
	}
	public ClienteExterno(int id, String nome, String telefone, LocalDate dataDeNascimento ) {
		setID(id);
		setNome(nome);
		setTelefone(telefone);
		setDataDeNascimento(dataDeNascimento);
	}
	public String toString() {
		return getID() + ":" + getNome() + ":" + getTelefone() + ":" + getDataDeNascimento() ; 
	}
}
