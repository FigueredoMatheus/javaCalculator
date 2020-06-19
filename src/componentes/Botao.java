package componentes;

import java.util.function.Consumer;

import javafx.scene.control.Button;

public class Botao extends Button{

	public Botao(String texto, Consumer<String> func ,String... CSS) {
		setText(texto);
				
		for(String css: CSS) {
			getStyleClass().add(css);
		}
				
		setOnAction(e -> {
			func.accept(getText());
		});
	}
	
}
