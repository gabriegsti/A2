package Service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VendedorLojaService extends Application {
	private static Stage telaVendedorLojaStage = new Stage();

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
