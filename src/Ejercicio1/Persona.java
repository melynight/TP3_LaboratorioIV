package Ejercicio1;

import java.util.Objects;

public class Persona {
	
	//Atributos
	
	String nombre, apellido, dni;
	
	//Constructores
	
	public Persona() {
		this.nombre = "Sin nombre";
		this.apellido = "Sin apellido";
		this.dni = "xxxxxxxx";
	}
	
	public Persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	//Metodos 
	public static Boolean verificarDniInvalido(String dni) throws DniInvalido {
		Boolean esLetras = false;
		
		if(!dni.matches("[0-9]+")) {
			esLetras = true;
		}
		
		if(esLetras) {
			throw new DniInvalido();
		}
		else return false;
	}
	
	@Override
	public String toString() {
		
		return "Nombre: " + nombre + ", apellido: " + apellido + ", DNI: " + dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
