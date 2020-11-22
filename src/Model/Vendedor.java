package Model;

public abstract class Vendedor extends Pessoa implements Pagavel, Comparable<Vendedor>  {
	private double salario;
	private double comissao;
	private int id = 0;

	// methods
	public int compareTo(Vendedor v) {

		if (this.getId() > v.getId()) {
			return 1;
		}
		if (this.getId() < v.getId()) {
			return -1;
		}

		return 0;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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