package persistenciaTestes;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.GerenteDePersistencia;
import persistence.util.Coordinates;
import persistence.util.Estado;
import beans.Administrador;
import beans.Caso;
import exceptions.AdministradorNotFoundException;
import exceptions.PermissionDeniedException;

public class AdministradorTests {
	
	private static GerenteDePersistencia gerente;
	private static Administrador a;
	private static Administrador root;	

	@BeforeClass
	public static void configurarTudo(){
		gerente = GerenteDePersistencia.getInstance(true);
		a = new Administrador("login1", "senha1", "nome1");
		root = new Administrador("root", "root", "Root", "true");
		gerente.removeNotRoots();
		gerente.removeAllCasos();
	}
	
	@AfterClass
	public static void zerarTudo(){
		gerente.removeAllAdministradores();
		gerente.removeAllCasos();
	}	
	
	@Test
	public void testSave(){		
		try {
			gerente.saveAdministrador(root, a);
			Administrador admin = gerente.getAdministrador(a.getLogin());
			if(admin.getLogin().equals(a.getLogin()) && admin.getPassword().equals(a.getPassword()) && admin.getNome().equals(a.getNome())){
				assertTrue(true);
			}else{
				assertTrue(false);
			}
		} catch (Exception e) {
			assertTrue(false);
		}		
		
	}
	
	@Test
	public void testUpdate(){
		a.setNome("fulaninho");
		try {
			gerente.updateAdministrador(root, a);
			Administrador admin = gerente.getAdministrador(a.getLogin());
			String adminName = admin.getNome();
			if(adminName.equals("fulaninho")){
				assertTrue(true);				
			}
		} catch (AdministradorNotFoundException e1) {
			assertTrue(false);
		} catch (PermissionDeniedException e) {
			assertTrue(false);
		}
	}

	private Caso getCaso(){
		String estado = Estado.PE.toString();
		String cidade = "cidade";
		String bairro = "bairro";
		String rua = "rua";		
		int numero = 4;
		String nome = "nome";		
		float areaConst = 1;
		float areaTotal = 2;
		int vagasGaragem = 9;		
		int quartos = 6;
		int suites = 7;
		int baneiros = 3;
		String tipo = "tipo";
		float preco = 5;
		String tipoNegocio = "tipo negocio";
		
		Caso caso = new Caso();
		caso.setAreaConstruida(areaConst);
		caso.setAreaTotal(areaTotal);
		caso.setBanheiros(baneiros);
		caso.setBairro(bairro);
		caso.setCidade(cidade);		
		caso.setEstado(estado);	
		caso.setNome(nome);		
		caso.setNumero(numero);
		caso.setPreco(preco);
		caso.setQuartos(quartos);
		caso.setRua(rua);
		caso.setSuites(suites);		
		caso.setTipo(tipo);
		caso.setTipoNegocio(tipoNegocio);
		caso.setVagasGaragem(vagasGaragem);
		caso.setLocation(new Coordinates(0, 0));
		
		return caso;
	}
	
	@Test
	public void testeCreateCaso(){		

		try {
			gerente.createCaso(a, getCaso());
			gerente.createCaso(a, getCaso());
			gerente.createCaso(a, getCaso());
			if(gerente.getAllCasos().size() == 3){
				assertTrue(true);			
			}else{
				assertTrue(false);
			}
			a = gerente.getAdministrador(a.getLogin());
			List<Caso> casos = gerente.getCasos(a.getIdAdministrador());
			if(casos.size() == 3){
				assertTrue(true);			
			}else{
				assertTrue(false);
			}
		} catch (AdministradorNotFoundException e) {
			assertTrue(false);
		}				 
	}	
	
	@Test
	public void testRemove(){
		try {
			gerente.removeAdministrador(root, a);
			assertTrue(true);
		} catch (AdministradorNotFoundException e) {
			assertTrue(false);
		} catch (PermissionDeniedException e) {
			assertTrue(false);
		}
	}
	
	
}
