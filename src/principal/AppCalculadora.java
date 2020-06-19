package principal;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppCalculadora extends Application{
	
	Stage calculadora;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		calculadora = primaryStage;
				
		Parent teste = new Calculadora();
		
		Scene main = new Scene(teste, 350, 420);
		
		String caminhoCSS = getClass().getResource("/calculadora.css").toExternalForm();
		
		main.getStylesheets().add(caminhoCSS);
		
		main.getStylesheets()
		.add("https://fonts.googleapis.com/css2?family=Cormorant+Garamond:ital,wght@1,300&display=swap");
		
		calculadora.setTitle("Calculadora");
		calculadora.setResizable(false);
		calculadora.setScene(main);
		calculadora.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
