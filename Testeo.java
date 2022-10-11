import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Testeo {

	public static void main(String[] args) {
		
//		List<String> personas = new ArrayList<>();
//		personas.add("hola");
//		personas.add("como");
//		personas.add("estas");
//		personas.add("?");
//		
//		personas.forEach(x->System.out.println(x));
//		
//		personas.forEach(System.out::println);
		
		
		
		List<Cliente> listaCliente = new ArrayList<>();
		
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
		
		System.out.println("***********************************LIST***********************************");
		
		listaCliente.stream().sorted(Comparator.comparing(Cliente::getNombre)).forEach(System.out::println);
		System.out.println("Total acumulado: "+listaCliente.stream().flatMapToDouble(p->DoubleStream.of(p.getSaldo())).sum());
		
		Optional<Cliente> menorSaldo = getMenorSaldo(listaCliente);
		if(menorSaldo.isPresent()) {
			System.out.println("\nMenor Saldo");
			System.out.println(menorSaldo);
		}
		
		Optional<Cliente> mayorSaldo = getMayorSaldo(listaCliente);
		if(mayorSaldo.isPresent()) {
			System.out.println("\nMayor Saldo");
			System.out.println(mayorSaldo);
		}
		
		System.out.println("\nLista Ordenada A-Z");
		 getSortedNamesAZ(listaCliente).stream().forEach(x->System.out.println(x));
		
		 System.out.println("\nLista Ordenada Z-A");
		 getSortedNames(listaCliente).stream().forEach(x->System.out.println(x));
		 
		 System.out.println("\n Personas con saldo mayor a 10.000 - filter");
		 listaCliente.stream().filter(y -> y.getSaldo() > 10000).forEach(x -> System.out.println(x));

		 System.out.println("\n Personas con saldo menor a 10.000 - filter");
		 listaCliente.stream().filter(y -> y.getSaldo() < 10000).forEach(x -> System.out.println(x));
		 
		 System.out.println("\n en la lista de cliente existen personas sin saldo?");
		 System.out.println(listaCliente.stream().allMatch(y -> y.getSaldo() == null || y.getSaldo() == 0D));
		
		 System.out.println("\n todas las personas de la lista de cliente tienen saldo?");
		 System.out.println(listaCliente.stream().allMatch(y -> y.getSaldo() != null || y.getSaldo() != 0D));
		 
		 System.out.println("\n collect");
		 System.out.println(listaCliente.stream().collect(Collectors.toList()));
		 
		 System.out.println("\n convertir de minusculas a mayusculas los nombres de la lista");
		 listaCliente.stream().map(e -> e.getNombre().toUpperCase()).forEach(j -> System.out.print(j+"\t"));
		 
		 System.out.println("acumulado: "+listaCliente.stream()
				 .peek(d->System.out.println("Op 1. "+d))
				 .filter(f -> f.getSaldo() > 20000D)
				 .peek(x -> System.out.println("Op 2. "+x))
				 .flatMapToDouble(d -> DoubleStream.of(d.getSaldo()))
				 .sum());
		 
		 System.out.println(listaCliente.stream().peek(s->s.setNombre(s.getNombre().toUpperCase())).distinct().collect(Collectors.toList()));
		 
		 System.out.println("Sort by field");
		 listaCliente.stream().sorted((s1,s2)->s1.getNombre().compareTo(s2.getNombre())).forEach(c -> System.out.println(c));
		 
		 System.out.println("Saldo Max reduce");
		 System.out.println(listaCliente.stream().reduce(Cliente::saldoMax).get());
		 
		 System.out.println("Skip");
		 System.out.println(listaCliente.stream().sorted((s1,s2)->s1.getNombre().compareTo(s2.getNombre())).skip(3).collect(Collectors.toList()));
		 
		 System.out.println("***********************************MAP***********************************");
		 
		 	Map<String, Cliente> mapaCliente = new HashMap<>();
			
		 	mapaCliente.put("Yeison", new Cliente("Yeison", 123456, 5000D));
		 	mapaCliente.put("Julian", new Cliente("Julian", 032413, 10000D));
		 	mapaCliente.put("Ever", new Cliente("Ever", 352322, 6000D));
		 	mapaCliente.put("Maria", new Cliente("Maria", 23645, 43000D));
		 	mapaCliente.put("Alejandra", new Cliente("Alejandra", 573212, 51000D));
		 	mapaCliente.put("Diana", new Cliente("Diana", 12334, 2000D));
		 	mapaCliente.put("Juliana", new Cliente("Juliana", 4675787, 1000D));
		 	
		 	mapaCliente.entrySet().stream().filter(d -> d.getValue().getSaldo() > 10000D).forEach(x -> System.out.println(x.getValue()));
		 	
		 	// el comportamiento del stream en Map no es nativo y se debe convertir primero a una lista o conjunto, ahora bien, para este ejercicio
		 	// se utiliza entrySet() y accesar a los datos mediante las key's o values del objeto Map
		
		 	System.out.println("acumulado: "+mapaCliente.entrySet().stream()
			 .peek(d->System.out.println("Op 1. "+d))
			 .filter(f -> f.getValue().getSaldo() > 20000D)
			 .peek(x -> System.out.println("Op 2. "+x))
			 .flatMapToDouble(d -> DoubleStream.of(d.getValue().getSaldo()))
			 .sum());
		 	
		 	 System.out.println("\n Personas con saldo menor a 10.000 - filter");
		 	mapaCliente.entrySet().stream().filter(y -> y.getValue().getSaldo() < 10000).forEach(x -> System.out.println(x));
			 
			 System.out.println("\n en la lista de cliente existen personas sin saldo?");
			 System.out.println(mapaCliente.entrySet().stream().allMatch(y -> y.getValue().getSaldo() == null || y.getValue().getSaldo() == 0D));
			
			 System.out.println("\n todas las personas de la lista de cliente tienen saldo?");
			 System.out.println(mapaCliente.entrySet().stream().allMatch(y -> y.getValue().getSaldo() != null || y.getValue().getSaldo() != 0D));
			 
			 System.out.println("\n collect");
			 System.out.println(mapaCliente.entrySet().stream().collect(Collectors.toList()));
			 
			 System.out.println("\n convertir de minusculas a mayusculas los nombres de la lista");
			 mapaCliente.entrySet().stream().map(e -> e.getValue().getNombre().toUpperCase()).forEach(j -> System.out.print(j+"\t"));
		 	
		
	}
	
	public static class Cliente{
		
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
			return "nombre=" + nombre + ", documento=" + documento + ", saldo=" + saldo ;
		}
		
		public static Cliente saldoMax(Cliente x, Cliente y) {
			return x.getSaldo() > y.getSaldo() ? x : y;
		}
	}
	
	
	
	public static Optional<Cliente> getMenorSaldo(List<Cliente> listaCliente){
		
		for (Cliente cl: listaCliente) {
			if(cl.getSaldo()<=300) {
				return Optional.of(cl);
			}
		}
		
		return Optional.empty();
	}
	
	public static Optional<Cliente> getMayorSaldo(List<Cliente> listaCliente){
		
		Cliente aux = new Cliente(null, null, 0D);
		
		for (Cliente cl: listaCliente) {
			aux = (cl.getSaldo() > aux.getSaldo())? cl: aux;
		}
		
		return Optional.of(aux);
	}
	
	public static List<Cliente> getSortedNamesAZ(List<Cliente> listaCliente){
		
		List<Cliente> clientesOredenados = listaCliente.stream().sorted((l1,l2)->l1.getNombre().compareTo(l2.getNombre())).collect(Collectors.toList());
				
		return clientesOredenados;
	}
	
	public static List<Cliente> getSortedNames(List<Cliente> listaCliente){
		
		List<Cliente> clientesOredenados = listaCliente.stream().sorted((l1,l2)->l2.getNombre().compareTo(l1.getNombre())).collect(Collectors.toList());
				
		return clientesOredenados;
	}
	
	Optional<String> s = Optional.of("ever");
	
}
