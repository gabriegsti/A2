package Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Model.VendedorLoja;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VendedorLojaService extends Application {
	private static Stage telaVendedorLojaStage = new Stage();
	File arquivo = null;
	FileWriter recebearquivo = null;
	BufferedWriter escreve = null;

	public void abreUmArquivo() {
		try {
			arquivo = new File("arquivo.txt");

			if (arquivo.exists()) {
				recebearquivo = new FileWriter(arquivo, true); // Permite acrescentar dados ao final do arquivo.

			} else {
				recebearquivo = new FileWriter("arquivo.txt");// Se n�o existir, cria o arquivo.
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

	public void gravaTextoNoArquivo(VendedorLoja v) {
		abreUmArquivo();

		String registro = v.getID() + ":" + v.getNome() + ":" + v.getTelefone() + ":" + v.getDataDeNascimento() + ":"
				+ v.getComissao() + ":" + v.getHoraExtra();
		try {
			escreve.write(registro);
			escreve.newLine();

		} catch (IOException e) {
			System.out.println(" Erro ao tentar escrever no arquivo: " + e.getMessage());
		} finally {
			fechaUmArquivo();
		}
	}

	// Abre a janela corrente
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../View/CadastroVendedorLoja.fxml"));

			Scene scene = new Scene(root, 660, 400);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Chama o m�todo start para abrir uma nova janela.
	public void CadastroVendedorLoja() {
		try {
			start(telaVendedorLojaStage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		telaVendedorLojaStage.close();
	}

	// getters and setters
	public Stage getTelaVendedorLojaStage() {
		return telaVendedorLojaStage;
	}

}
