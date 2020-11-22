package Model;

import java.time.LocalDate;

public class VendedorExterno extends Vendedor {
	
	private double ajudaCusto;
	private ClienteExterno cliente;

	public VendedorExterno() {

	}

	public VendedorExterno(int id, String nome, String telefone, LocalDate dataDeNascimento, double salario,
			double comissao, double ajudaCusto, String clienteNome, String clienteTelefone, LocalDate clienteDataDeNascimento) {
		setId(id);
		setNome(nome);
		setTelefone(telefone);
		setDataDeNascimento(dataDeNascimento);
		setSalario(salario);
		setComissao(comissao);
		setAjudaCusto(ajudaCusto);
		ClienteExterno cliente = new ClienteExterno(clienteNome, clienteTelefone, clienteDataDeNascimento);
		setCliente(cliente);

	}

	// methods
	public String toString() {
		return  getId() + ":" + getNome() + ":" + getTelefone() + ":" + getDataDeNascimento().format(Pessoa.formatter) + ":" + getSalario() + ":"
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