
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


public class ActividadStreams {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
		cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
		cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
		cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
		cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));
		
		System.out.println("la cantidad de cursos con una duración mayor a 5 horas.");
		cursos.stream().filter(a -> a.getDuracion() > 5).forEach(s -> System.out.println(s));
		
		System.out.println("\nla cantidad de cursos con una duración menor a 2 horas.");
		cursos.stream().filter(a -> a.getDuracion() < 2).forEach(s -> System.out.println(s));
		
		System.out.println("\nListar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.");
		cursos.stream().filter(a -> a.getVideos() > 50).forEach(s -> System.out.println(s.getTitulo()));
		
		System.out.println("\nMostrar en consola el título de los 3 cursos con mayor duración.");
		Comparator<Curso> compareByDuracion = Comparator.comparing( Curso::getDuracion );
		cursos.stream().sorted(compareByDuracion.reversed()).limit(3).forEach(s -> System.out.println(s));
		
		System.out.println("\nMostrar en consola la duración total de todos los cursos.");
		Double duracionTotal = cursos.stream().flatMapToDouble(d -> DoubleStream.of(d.getDuracion())).sum();
		System.out.println (duracionTotal);
				
		System.out.println("\nMostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.");
		cursos.stream().filter( m -> m.getDuracion() > (duracionTotal / cursos.size() ) ).forEach(d -> System.out.println(d));
		
		System.out.println("\nMostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.");
		cursos.stream().filter(d -> d.getAlumnos() < 500).forEach(s -> System.out.println(s.getTitulo()));
		
		System.out.println("\nObtener el curso con mayor duración.");
		System.out.println(cursos.stream().reduce(Curso::cursoMax).get());
		
		System.out.println("\nCrear una lista de Strings con todos los titulos de los cursos.");
		cursos.stream().map(x -> x.getTitulo()).collect(Collectors.toList()).forEach(s->System.out.println(s));;
		
		
		
		
	}
	
	public static class Curso{

	    private String titulo;
	    private float duracion; //Expresada en horas
	    private int videos; //cantidad de vídeos
	    private int alumnos; //Cantidad de alumnos

	    public Curso(String titulo, float duracion, int videos, int alumnos) {
	        this.titulo = titulo;
	        this.duracion = duracion;
	        this.videos = videos;
	        this.alumnos = alumnos;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public float getDuracion() {
	        return duracion;
	    }

	    public void setDuracion(float duracion) {
	        this.duracion = duracion;
	    }

	    public int getVideos() {
	        return videos;
	    }

	    public void setVideos(int videos) {
	        this.videos = videos;
	    }

	    public int getAlumnos() {
	        return alumnos;
	    }

	    public void setAlumnos(int alumnos) {
	        this.alumnos = alumnos;
	    }

		@Override
		public String toString() {
			return "titulo=" + titulo + ", duracion=" + duracion + ", videos=" + videos + ", alumnos=" + alumnos;
		}
	    
		public static Curso cursoMax(Curso x, Curso y) {
			return x.getDuracion() > y.getDuracion() ? x : y;
		}	
		
		
	}
	
}
