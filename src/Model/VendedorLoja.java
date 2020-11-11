package Model;

public class VendedorLoja extends Vendedor {
	private double horaExtra;

	// methods
	public double calcularPagamento() {
		double resultado = getSalario() + (getSalario() * getComissao());
		return resultado;
	}

	// getters and setters
	public double getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(double horaExtra) {
		this.horaExtra = horaExtra;
	}

}
