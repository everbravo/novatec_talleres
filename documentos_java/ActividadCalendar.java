
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ActividadCalendar {
	
	//lista recursiva para buscar objetos e imprimir, hacer sumatorias e imprimirlos, obtener los maximos y minimos 
	
	
	
	public static void main (String[] args) {
		
		Calendar calendario = Calendar.getInstance();
		Calendar cal = new GregorianCalendar();
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(calendario.get(Calendar.YEAR));
		
		System.out.println(cal.getWeeksInWeekYear());
		System.out.println(cal.getWeekYear());
		
		System.out.println(cal.getActualMaximum(Calendar.MONTH));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fecha = new Date();
		System.out.println(sdf.format(fecha));
		
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		System.out.println(LocalDate.now().minusDays(12));
		System.out.println(LocalDate.now().plusDays(12));
		System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
		
		System.out.println( ChronoUnit.DECADES.between(LocalDate.of(2001, Month.OCTOBER, 15), LocalDate.now()));
		
		Period periodo = LocalDate.now().until(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()));
		System.out.println(periodo.getDays());
		
		List<Animal> animales = new ArrayList<>();
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
		
		animales.stream().forEach(s -> System.out.println(s));
		System.out.println(animales.size());
		
		// Covertir de localdate a gregoriancalendar
		LocalDate f = LocalDate.now();
		System.out.println(" - F => "+f);
		GregorianCalendar gc = GregorianCalendar.from(f.atStartOfDay(ZoneId.systemDefault()));
		System.out.println("Localdate a Calendario Gregoriano => "+gc);
		System.out.println("Calendario Gregoriano - DD => "+gc.DAY_OF_MONTH);
		
		//otra forma de convertir de localdate a gregoriancalendar
		GregorianCalendar gc2 = (GregorianCalendar) new GregorianCalendar.Builder().setDate(f.getYear(), f.getMonthValue(), f.getDayOfMonth()).build();
		System.out.println("Localdate a Calendario Gregoriano 2 => "+gc2);
		
		// Contar las veces que se repite un nombre en la lista de animales
		cantidadOcurrenciaNombre("Pablo", animales, 0, 0);
		
		// Realizar la sumatoria de edades en la lista
		sumaEdades(animales, 0, 0);
		
		// Obtener la edad maxima
		edadMax(animales, 0, 0);
		
		// Obtener la edad minima
		edadMin(animales, 0, 0);
		
	}
	
	public static void sumaEdades(List<Animal> animal, int inicio, int cant) {
		
		if (inicio < animal.size()) {
			cant += animal.get(inicio).getEdad();
			sumaEdades(animal, inicio+1, cant);	
		}else {
			System.out.println("Sumatoria de Edades => "+cant);
		}
	}
	
	public static void edadMax(List<Animal> animal, int inicio, int max) {
		
		if (inicio < animal.size()) {
			if (animal.get(inicio).getEdad() > max) {
				max = animal.get(inicio).getEdad();
			}
			edadMax(animal, inicio+1, max);	
		}else {
			System.out.println("Edad Maxima => "+max);
		}
	}
	
	public static void edadMin(List<Animal> animal, int inicio, int min) {
		
		if(inicio == 0)
			min = animal.get(inicio).getEdad();
		
		if (inicio < animal.size()) {
			if (animal.get(inicio).getEdad() < min) {
				min = animal.get(inicio).getEdad();
			}
			edadMin(animal, inicio+1, min);	
		}else {
			System.out.println("Edad Minima => "+min);
		}
	}
	
	
	public static int catidadCoincidNombre(String nombre, List<Animal> anim) {
		int cont = 0;
		for (int x=0; x<anim.size(); x++) {
			if (anim.get(x).getNombre().equals(nombre))
				cont += 1;
		}
		
		return cont;
	}
	
	public static void cantidadOcurrenciaNombre(String nombre, List<Animal> animal, int inicio, int res) {
		
		if (inicio < animal.size()) {
			if (animal.get(inicio).getNombre().equals(nombre)) {
				res += 1;
				cantidadOcurrenciaNombre(nombre, animal, inicio+1, res);
			}else {
				cantidadOcurrenciaNombre(nombre, animal, inicio+1, res);
				
			}
			
		}else {
			System.out.println("Cantidad de Ocurrecias => "+res);
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
