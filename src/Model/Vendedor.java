package Model;

public abstract class Vendedor extends Pessoa implements Pagavel, Comparable<Vendedor>  {
	private double salario;
	private double comissao;
	private int ID = 0;

	// methods
	public int compareTo(Vendedor v) {

		if (this.getID() > v.getID()) {
			return 1;
		}
		if (this.getID() < v.getID()) {
			return -1;
		}

		return 0;
	}

	// getters and setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getComissao() {
		return comissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

}