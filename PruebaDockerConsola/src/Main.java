import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String nombre;
		int numero = 0;
		int otroNumero = 0;
		Scanner entrada = new Scanner(System.in).useDelimiter("\n");
		
		try {
			System.out.println("Decime tu nombre");
			nombre = entrada.next();
			System.out.println("Hola "+nombre);
			/*
			System.out.println("Decime un numero cualquiera");
			numero = entrada.nextInt();
			System.out.println("Ahora decime otro");
			otroNumero = entrada.nextInt();
			System.out.println("Si los sumo el resultado es: "+(numero + otroNumero));*/
			entrada.close();
		}catch(Exception e) {
			System.out.println("Ha ocurrido un error");
		}
		
	}

}
