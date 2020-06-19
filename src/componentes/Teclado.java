package componentes;

import java.util.function.Consumer;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Teclado extends GridPane implements Consumer<String>{
	
	//private List<Consumer<String>> funcoes = new ArrayList<>();
	private Consumer<String> teste;
	
	Botao botaoC = new Botao("C", this,"botaoAC");
	Botao botaoApagarUltimo = new Botao("apagar", this,"botao");
	Botao botaoIgual= new Botao("=", this,"botao");
	Botao botaoVirgula = new Botao(",", this,"botao");
	Botao botaoInverter = new Botao("+/-", this,"botao");
	Botao botaoSoma = new Botao("+", this,"botao");
	Botao botaoSubtrair = new Botao("-", this,"botao");
	Botao botaoMultiplicar = new Botao("X", this,"botao");
	Botao botaoDividir = new Botao("/", this,"botao");
	
	Botao botao0 = new Botao("0", this,"botao");
	Botao botao1 = new Botao("1", this,"botao");
	Botao botao2 = new Botao("2", this,"botao");
	Botao botao3 = new Botao("3", this,"botao");
	Botao botao4 = new Botao("4", this,"botao");
	Botao botao5 = new Botao("5", this,"botao");
	Botao botao6 = new Botao("6", this,"botao");
	Botao botao7 = new Botao("7", this,"botao");
	Botao botao8 = new Botao("8", this,"botao");
	Botao botao9 = new Botao("9", this,"botao");
	
	public Teclado(){
				
		setGridLinesVisible(true);
				
		getColumnConstraints().addAll(coluna(), coluna(), coluna(), coluna());
		getRowConstraints().addAll(linha(), linha(), linha(), linha(), linha());
		
		getStyleClass().add("teclado");
		
		
		add(botao0, 1, 4);
		add(botao1, 0, 3);
		add(botao2, 1, 3);		
		add(botao3, 2, 3);
		add(botao4, 0, 2);
		add(botao5, 1, 2);
		add(botao6, 2, 2);
		add(botao7, 0, 1);
		add(botao8, 1, 1);
		add(botao9, 2, 1);
		
		add(botaoC, 0, 0, 2, 1);
		add(botaoApagarUltimo, 2, 0);
		add(botaoIgual, 3, 4);
		add(botaoVirgula, 2, 4);
		add(botaoDividir, 3, 0);
		add(botaoInverter, 0, 4);
		add(botaoSoma, 3, 3);
		add(botaoSubtrair, 3, 2);
		add(botaoMultiplicar, 3, 1);
		
	}
	
	
	private ColumnConstraints coluna() {
		ColumnConstraints coluna = new ColumnConstraints();
		
			coluna.setPercentWidth(25);
			coluna.setFillWidth(true);
		
		return coluna;
	}
	
	private RowConstraints linha() {
		RowConstraints linha = new RowConstraints();
			linha.setPercentHeight(25);
			linha.setFillHeight(true);
		return linha;
	}

	public void noCliqueChame(Consumer<String> funcao) {
		//funcoes.add(funcao);
		teste = funcao;
		
	}
	
	@Override
	public void accept(String t) {
		//funcoes.forEach(fn -> fn.accept(t));
		teste.accept(t);
	}
	
	

}
