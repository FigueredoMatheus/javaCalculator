package componentes;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Display extends HBox{
	
	Label label = new Label("0");
	DisplayOperacoes displayOperacoes = new DisplayOperacoes(); 
	
	private List<String> listOperacoes = Arrays.asList("+", "-","X","/", "=");
	
	String valorAntigo = "";
	String valorAtual = "";
	String operacao = "";
	String textoCompleto = "";
	
	public Display() {
		label.getStyleClass().add("label-display");
		
		getStyleClass().add("display");
		
		getChildren().add(label);
		
	}
	
	public void addTexto(String texto){		
						
		if( ( isOp(texto) || texto.equals("0") ) && (label.getText().equals("0") || 
				texto.equals("=") ) && operacao.equals("") ) {
			return;
			
		}else if(operacao.equals("=") && !isOp(texto)) {
			return;
			
		}else if(texto.equals(",") && valorAtual.equals("")) {
			valorAtual = "0,";
			label.setText(valorAtual);

		}else if(texto.equals(",") && label.getText().contains(",")) {
			return;
			
		}else if(!isOp(texto)) {
			if(valorAtual.equals("0"))
				valorAtual = "";
			
			valorAtual += texto;
			label.setText(valorAtual);
			
		}else {
			tratarOperacao(texto);
		}
								
	}

	private void tratarOperacao(String texto) {
			
		if(!valorAntigo.equals("") && !valorAtual.equals("")) {	
			fazerOperacao();
			
		}
		
		if(valorAntigo.equals("")) {
			valorAntigo = valorAtual;	
			
		}
		
		operacao = texto;
		modificarTextoCompleto();
		valorAtual = "";
		
	}
	
	private void modificarTextoCompleto() {
				
		if( valorAtual.equals("") && operacao.equals("="))
			return;
		
		if(valorAtual.equals("")) {
			textoCompleto = textoCompleto.substring(0, textoCompleto.lastIndexOf(" ") - 1) 
					+ operacao + " ";
		}else {
			textoCompleto += valorAtual + " " + operacao + " ";
		}	
	}
	
	private void fazerOperacao() {
		
		if(valorAtual.equals(""))
			valorAtual = "0";
		
		if(valorAntigo.contains(",")) valorAntigo = valorAntigo.replace(',', '.');		
		if(valorAtual.contains(",")) valorAtual = valorAtual.replace(',', '.');	
		
		double primeiroValor = Double.parseDouble(valorAntigo);
		double segundoValor = Double.parseDouble(valorAtual);
		double resultado = 0.0;
		
		switch(operacao) {
		case "+":
			resultado = primeiroValor + segundoValor;
		break;
		case "-":
			resultado = primeiroValor - segundoValor;
		break;
		case "X":
			resultado = primeiroValor * segundoValor;
		break;
		case "/":
			if(segundoValor == 0) {
				bloquearCalc();
				return;
			}
				
			if( (primeiroValor < segundoValor) || (primeiroValor % segundoValor == 1) )  
 				valorAntigo = valorAntigo + ",0";
				
			resultado = primeiroValor / segundoValor;
			System.out.println("\nREsultado: " + resultado + "\n");
		break;
		}
		
		if(valorAntigo.contains(".") || valorAtual.contains(".")) {
			valorAntigo = new DecimalFormat("0.00").format(resultado); 
			
		}else {
			int v = (int) resultado;
			valorAntigo = Integer.toString(v);
			
		}
		
		label.setText(valorAntigo);
		
	}
	
	
	private void bloquearCalc() {
		label.setText("Operação inválida!");
		
		Thread t = new Thread(() -> {
			while(valorAntigo != "") {
				try {
					Thread.sleep(2000);
					
					//Necessario para excutar a Thread 
					Platform.runLater(() ->{
						limpar();		
					});
					
				} catch (InterruptedException e1) {
					
					
				}
			}
		});
		
		t.setDaemon(true); //Parar a aplicação quando a janela for fechada
		t.start();
		
	}

	public void apagar() {
		
		if(valorAtual.equals(""))
			return;
		
		if(!valorAtual.equals("") && valorAtual.length() != 1) {
			valorAtual = valorAtual.substring(0, valorAtual.length() - 1);
			
		}else {
			valorAtual = "0";
			
		}
		
		label.setText(valorAtual);
	}
	
	public void inverterSinal() {
		
		if(valorAtual.equals("") || valorAtual.equals("0"))
			return;
		
		if(label.getText().contains("-")) {
			valorAtual = label.getText().substring(1);
				
		}else {
			valorAtual = "-" + label.getText();

		}
		
		label.setText(valorAtual);

	}
	
	public void limpar() {
		label.setText("0");
		valorAntigo = "";
		valorAtual = "";
		operacao = "";
		textoCompleto = "";
	}
	
	public String getTextoCompleto() {
		return textoCompleto;
	}
	
	private boolean isOp(String texto) {
		
		return listOperacoes.stream().anyMatch(e -> e.equals(texto));
	}
}