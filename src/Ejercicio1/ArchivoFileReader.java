package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoFileReader {

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
		
	public void Escribir_Registros(String registro) {
		try {
			FileWriter escribe= new FileWriter(ruta,true);
			for(int i=0;i<registro.length();i++) {
				escribe.write(registro.charAt(i));
			}
			escribe.close();
				
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("Error en la escritura de registros");
			}
	}
	
	public void Leer_Registros() {
		FileReader entrada;
		try (BufferedReader miBuffer = new BufferedReader(entrada =new FileReader(ruta))) {
            int c;
            while ((c = miBuffer.read()) != -1) {
                System.out.print((char) c);
            }
			entrada.close();		
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Error en la lectura de registros");
		}
	}
	
	public void crearArray() {
		 ArrayList<String> arr = new ArrayList<String>();
		 
	     try (BufferedReader br = new BufferedReader(new FileReader("Archivos/Personas.txt")))
	     {
	    	 String sCurrentLine;
	    	 while ((sCurrentLine = br.readLine()) != null) {
	    		 arr.add(sCurrentLine);
	        }
	     }catch (IOException e) {
	    	 e.printStackTrace();
	     } 
	}

	public void verificarArchivo (ArchivoFileReader archivo) {
		if(archivo.existe()) {
			System.out.println("El archivo existe");
		}
		else 
		{
			System.out.println("El archivo no existe");
		}
	}
}
