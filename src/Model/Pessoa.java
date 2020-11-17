package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa implements Comparable<Pessoa> {
	
	private int ID;
	private String nome;
	private String telefone;
	private LocalDate dataDeNascimento;
	public static DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/uuuu"); 

	// methods
		public int compareTo(Pessoa p) {
			if (this.getID() > p.getID()) {
				return 1;
			}
			if (this.getID() < p.getID()) {
				return -1;
			}

			return 0;
		}
	//getters e setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}