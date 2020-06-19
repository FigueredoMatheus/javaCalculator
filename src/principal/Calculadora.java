package principal;

import componentes.Display;
import componentes.DisplayOperacoes;
import componentes.Teclado;
import javafx.scene.layout.VBox;

public class Calculadora extends VBox {
	Display display = new Display();
	Teclado teclado = new Teclado();
	DisplayOperacoes displayOperacoes = new DisplayOperacoes(); 

	
	public Calculadora() {
		
		getChildren().add(displayOperacoes);
		getChildren().add(display);
		getChildren().add(teclado);
		
		teclado.noCliqueChame(texto -> {
			if(texto.equals("C")) {
				display.limpar();
			}else if(texto.equals("apagar")) {
				display.apagar();
			}else if(texto.equals("+/-")){
				display.inverterSinal();
			}else {
				display.addTexto(texto);
			}
			
			if(!texto.equals("apagar") && !texto.equals("+/-"))
				displayOperacoes.setTextoLabel(display.getTextoCompleto());
		});		
		
	}
}
