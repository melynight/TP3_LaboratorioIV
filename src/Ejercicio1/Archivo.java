package Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
			miBuffer.write("\n" + nombre);
			miBuffer.write("-");
			miBuffer.write(apellido);
			miBuffer.write("-");
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
			miBuffer.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Error en la lectura de registros");
		}	
	}
	
    public List<Persona> LeerYCargarLista() {
        List<Persona> AlPersonas = new ArrayList<Persona>();

        FileReader entrada;
        try {
            entrada = new FileReader(ruta);
            BufferedReader miBuffer = new BufferedReader(entrada);

            String linea = "";
            while (linea != null) {
                System.out.println(linea);
                String[] separador = linea.split("-");
                
                if (separador.length == 3) {
                	
                	String nombre = separador[0];
                	String apellido = separador[1];
                	String dni = separador[2];
                	Persona nuevaPersona = new Persona(nombre,apellido,dni);
                	Verificar verificar = new Verificar();
                	Boolean yaExiste = false;
                	Boolean dniInvalido = false;
                	
                	dniInvalido = verificar.vDNI(dni);
                	
                	try {
                        Persona.verificarDniInvalido(dni); 
                    } catch (DniInvalido e) {
                        System.out.println(e.getMessage());
                       
                    }
                	
                	for(Persona persona : AlPersonas) {
                		
                		if(persona.getApellido().equals(nuevaPersona.getApellido()) && 
                				persona.getDni().equals(nuevaPersona.getDni()) && 
                				persona.getNombre().equals(nuevaPersona.getNombre())) {
                			yaExiste = true;
                			
                		}
                		
                	}
                	if(!yaExiste && !dniInvalido) {
                		AlPersonas.add(nuevaPersona);
                	}
                }
                
                linea = miBuffer.readLine();
            }
            
            miBuffer.close();
            entrada.close();
        } catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en la lectura de registros");
        }
        return AlPersonas;
    }
    
    public void escribe_lineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	
	public void verificarArchivo (Archivo archivo) {
		if(archivo.existe()) {
			System.out.println("El archivo existe");
		}
		else 
		{
			System.out.println("El archivo no existe,Lo creamos!");
		}
	}
 }