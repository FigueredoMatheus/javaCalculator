package componentes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DisplayOperacoes extends HBox{
	
	private Label label = new Label("");
	
	public DisplayOperacoes() {
		getStyleClass().add("displayOperacoes");
		
		label.getStyleClass().add("labelOperacoes");
		
		getChildren().add(label);
		
		
	}
	
	public void setTextoLabel(String texto) {
		label.setText(texto);
	}

}
