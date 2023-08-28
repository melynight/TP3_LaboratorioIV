package Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo {
	
	private String ruta;
	

	
	public String getRuta() {
			return ruta;
		}
	
	public void setRuta(String ruta) {
			this.ruta = ruta;
		}
	
	public boolean existe() {
		File archivo=new File(ruta);
		if(archivo.exists())
			return true;
		return false;
	}
		
	public void Escribir_Registros(String nombre,String apellido,String dni) {
			try {
				FileWriter entrada = new FileWriter(ruta,true);
				BufferedWriter miBuffer = new BufferedWriter (entrada);
				miBuffer.write(nombre);
				miBuffer.write(apellido);
				miBuffer.write(dni);
				miBuffer.close();
				entrada.close();
				
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("Error en la escritura de registros");
			}
			
		}
	
	public void Leer_Registros() {
		try {
			FileReader entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader (entrada);
			String linea= "";
			while(linea!=null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			entrada.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Error en la lectura de registros");
		}
		
	}
	

}
