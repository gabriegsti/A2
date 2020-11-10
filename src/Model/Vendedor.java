package Model;

public abstract class Vendedor extends Pessoa implements Pagavel  {
	private double salario;
	private double comissao;

	
	
	//getters and setters
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