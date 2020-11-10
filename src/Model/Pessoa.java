package Model;

import java.time.LocalDate;

public abstract class Pessoa implements Comparable<Pessoa> {
	
	private int ID;
	private int nome;
	private int telefone;
	private LocalDate dataDeNascimento;
		
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
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}