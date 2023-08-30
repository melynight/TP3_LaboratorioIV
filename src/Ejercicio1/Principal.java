package Ejercicio1;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Archivo archivo=new Archivo();
		archivo.setRuta("Archivos/Personas.txt");
		
		
		archivo.verificarArchivo(archivo);
	
		System.out.println("\n LISTADO: ");
		archivo.Leer_Registros();

		String dni = JOptionPane.showInputDialog("Ingrese un dni:");
		try {
			Persona.verificarDniInvalido(dni);
			System.out.println("El dni ingresado es valido!");
			
		}
		catch (DniInvalido e) {
			System.out.println("El dni ingresado es invalido, solo ingrese numeros.");
			e.printStackTrace();
		}
		
		archivo.crearArray();

}
	
}
