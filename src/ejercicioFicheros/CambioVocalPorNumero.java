package ejercicioFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CambioVocalPorNumero {

	public static void main(String[] args) {
		//ruta del fichero
		String ruta = "C:" + File.separator +  "Users"+ File.separator + "loren" + File.separator + "Desktop" + File.separator + "EXAMEN PARCIAL AD" + File.separator + "ficheros.txt";
		//instancia de la clase fichero
		File fichero = new File(ruta);
		//creamos un array de vocales
		char[] arrayVocales = {'a','e','i','o','u'};
		//para guardar el nuevo texto
		String nuevoTexto = "";
		//para saber si ha leido vocal
		boolean vocal = false;
		
		// verificamos si existe el fichero
		if(fichero.exists()) {
			
			// Leemos el contenido del fichero
			try {
				FileReader fr = new FileReader(fichero);
				//guardamos lo leido en int y haremos cast a char
				int leido = fr.read();
				char caracterLeido;
				
				while(leido != -1) {
					caracterLeido = (char)leido;
					for(int i = 0; i < arrayVocales.length; i++) {
						if(caracterLeido == arrayVocales[i]) {
							nuevoTexto += (i+1);
							vocal = true;
						}
					}
					if(!vocal) {
						nuevoTexto += caracterLeido;
					}
					//reiniciamos valor y actualizamos bucle
					vocal = false;
					leido = fr.read();
				}
				//cerramos fr
				fr.close();
				
				//pasamos a escribir
				FileWriter fw = new FileWriter(fichero);
				
				char[] arrayTextoNuevo = nuevoTexto.toCharArray();
				
				for(int i = 0; i < arrayTextoNuevo.length; i++) {
					fw.write(arrayTextoNuevo[i]);
				}
				
				//cerramos el fw
				fw.close();
				// mostramos el contenido
				System.out.println("Este es el fichero con las vocales cambiadas por números:");
				System.out.println(nuevoTexto);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El fichero no existe");
		}

	}

}
