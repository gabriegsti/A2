package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.TreeSet;

import Model.Pessoa;
import Model.VendedorExterno;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroVendedorExternoService extends Application {
	private static Stage telaVendedorExternoStage = new Stage();
	File arquivo = null;
	FileWriter recebearquivo = null;
	BufferedWriter escreve = null;
	FileReader recebearquivoleitura = null;
	BufferedReader leDeArquivo = null;
	String registro = null;
	TreeSet<VendedorExterno> treeSetvendedor = new TreeSet<VendedorExterno>();
	TreeSet<VendedorExterno> treeSetvendedorNovos = new TreeSet<VendedorExterno>();

	public void abreUmArquivo() {
		try {
			arquivo = new File("arquivo.txt");

			if (arquivo.exists()) {
				recebearquivo = new FileWriter(arquivo, true); // Permite acrescentar dados ao final do arquivo.

			} else {
				recebearquivo = new FileWriter(arquivo);// Se n�o existir, cria o arquivo.
			}

			escreve = new BufferedWriter(recebearquivo);

		} catch (Exception e) {

			System.out.println(" Erro ao tentar abrir arquivo: " + e.getMessage());
		}
	}

	public void fechaUmArquivo() {
		try {
			escreve.close();
			recebearquivo.close();
		} catch (IOException e) {
			System.out.println(" Erro ao tentar fechar o arquivo: " + e.getMessage());

		}

	}

	public void gravaVendedorEmTexto(VendedorExterno v) {
		abreUmArquivo();

		try {
			escreve.write(v.toString());
			escreve.newLine();

		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo: " + e.getMessage());
		} finally {
			fechaUmArquivo();
		}
	}

	public void lerVendedores() {

		int id;
		String nome;
		String telefone;
		LocalDate dataDeNascimento;
		double salario;
		double comissao;
		double ajudaDeCusto;
		String clienteNome;
		String clienteTelefone;
		LocalDate clienteDataDeNascimento;

		try {
			if (abreUmArquivoLeitura()) {

				while ((registro = leDeArquivo.readLine()) != null) {
					String[] campos = new String[11];
					campos = registro.split(":");

					id = Integer.parseInt(campos[0].trim());
					nome = campos[1].trim();
					telefone = campos[2].trim();

					dataDeNascimento = LocalDate.parse(campos[3].trim(), Pessoa.formatter);
					salario = Double.parseDouble(campos[4].trim());
					comissao = Double.parseDouble(campos[5].trim());
					ajudaDeCusto = Double.parseDouble(campos[6].trim());
					clienteNome = campos[7].trim();
					clienteTelefone = campos[8].trim();
					clienteDataDeNascimento = LocalDate.parse(campos[9].trim(), Pessoa.formatter);

					treeSetvendedor.add(new VendedorExterno(id, nome, telefone, dataDeNascimento, salario, comissao,
							ajudaDeCusto, clienteNome, clienteTelefone, clienteDataDeNascimento));
				}
			}
		} catch (FileNotFoundException e) { // tratando quando o arquivo n�o existe
			System.err.println("Erro: arquivo nao existe. " + arquivo);
		} catch (IOException e) { // tratando quando h� erro no readLine()
			System.err.println("Erro na leitura do arquivo: " + arquivo);
		} catch (Exception e) {
			System.out.println("Erro inesperado na leitura do arquivo \n \n  ");
			e.printStackTrace();
		}
	}

	public void gravaTreeSetDeVendedoresExternosEmTexto() {

		for (VendedorExterno umVendedorExterno : this.treeSetvendedorNovos) {
			gravaVendedorEmTexto(umVendedorExterno);
		}
		lerVendedores();// Atualiza o treesetVendedor que mant�m em mem�ria uma lista simulando a lista
						// do arquivo.
		treeSetvendedorNovos.clear();// Limpa os dados desse treeset.
	}

	// Salvar os dados em mem�ria no arquivo
	public void Salvar() {
		gravaTreeSetDeVendedoresExternosEmTexto();
	}

	// Este m�todo recebe os paramateros para cadastrar em mem�ria o Vendedor e o
	// Cliente do Vendedor.
	public void CadastrarVendedorExterno(String nome, String telefone, LocalDate dataDeNascimento, double salario,
			double comissao, double ajudaDeCusto, String clienteNome, String clienteTelefone,
			LocalDate clienteDataDeNascimento) {

		try {
			int id;
			if (this.treeSetvendedor.isEmpty()) {
				id = 1;
			} else {
				if (this.treeSetvendedorNovos.isEmpty()) {
					id = this.treeSetvendedor.last().getId() + 1;
				} else {
					id = this.treeSetvendedorNovos.last().getId() + 1;
				}
			}

			this.treeSetvendedorNovos.add(new VendedorExterno(id, nome, telefone, dataDeNascimento, salario, comissao,
					ajudaDeCusto, clienteNome, clienteTelefone, clienteDataDeNascimento));

		} catch (Exception e) {
			System.out.println("Falha ao tentar cadastrar Vendedor Externo" + e.getMessage());
		}
	}

	public boolean abreUmArquivoLeitura() {
		try {
			arquivo = new File("arquivo.txt");

			if (arquivo.exists()) {
				recebearquivoleitura = new FileReader(arquivo);// fluxo de conexao
				leDeArquivo = new BufferedReader(recebearquivoleitura);
				return true;
			}

		} catch (Exception e) {
			System.out.println(" Erro ao tentar abrir arquivo: " + e.getMessage());
		}
		return false;
	}

	

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../View/CadastroVendedorExterno.fxml"));

			Scene scene = new Scene(root, 660, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
			lerVendedores();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Chama o m�todo start para abrir uma nova janela.
	public void abrirTela() {
		try {
			start(telaVendedorExternoStage);
			abreUmArquivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecharTela() {
		telaVendedorExternoStage.close();
	}

}