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

public class VendedorExternoService extends Application {
	private static Stage telaVendedorExternoStage = new Stage();
	File arquivo = null;
	FileWriter recebearquivo = null;
	BufferedWriter escreve = null;
	FileReader recebearquivoleitura = null;
	BufferedReader leDeArquivo = null;
	String registro;
	TreeSet<VendedorExterno> treeSetvendedor = new TreeSet<VendedorExterno>();

	public void abreUmArquivo() {
		try {
			arquivo = new File("arquivo.txt");

			if (arquivo.exists()) {
				recebearquivo = new FileWriter(arquivo, true); // Permite acrescentar dados ao final do arquivo.

			} else {
				recebearquivo = new FileWriter("arquivo.txt");// Se não existir, cria o arquivo.
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
	
	
	
	
	public void gravaTreeSetDeVendedoresExternosEmTexto(TreeSet<VendedorExterno> v) {
		for (VendedorExterno umVendedorExterno : v) {
			gravaVendedorEmTexto(umVendedorExterno);
		}
	}

	//Salvar os dados em memória no arquivo
	public void Salvar() {
		gravaTreeSetDeVendedoresExternosEmTexto(treeSetvendedor);
	}
	
	// Este método recebe os paramateros para cadastrar em memória o Vendedor e o
	// Cliente do Vendedor.
	public void CadastrarVendedorExterno(String nome, String telefone, LocalDate dataDeNascimento, double salario,
			double comissao, double ajudaDeCusto, String clienteNome, String clienteTelefone,
			LocalDate clienteDataDeNascimento) {
		try {
			lerVendedores();
		

		int id = treeSetvendedor.last().getID();

		treeSetvendedor.add(new VendedorExterno(id, nome, telefone, dataDeNascimento, salario, comissao, ajudaDeCusto,
				clienteNome, clienteTelefone, clienteDataDeNascimento));
		} catch (IOException e) {
			System.out.println("Falha ao tentar cadastrar Vendedor Externo" + e.getMessage());
		}
	}

	public void abreUmArquivoLeitura() {
		try {
			arquivo = new File("arquivo.txt");

			if (arquivo.exists()) {
				recebearquivoleitura = new FileReader("arquivo.txt");
				leDeArquivo = new BufferedReader(recebearquivoleitura);
			}
			

		} catch (Exception e) {

			System.out.println(" Erro ao tentar abrir arquivo: " + e.getMessage());
		}
	}

	public void lerVendedores() throws IOException {
		abreUmArquivoLeitura();
		TreeSet<VendedorExterno> treeSetvendedor = new TreeSet<VendedorExterno>();
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
			String[] campos;
			
			while ((registro = leDeArquivo.readLine()) != null) {
				
				campos = registro.split(":");
				id = Integer.parseInt(campos[0].trim());
				nome = campos[1].trim();
				telefone = campos[2].trim();
				dataDeNascimento = LocalDate.parse(campos[3], Pessoa.formatter);
				salario = Double.parseDouble(campos[4].trim());
				comissao = Double.parseDouble(campos[5].trim());
				ajudaDeCusto = Double.parseDouble(campos[6].trim());
				clienteNome = campos[7].trim();
				clienteTelefone = campos[8].trim();
				clienteDataDeNascimento = LocalDate.parse(campos[9], Pessoa.formatter);

				treeSetvendedor.add(new VendedorExterno(id, nome, telefone, dataDeNascimento, salario, comissao,
						ajudaDeCusto, clienteNome, clienteTelefone, clienteDataDeNascimento));
			}
		} catch (FileNotFoundException e) { // tratando quando o arquivo não existe
			System.err.println("Erro: arquivo nao existe. " + arquivo);
		} catch (IOException e) { // tratando quando há erro no readLine()
			System.err.println("Erro: arquivo na leitura do arquivo: " + arquivo);
		}
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
			start(telaVendedorExternoStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecharTela() {
		telaVendedorExternoStage.close();
	}

}
