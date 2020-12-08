package Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class ListarVendedorExternoService extends Application {
	public static Stage listarTelaVendedorExternoStage = new Stage();
	TreeSet<VendedorExterno> treeSetvendedor = new TreeSet<VendedorExterno>();
	File arquivo = null;
	FileReader recebearquivoleitura = null;
	BufferedReader leDeArquivo = null;
	String registro = null;

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
		} catch (FileNotFoundException e) { // tratando quando o arquivo não existe
			System.err.println("Erro: arquivo nao existe. " + arquivo);
		} catch (IOException e) { // tratando quando há erro no readLine()
			System.err.println("Erro na leitura do arquivo: " + arquivo);
		} catch (Exception e) {
			System.out.println("Erro inesperado na leitura do arquivo \n \n  ");
			e.printStackTrace();
		}finally {
			fechaUmArquivoLeitura();
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
	public String buscarPorId(int id) {
		lerVendedores();
		if (!treeSetvendedor.isEmpty()) {
			String quebraLinha = System.getProperty("line.separator");// separador de linha do sistema desejado.

			for (VendedorExterno v : treeSetvendedor) {
				if (v.getId() == id) {

					return "Id: " + v.getId() + quebraLinha + "Nome: " + v.getNome() + quebraLinha + "Telefone: "
							+ v.getTelefone() + quebraLinha + "Data de nascimento: "
							+ v.getDataDeNascimento().format(Pessoa.formatter) + quebraLinha + "   Cliente: "
							+ quebraLinha + "   Nome: " + v.getCliente().getNome() + quebraLinha + "   Telefone: "
							+ v.getCliente().getTelefone() + quebraLinha + "   Data de nascimento: "
							+ v.getDataDeNascimento().format(Pessoa.formatter) + quebraLinha;

				}
			}
		}
		return "Nada foi encontrado";
	}

	public String listarTodos() {
		lerVendedores();
		String resultado = new String();
		int i = 0;
		if (!treeSetvendedor.isEmpty()) {
			String quebraLinha = System.getProperty("line.separator");// separador de linha do sistema desejado.

			for (VendedorExterno v : treeSetvendedor) {
			System.out.println(i++);
				resultado += "Id: " + v.getId() + quebraLinha
						+"Nome: " + v.getNome() + quebraLinha 
						+ "Telefone: " + v.getTelefone() + quebraLinha 
						+ "Data de nascimento: " + v.getDataDeNascimento().format(Pessoa.formatter) + quebraLinha 
						+ "   Cliente: " + quebraLinha
						+ "   Nome: " + v.getCliente().getNome() + quebraLinha 
						+ "   Telefone: " + v.getCliente().getTelefone() + quebraLinha 
						+ "   Data de nascimento: "	+ v.getDataDeNascimento().format(Pessoa.formatter) + quebraLinha
						+ "============================================================"
						+ quebraLinha;
			}
			return resultado;
		}
		return resultado;
	}

	

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../View/ListarVendedorExterno.fxml"));

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
			start(listarTelaVendedorExternoStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fecharTela() {
		listarTelaVendedorExternoStage.close();
	}
}
