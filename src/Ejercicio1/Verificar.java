package Ejercicio1;

public class Verificar {
	
	public boolean vDNI (String dni) throws DniInvalido {
		
		Boolean dniInvalido = false;
		
		for (char c : dni.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
		}
		
		///SI SIGUE AL IF ES PORQUE NO TIENE LETRAS
		
		if (dni == null || dni.contains("."))
    	{
			dniInvalido = true;
    		
    	}
		
		else dniInvalido = false;
		
		return dniInvalido;
	
		
	}
}
	
	


