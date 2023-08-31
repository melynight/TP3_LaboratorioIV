package Ejercicio1;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Archivo archivo=new Archivo();
		archivo.setRuta("Archivos/Personas.txt");
		
		archivo.verificarArchivo(archivo);
	
		System.out.println("\n LISTADO: ");
		List<Persona> lista= archivo.LeerYCargarLista();
		Persona p = new Persona();
		System.out.println("\n LISTADO CORRECTO: ");
		p.mostrarLista(lista);
		
		Archivo archivo1=new Archivo();
		archivo1.setRuta("Archivos/Resultado.txt");
		archivo1.verificarArchivo(archivo1);
		
		for(int i=0; i<lista.size(); i++)
		{
			archivo1.escribe_lineas(lista.get(i).toString() + "\n");
		} 

	}
}