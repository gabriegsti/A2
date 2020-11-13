package Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

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
			System.out.println(" Erro ao tentar escrever no arquivo: " + e.getMessage());
		} finally {
			fechaUmArquivo();
		}
	}

	public void gravaTreeSetDeVendedoresExternosEmTexto(TreeSet<VendedorExterno> v) {
		for (VendedorExterno umVendedorExterno : v) {
			gravaVendedorEmTexto(umVendedorExterno);
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
	public void TelaCadastroVendedorExterno() {
		try {
			start(telaVendedorExternoStage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		telaVendedorExternoStage.close();
	}

	// getters and setters
	public Stage getTelaVendedorExternoStage() {
		return telaVendedorExternoStage;
	}

}
