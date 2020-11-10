package Model;

public class VendedorExterno extends Vendedor {
	private double ajudaCusto;
	private int idDosCliente;

	
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

	public int getIdDosCliente() {
		return idDosCliente;
	}

	public void setIdDosCliente(int idDosCliente) {
		this.idDosCliente = idDosCliente;
	}
}