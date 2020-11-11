package Model;

import java.util.TreeSet;

public class VendedorExterno extends Vendedor {
	private double ajudaCusto;
	private TreeSet<Integer> idsDosCliente = new TreeSet<Integer>();
	
	
	// methods
	public double calcularPagamento() {
		double resultado = getSalario() + getAjudaCusto() + (getSalario() * getComissao());
		return resultado;
	}

	// getters and setters
	public double getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

	public TreeSet<Integer> getIdsDosCliente() {
		return idsDosCliente;
	}

	public void setIdsDosCliente(TreeSet<Integer> idsDosCliente) {
		this.idsDosCliente = idsDosCliente;
	}

	
}