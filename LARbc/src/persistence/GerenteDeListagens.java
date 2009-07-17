package persistence;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeListagens {
	
	private List<String> bairros;
	private List<String> estados;
	
	public GerenteDeListagens(){
		this.bairros = defineBairrosList();
		this.estados = defineEstadosList();
	}

	private List<String> defineEstadosList() {
		List<String> estados = new ArrayList<String>();
		estados.add("AC");
		estados.add("AL");
		estados.add("AM");
		estados.add("AP");
		estados.add("BA");
		estados.add("CE");
		estados.add("DF");
		estados.add("ES");
		estados.add("GO");
		estados.add("MA");
		estados.add("MG");
		estados.add("MS");
		estados.add("MT");
		estados.add("PA");
		estados.add("PB");
		estados.add("PE");
		estados.add("PI");
		estados.add("PR");
		estados.add("RJ");
		estados.add("RN");
		estados.add("RS");
		estados.add("RO");
		estados.add("RR");
		estados.add("SC");
		estados.add("SE");
		estados.add("TO");
		return estados;
	}

	private List<String> defineBairrosList() {
		List<String> bairros = new ArrayList<String>();
		bairros.add("Ac�cio Figueiredo");
		bairros.add("Alto Branco");
		bairros.add("Arax�");
		bairros.add("Bela Vista");
		bairros.add("Bodocong�");
		bairros.add("Castelo Branco");
		bairros.add("Catol�");
		bairros.add("Centro");
		bairros.add("Colina das Mans�es");
		bairros.add("Concei��o");
		bairros.add("Continental");
		bairros.add("Cruzeiro");
		bairros.add("Dinam�rica");
		bairros.add("Distrito Industrial");
		bairros.add("Esta��o Velha");
		bairros.add("Itarar�");
		bairros.add("Jardim Paulistano");
		bairros.add("Jardim Tavares");
		bairros.add("Jeremias");
		bairros.add("Jos� Pinheiro");
		bairros.add("Lauritzen");
		bairros.add("Liberdade");
		bairros.add("Louzeiro");
		bairros.add("Mirante");
		bairros.add("Monte Castelo");
		bairros.add("Monte Santo");
		bairros.add("Novo Mundo");
		bairros.add("Pass�rgada");
		bairros.add("Pedregal");
		bairros.add("Quarenta");
		bairros.add("Sandra Cavalcante");
		bairros.add("Santa Cruz");
		bairros.add("Santa Rosa");
		bairros.add("Santo Ant�nio");
		bairros.add("S�o Jos�");
		bairros.add("Tambor");
		bairros.add("Tr�s Irm�s");
		bairros.add("Vila Cabral");
		bairros.add("Outro");
		return bairros;
	}

	public List<String> getBairros() {
		return this.bairros;
	}

	public List<String> getEstados() {
		return this.estados;
	}

}
