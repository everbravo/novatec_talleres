package finalProject.reportes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ToCsv {

	public ToCsv() {

	}

	public void toCsv(List<?> lista) {

		AtomicReference<BufferedWriter> bw = new AtomicReference<>();
		try {
			LocalDateTime today = LocalDateTime.now();
			String fileName = "Reporte" + today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".csv";
			File archivo = new File(fileName);
			if (!archivo.exists()) {
				boolean existe = archivo.createNewFile();
				System.out.println(existe ? "Archivo " + archivo.getName() + " generado" : "Error al crear el archivo");
			}
			FileWriter fw = new FileWriter(archivo);
			bw.set(new BufferedWriter(fw));
			AtomicReference<StringBuilder> cabecera = new AtomicReference<>();
			cabecera.set(new StringBuilder());
			AtomicReference<StringBuilder> linea = new AtomicReference<>();
			linea.set(new StringBuilder());
			AtomicInteger contador = new AtomicInteger();
			lista.forEach(o -> {
				Class<?> clase = o.getClass();
				
				List<Field> listaCampos = Arrays.stream(o.getClass().getDeclaredFields()).collect(Collectors.toList());
				listaCampos.forEach(f -> {
					try {
						Field campo = clase.getDeclaredField(f.getName());
						campo.setAccessible(true);
						
						if (contador.get() == 0) {
							cabecera.get().append(campo.getName());
							cabecera.get().append(";");
						}
						linea.get().append(campo.get(o));
						linea.get().append(";");
					} catch (NoSuchFieldException | IllegalAccessException e) {
						e.printStackTrace();
					}
				});
				try {
					if (contador.get() == 0) {
						bw.get().write(cabecera.get().toString());
						bw.get().newLine();
					}
					bw.get().write(linea.get().toString());
					bw.get().newLine();
					linea.set(new StringBuilder());
				} catch (IOException e) {
					e.printStackTrace();
				}
				contador.getAndIncrement();
			});
			bw.get().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
