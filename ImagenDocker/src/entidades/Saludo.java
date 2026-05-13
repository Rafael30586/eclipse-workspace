package entidades;

import java.util.Scanner;

public class Saludo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Decime tu nombre");
		nombre = entrada.next();
		System.out.println("Hola "+nombre);
		entrada.close();

	}

}
