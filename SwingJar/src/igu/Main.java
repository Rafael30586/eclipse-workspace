package igu;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame("Ventana");
		JPanel panel = new JPanel();
		
		ventana.setBounds(50, 50, 200, 200);
		ventana.setVisible(true);
		
		ventana.add(panel);
		
		panel.setBounds(50, 50, 200, 200);
		panel.setBackground(new Color(95, 165, 25));
		System.out.println("Hola che");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
