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

public class AtualizarVendedorExternoService extends Application {
	public static Stage atualizarTelaVendedorExternoStage = new Stage();
	TreeSet<VendedorExterno> treeSetvendedor = new TreeSet<VendedorExterno>();

	File arquivo = null;
	File arquivoOrigem = null;
	FileWriter recebearquivo = null;
	BufferedWriter escreve = null;
	FileReader recebearquivoleitura = null;
	BufferedReader leDeArquivo = null;
	String registro = null;

	public void abreUmArquivo() {
		try {
			arquivo = new File("arquivoTemporario.txt");

			recebearquivo = new FileWriter(arquivo, false);

			escreve = new BufferedWriter(recebearquivo);

		} catch (Exception e) {

			System.out.println(" Erro ao tentar abrir arquivo: " + e.getMessage());
		}
	}

	public void gerenciaArquivos() {
		// Apaga o arquivo original
		File arquivoOriginal = new File("arquivo.txt");
				arquivoOriginal.delete();
		System.out.println("\n Gerencía: \n");
		System.out.println(this.treeSetvendedor);
		
		this.arquivo.renameTo(new File("arquivo.txt"));
			//System.out.println("Não foi possivel finalizar a atualização do arquivo");

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

	public void gravaTreeSetDeVendedoresExternosEmTexto() {
		try {
			abreUmArquivo();
			System.out.println("\n gravar treeset\n ");
			System.out.println(this.treeSetvendedor);
			for (VendedorExterno umVendedorExterno : this.treeSetvendedor) {
				gravaVendedorEmTexto(umVendedorExterno);
			}

			fechaUmArquivo();
			gerenciaArquivos();
			lerVendedores();// Atualiza o treesetVendedor que mantém em memória uma lista simulando a lista

		} catch (Exception e) {
			System.out.println("Erro ao gravar Vendedores em texto" + e.getMessage());
		}
	}

	// Salvar os dados em memória no arquivo
	public void Salvar() {
		System.out.println("Salvar");
		gravaTreeSetDeVendedoresExternosEmTexto();
		lerVendedores();// Atualiza o treesetVendedor que mantém em memória uma lista simulando a lista

	}

	// Este método recebe os paramateros para atualizar em memória o Vendedor e o
	// Cliente do Vendedor.
	public void cadastrarVendedorExterno(int id, String nome, String telefone, String dataDeNascimento, String salario,
			String comissao, String ajudaDeCusto, String clienteNome, String clienteTelefone,
			String clienteDataDeNascimento) {

		try {
			if (!treeSetvendedor.isEmpty()) {
				VendedorExterno vendedorAux = new VendedorExterno();
				VendedorExterno v2 = new VendedorExterno();
				for (VendedorExterno v : treeSetvendedor) {

					if (v.getId() == id) {
						v2 = new VendedorExterno(id, nome, telefone,
								LocalDate.parse(dataDeNascimento, Pessoa.formatter), Double.parseDouble(salario.trim()),
								Double.parseDouble(comissao.trim()), Double.parseDouble(ajudaDeCusto.trim()),
								clienteNome, clienteTelefone,
								LocalDate.parse(clienteDataDeNascimento, Pessoa.formatter));
						System.out.println(v.toString());
						vendedorAux = v;
						break;
					}
				}
				System.out.println(this.treeSetvendedor);
				this.treeSetvendedor.remove(vendedorAux);
				this.treeSetvendedor.add(v2);
				System.out.println(this.treeSetvendedor);
				System.out.println("\n fim \n");

			}

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

	public void fechaUmArquivoLeitura() {
		try {

			leDeArquivo.close();
			recebearquivoleitura.close();

		} catch (IOException e) {
			System.out.println(" Erro ao tentar fechar o arquivo: " + e.getMessage());

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
			abreUmArquivoLeitura();

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

	public String buscarPorId(int id) {
		lerVendedores();
		if (!treeSetvendedor.isEmpty()) {
			for (VendedorExterno v : treeSetvendedor) {
				if (v.getId() == id) {

					return v.toString();

				}
			}
		}
		return "Nada foi encontrado";
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../View/AtualizarVendedorExterno.fxml"));

			Scene scene = new Scene(root, 660, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
			lerVendedores();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Chama o método start para abrir uma nova janela.
	public void abrirTela() {
		try {
			start(atualizarTelaVendedorExternoStage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecharTela() {
		atualizarTelaVendedorExternoStage.close();
	}

}
