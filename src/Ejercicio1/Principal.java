package Ejercicio1;

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
		archivo.Escribir_Registros("pepe", "god", "mamarre");
		System.out.println("\n LISTADO: ");
		archivo.Leer_Registros();

	}

}
