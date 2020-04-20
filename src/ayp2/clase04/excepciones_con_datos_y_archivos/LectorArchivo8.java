package ayp2.clase04.excepciones_con_datos_y_archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LectorArchivo8 {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No se ha especificado ningún archivo.");
			System.exit(1);
		}
		for (int i = 0; i < args.length; i++) {
			try {
				mostrarArchivoPorSalidaEstandar(leerArchivoQueSeguramenteEntraEnMemoria(args[i]).toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	String ubicacionDeMiArchivoPequenio = "capitales-de-provincias-argentinas.csv";
	String ubicacionDeMiArchivoGigante = "capitales-de-provincias-del-mundo.csv";

	public static List<String> leerArchivoQueSeguramenteEntraEnMemoria(String ubicacionDeMiArchivo) throws Exception {
		return Files.readAllLines(Paths.get(ubicacionDeMiArchivo));
	}

	public static Stream<String> leerArchivoQueQuizasNoEntraEnMemoria(String ubicacionDeMiArchivo) throws Exception {
		return Files.lines(Paths.get(ubicacionDeMiArchivo));
	}

	public static void mostrarArchivoPorSalidaEstandar(String ubicacionDeMiArchivo) throws Exception {
		System.out.println("Procesando Archivo: " + ubicacionDeMiArchivo);

		try {
			System.out.println("Leyendolo asumiendo que seguramente entra en memoria");
			List<String> contenidoDeMiArchivoCorto = leerArchivoQueSeguramenteEntraEnMemoria(ubicacionDeMiArchivo);
			System.out.println("Imprimiendo...");
			contenidoDeMiArchivoCorto.forEach(System.out::println);

			System.out.println("Leyendolo asumiendo que quizás no entre en memoria");
			Stream<String> contenidoDeMiArchivoLargo = leerArchivoQueQuizasNoEntraEnMemoria(ubicacionDeMiArchivo);
			System.out.println("Imprimiendo...");
			contenidoDeMiArchivoLargo.forEach(System.out::println);

		}

		catch (FileNotFoundException e1) {
			System.out.println("Archivo no encontrado.");
		}

		catch (FileSystemException e2) {
			System.out.println("Error del sistema de archivos.");
		}

		catch (IOException e3) {
			System.out.println("Error de E/S no identificado.");
		}

		catch (Exception e) {
			System.out.println("Error no identificado.");
		}

		finally {
			System.out.println("Saliendo...");
			System.exit(1);
		}
	}
}

