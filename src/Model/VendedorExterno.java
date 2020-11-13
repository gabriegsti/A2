package Model;

public class VendedorExterno extends Vendedor {
	private double ajudaCusto;
	private ClienteExterno cliente;

	// methods
	public String toString() {
		return getID() + ":" + getNome() + ":" + getTelefone() + ":" + getDataDeNascimento() + ":" + getSalario() + ":"
				+ getComissao() + ":" + getAjudaCusto() + ":" + getCliente();

	}

	public double calcularPagamento() {
		double resultado = getSalario() + getAjudaCusto() + (getSalario() * getComissao());
		return resultado;
	}

	// getters and setters
	public ClienteExterno getCliente() {
		return cliente;
	}

	public void setCliente(ClienteExterno cliente) {
		this.cliente = cliente;
	}

	public double getAjudaCusto() {
		return ajudaCusto;
	}

	public void setAjudaCusto(double ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}

}