
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ever.bravo
 *
 */
public class ActividadIOData {

	/**
	 * @param args
	 * @throws IOException
	 */

	/*
	 * 1. Crear funcion que reciba una lista de objetos(T) y cree un csv -
	 * Parametros (List<Objeto>, cabeceras[], nombre, delimitador) - Proceso: * -
	 * crear un archivo con el nombre indicado (si existe debe mostrar la alerta) *
	 * - verificar la coincidencia entre el tamaño de cabeceras y tamaño objeto
	 * (columnas) * - recorrer y agreagr el objeto con su delimitador * - salto de
	 * linea para nuevo registro - Salida: Archivo.csv 2. Crear la funcion para leer
	 * el csv con solo el objeto - Parametros: (archivo, delimitador) - Proceso * -
	 * capturar la cabecera * - obtengo la siguiente linea * - divido la linea de
	 * valores por el delimitador - Salida: imprimo en consola la salida
	 * 
	 */

	public static void main(String[] args) throws IOException {
		
		System.out.println("\n Lista de Clientes \n");
		String[] cabeceraCliente = { "Nombre", "Identificacion", "Saldo" };
		String ruta = crearCsv(retornarListaCliente(), cabeceraCliente, "clientes", ";");
		leerArchivo(ruta);
		
		System.out.println("\n Lista de Animales \n");
		String[] cabeceraAnimal = { "Nombre", "Tipo", "Edad", "Color" };
		String ruta2 = crearCsv(retornarListaAnimal(), cabeceraAnimal, "animales", ";");
		leerArchivo(ruta2);
		
		// retornarListaCliente().stream().forEach(x->System.out.println(x));

	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static String crearCsv(List<Object> lObj, String[] cabecera, String nombreArchivo, String delimitador)
			throws IOException {
		String ruta = "";
		BufferedWriter bw = null;
		try {
			if (!nombreArchivo.equals("")) {
				File archivo = new File(nombreArchivo + ".csv");
				ruta = archivo.getAbsolutePath();
				
				if (!archivo.exists()) {
					boolean confirmacion = archivo.createNewFile();
					System.out.println(confirmacion ? "Archivo: " + archivo.getName() + " creado con exito."
							: "Error al crear el archivo");
				}

				FileWriter fw = new FileWriter(archivo);
				bw = new BufferedWriter(fw);

				if (delimitador == "")
					throw new ErrorException("Debe suministrar un delimitador");

				if (cabecera.length > 0) {

					for (String cab : cabecera) {
						bw.append(cab + delimitador);
					}
					bw.newLine();

					if (lObj.size() > 0) {

						for (Object obj : lObj) {

							try {
								Class cls = Class.forName(obj.getClass().getName());

								Field[] fields = cls.getDeclaredFields();

								for (Field field : fields) {
									String nombreCampo = field.getName();
									String letraMayus = nombreCampo.substring(0, 1).toUpperCase();
									String restoMinus = nombreCampo.substring(1);
									String nombreMetodo = "get" + letraMayus + restoMinus;
									
									Method method = cls.getMethod(nombreMetodo, new Class[] {});
									method.setAccessible(true);
									Object resultValue = method.invoke(obj, new Object[] {});
									bw.append(resultValue + delimitador);
								}
								bw.newLine();
							} catch (ClassNotFoundException | NoSuchMethodException | SecurityException
									| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								System.out.println("Error fatal: " + e.getMessage());
							}

						}

					} else {
						throw new ErrorException("Error: la lista esta sin elementos");
					}

				} else {
					throw new ErrorException("Cabeceras del archivo no ingresadas");
				}

			} else {
				throw new ErrorException("Debe definir un nombre de archivo");
			}

			bw.close();
		} catch (ErrorException e) {
			System.out.println(e.getMessage());
		}
		
		return ruta;
	}

	public static void leerArchivo(String ruta) throws IOException {
		
		
		try  {
			if (ruta == "") throw new ErrorException("No se ingresó una ruta");
			
			FileReader file = new FileReader(ruta); 
			
			BufferedReader bf = new BufferedReader(file);
			String linea = bf.readLine();
			String linea2 = linea;
			if(linea != null) {
				String[] arregloCabecera = linea.split(";");
				
				while(linea2 != null) {
					
					linea2 = bf.readLine();
					if(linea2 != null) {
						String[] arregloValor = linea2.split(";");
						
						for (int x = 0, y = 0; x < arregloValor.length && y < arregloCabecera.length; x++, y++) {
							System.out.print(arregloCabecera[y] +": "+arregloValor[x]+"\t");
						}
						
						System.out.println();
					}
			}
				
			}
			bf.close();
			
		}catch (ErrorException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static List<Object> retornarListaCliente() {

		List<Object> listaCliente = new ArrayList<>();
		listaCliente.add(new Cliente("Yeison", 123456, 5000D));
		listaCliente.add(new Cliente("Julian", 032413, 10000D));
		listaCliente.add(new Cliente("Ever", 352322, 6000D));
		listaCliente.add(new Cliente("Maria", 23645, 43000D));
		listaCliente.add(new Cliente("Alejandra", 573212, 51000D));
		listaCliente.add(new Cliente("Diana", 12334, 2000D));
		listaCliente.add(new Cliente("Juliana", 4675787, 1000D));
		listaCliente.add(new Cliente("Eugenia", 2355, 1000D));
		listaCliente.add(new Cliente("Juan", 5795645, 300D));
		listaCliente.add(new Cliente("Yam", 9876, 500D));
		listaCliente.add(new Cliente("Camilo", 5634, 800D));
		listaCliente.add(new Cliente("Pedro", 143452, 23000D));
		listaCliente.add(new Cliente("Jose", 4543, 6000D));
		listaCliente.add(new Cliente("Fabian", 45676, 99000D));
		listaCliente.add(new Cliente("Juan", 6462, 32000D));
		listaCliente.add(new Cliente("Juancho", 12546356, 67000D));
		listaCliente.add(new Cliente("Jesus", 98976, 32000D));
		listaCliente.add(new Cliente("Merlis", 134451, 9000D));
		listaCliente.add(new Cliente("Gloria", 88754, 8000D));
		listaCliente.add(new Cliente("Desconocido", 57644, 7000D));

		return listaCliente;
	}
	
	public static List<Object> retornarListaAnimal() {
		
		List<Object> animales = new ArrayList<>();
		animales.add(new Animal("Mishi", "Gato", 2, "Negro"));
		animales.add(new Animal("Luka", "Perro", 1, "Blanco"));
		animales.add(new Animal("Dominó", "Gato", 3, "Manchas Negras"));
		animales.add(new Animal("Lucifer", "Jaguar", 2, "Amarillo"));
		animales.add(new Animal("Pablo", "Leon", 1, "Blanco"));
		animales.add(new Animal("Pablo", "Leon", 1, "Blanco"));
		animales.add(new Animal("Firulais", "Perro", 2, "Negro"));
		animales.add(new Animal("El Mishi", "Guepardo", 1, "Manchas Amarillas"));
		animales.add(new Animal("Tita", "Nutria", 1, "Manchas blancas"));
		animales.add(new Animal("Tulipan", "Perro", 3, "Blanco"));
		
		return animales;
	}

	public static class Cliente {

		private String nombre;
		private Integer documento;
		private Double saldo;

		public Cliente() {
			super();
		}

		public Cliente(String nombre, Integer documento, Double saldo) {
			super();
			this.nombre = nombre;
			this.documento = documento;
			this.saldo = saldo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getDocumento() {
			return documento;
		}

		public void setDocumento(Integer documento) {
			this.documento = documento;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		@Override
		public String toString() {
			return "nombre=" + nombre + ", documento=" + documento + ", saldo=" + saldo;
		}

	}

	public static class ErrorException extends Exception {

		private static final long serialVersionUID = 1L;

		public ErrorException() {
			super();
		}

		public ErrorException(String mensaje) {
			super(String.format("Error: %s", mensaje));
		}

		public ErrorException(Throwable causa) {
			super(causa);
		}

		public ErrorException(String mensaje, Throwable causa) {
			super(mensaje, causa);
		}

	}

	public static class Animal{
		
		private String nombre;
		private String tipo;
		private int edad;
		private String color;
		
		public Animal(String nombre, String tipo, int edad, String color) {
			super();
			this.nombre = nombre;
			this.tipo = tipo;
			this.edad = edad;
			this.color = color;
		}
		
		public Animal() {
			super();
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "Nombre=" + nombre + ", tipo=" + tipo + ", edad=" + edad + ", color=" + color;
		}
		
	}
}
