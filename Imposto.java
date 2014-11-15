// Imposto.java
// Programa para calculo de imposto

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;


public abstract class Imposto extends JFrame implements ActionListener
{
	JLabel dependenteLabel, rendaLabel, slmLabel, resultadoLabel;
	JTextField dependentesText, rendaText, slmText, resultadoText;
	JButton calcula;
	
	public Imposto () {
		
		setTitle("Calculo de Imposto");
		Container c = getContentPane();
		c.setLayout(new FlowLayout ());
		
		dependenteLabel = new JLabel("Número de dependentes: ");
		c.add(dependenteLabel);
		dependentesText = new JTextField(10);
		c.add(dependentesText);
		
		rendaLabel = new JLabel("Renda Mensal: ");
		c.add(rendaLabel);
		rendaText = new JTextField(10);
		c.add(rendaText);
		
		slmLabel = new JLabel("Valor do Salário Minimo: ");
		c.add(slmLabel);
		slmText = new JTextField(10);
		c.add(slmText);
		
		resultadoLabel = new JLabel("Imposto a pagar: ");
		c.add(rendaLabel);
		resultadoText = new JTextField(10);
		resultadoText.setEditable(false);
		c.add(resultadoText);
		
		calcula = new JButton("Calcular");
		calcula.addActionListener(this);
		c.add(calcula);
		
		setSize(210,280);
		
	}
	
	public void actionPerformed (ActiveEvent e){
		
		calcular();
	}
	
	public void calcular () {
		
		double renda, slm, calculo, desconto, imposto, imp_pagar, dependentes;
		String saida;
		imp_pagar = 0;
		
		dependentes = Double.parseDouble(dependentesText.getText());
		renda = Double.parseDouble(rendaText.getText());
		slm = Double.parseDouble(slmText.getText());
		calculo = renda / slm;
		desconto = (dependentes*5);
		
		if (calculo > 0 && calculo <= 2) {
			
			imposto = 0;
			imp_pagar = 0;
			
		}
		
		if (calculo > 2 && calculo <= 3) {
			
			imposto = (renda * 10)/100;
			imp_pagar = imposto-((imposto * desconto)/100);
			
		}
		
		if (calculo > 3 && calculo <= 5) {
			
			imposto = (renda * 15)/100;
			imp_pagar = imposto-((imposto * desconto)/100);
			
		}
		
		if (calculo > 5 && calculo <= 7) {
			
			imposto = (renda * 20)/100;
			imp_pagar = imposto-((imposto * desconto)/100);
			
		}
		
		if (calculo > 7) {
			
			imposto = (renda * 25)/100;
			imp_pagar = imposto-((imposto * desconto)/100);
			
		}
		
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		saida = twoDigits.format(imp_pagar);
		resultadoText.setText(saida);
		
	}
	

	public static void main(String[] args) {
		
		new Imposto().show(false);
	}
	
}
