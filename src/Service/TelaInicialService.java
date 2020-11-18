package Service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaInicialService extends Application {
	private static Stage telaInicialStage = new Stage(); //Referencia da janela
	
	
	public void abrirTela() {
		start(telaInicialStage);
	}
	
	
	@Override
	public void start(Stage telaInicialStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("../View/TelaInicial.fxml"));
		
			Scene scene = new Scene(root, 660,400);
			telaInicialStage.setScene(scene);
			telaInicialStage.setTitle("Tela Inicial");
			telaInicialStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void fecharTela() {
		telaInicialStage.close();
	}
	


	

	
	
}
