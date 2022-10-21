package fundNovatec.operaciones;

import fundNovatec.persistencia.FundacionRepoImpl;
import fundNovatec.persistencia.RolUsuarioRepoImpl;
import fundNovatec.persistencia.SexoRepoImpl;

public class OperacionesPersonalizadas {

	public OperacionesPersonalizadas() {
	}
	
	final static SexoRepoImpl SEXO = new SexoRepoImpl();
	final static RolUsuarioRepoImpl RUSER = new RolUsuarioRepoImpl();
	final static FundacionRepoImpl FUND = new FundacionRepoImpl();
	
	public static void desplegarSexos() {
		SEXO.listarTodo().stream().forEach(x->System.out.println(x.getIdsexo()+" -> "+x.getDescripcion()));
	}

	public static void desplegarRoles() {
		RUSER.listarTodo().stream().forEach(x->System.out.println(x));
	}
	
	public static int getRolUsuario() {
		return RUSER.rolUsuarioReg();
	}
	
	public static void desplegarFundaciones() {
		FUND.listarTodo().stream().forEach(x->System.out.println(x.getNit() +" -> "+x.getNombre()));
	}
	
}
