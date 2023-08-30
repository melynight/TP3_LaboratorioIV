package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Archivo archivo=new Archivo();
		archivo.setRuta("Archivos/Personas.txt");
		
		if(archivo.existe()) {
			System.out.println("El archivo existe");
		}
		else 
		{
			System.out.println("El archivo no existe");
		}
		
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
		
		  ArrayList<String> arr = new ArrayList<String>();
	        try (BufferedReader br = new BufferedReader(new FileReader("Archivos/Personas.txt")))
	        {

	            String sCurrentLine;

	            while ((sCurrentLine = br.readLine()) != null) {
	                arr.add(sCurrentLine);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	}

}
