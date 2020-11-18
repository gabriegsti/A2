package App;
	
import Controller.TelaInicialController;
import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TelaInicialController tela = new TelaInicialController();
			tela.abrirTelaInicial();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
