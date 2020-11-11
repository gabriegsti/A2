package App;
	
import Service.TelaInicialService;
import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	TelaInicialService tela = new TelaInicialService();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			tela.iniciar();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
