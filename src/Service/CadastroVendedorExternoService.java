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
	private static Stage cadastroTelaVendedorExternoService = new Stage();
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
				recebearquivo = new FileWriter(arquivo,true); // Permite acrescentar dados ao final do arquivo.

			} else {
				recebearquivo = new FileWriter(arquivo);// Se não existir, cria o arquivo.
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

		try {
			escreve.write(v.toString());
			escreve.newLine();

		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo: " + e.getMessage());
		}
	}

	public void fechaUmArquivoLeitura() {
		try {

			leDeArquivo.close();
			recebearquivoleitura.close();

		} catch (IOException e) {
			System.out.println(" Erro ao tentar fechar o arquivo: " + e.getMessage());

		}

	}

	public void lerVendedores() {
		abreUmArquivo();
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
					System.out.println("Pinta lista: " + treeSetvendedor);
				}
			}
		} catch (FileNotFoundException e) { // tratando quando o arquivo não existe
			System.err.println("Erro: arquivo nao existe. " + arquivo);
		} catch (IOException e) { // tratando quando há erro no readLine()
			System.err.println("Erro na leitura do arquivo: " + arquivo);
		} catch (Exception e) {
			System.out.println("Erro inesperado na leitura do arquivo \n \n  ");
			e.printStackTrace();
		} finally {
			fechaUmArquivoLeitura();
		}
	}

	public void gravaTreeSetDeVendedoresExternosEmTexto() {
		abreUmArquivo();
		for (VendedorExterno umVendedorExterno : this.treeSetvendedorNovos) {
			gravaVendedorEmTexto(umVendedorExterno);
		}
		fechaUmArquivo();
		treeSetvendedor.clear();
		treeSetvendedorNovos.clear();
		lerVendedores();// Atualiza o treesetVendedor que mantém em memória uma lista simulando a lista
						// do arquivo.

	}

	// Salvar os dados em memória no arquivo
	public void Salvar() {
		gravaTreeSetDeVendedoresExternosEmTexto();
	}

	// Este método recebe os paramateros para cadastrar em memória o Vendedor e o
	// Cliente do Vendedor.
	public void CadastrarVendedorExterno(String nome, String telefone, LocalDate dataDeNascimento, double salario,
			double comissao, double ajudaDeCusto, String clienteNome, String clienteTelefone,
			LocalDate clienteDataDeNascimento) {
		lerVendedores();
		System.out.println("Pinta Lista2:"+treeSetvendedor);
		try {
			int id;
			if (treeSetvendedor.isEmpty()) {
				id = 1;
			} else {
//				id = treeSetvendedorNovos.size();
//				id = id + treeSetvendedor.size();
//				id = id + 1;
				id = treeSetvendedorNovos.size() + treeSetvendedor.size() + 1;
			}
			System.out.println("ID: " + id);
			treeSetvendedorNovos.add(new VendedorExterno(id, nome, telefone, dataDeNascimento, salario, comissao,
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Chama o método start para abrir uma nova janela.
	public void abrirTela() {
		try {
			start(cadastroTelaVendedorExternoService);
			lerVendedores();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecharTela() {
		cadastroTelaVendedorExternoService.close();
	}

}
