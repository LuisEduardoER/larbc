package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import persistence.util.Coordinates;


@Entity
@Table(name = "casos")
@NamedQueries( {@NamedQuery(name = "getCasosByAdmin", query = "select c from Caso c where c.idAdministradorResponsavel = :idAdministrador"),
				@NamedQuery(name = "getFotos", query = "select f from Foto f where f.myComposedKey.idCaso = :idCaso"),
				@NamedQuery(name = "getId", query = "select f from Caso f where f.estado = :estado AND f.cidade = :cidade AND " +
																						"f.bairro = :bairro AND f.rua = :rua AND " +
																						"f.numero = :numero AND f.nome = :nome AND " +
																						"f.areaConstruida = :areaConstruida AND " +
																						"f.areaTotal = :areaTotal AND " +
																						"f.vagasGaragem = :vagasGaragem AND " +
																						"f.quartos = :quartos AND f.suites = :suites AND " +
																						"f.banheiros = :banheiros AND f.tipo = :tipo AND " +
																						"f.preco = :preco AND f.tipoNegocio = :tipoNegocio")})
public class Caso{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_caso", updatable = false, nullable = false)
	private long idCaso;
	@Column(updatable = true, nullable = false)
	private String estado;
	@Column(updatable = true, nullable = false)
	private String cidade;
	@Column(updatable = true, nullable = false)
	private String bairro;
	@Column(updatable = true, nullable = false)
	private String rua;
	@Column(updatable = true, nullable = false)
	private int numero;
	@Column(updatable = true, nullable = true)
	private String nome;
	@Column(updatable = true, nullable = false)
	private float areaConstruida;
	@Column(updatable = true, nullable = false)
	private float areaTotal;
	@Column(updatable = true, nullable = false)
	private int vagasGaragem;
	@Column(updatable = true, nullable = false)
	private int quartos;
	@Column(updatable = true, nullable = false)
	private int suites;
	@Column(updatable = true, nullable = false)
	private int banheiros;
	@Column(updatable = true, nullable = false)
	private String tipo;
	@Column(updatable = true, nullable = false)
	private float preco;	
	@Column(updatable = true, nullable = false)
	private String tipoNegocio;
	@Column(updatable = true, nullable = true)
	private String observacoes;
	@Transient
	private Coordinates location;
	
	@Column(updatable = false, nullable = false)
	private long idAdministradorResponsavel;
	
	
	//construtor vazio necessario pelo hibernate
	public Caso(){}
	
	public void setIdCaso(long idCaso) {
		this.idCaso = idCaso;
	}
	public long getIdCaso() {
		return idCaso;
	}	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getAreaConstruida() {
		return areaConstruida;
	}
	public void setAreaConstruida(float areaConstruida) {
		this.areaConstruida = areaConstruida;
	}
	public float getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(float areaTotal) {
		this.areaTotal = areaTotal;
	}
	public int getVagasGaragem() {
		return vagasGaragem;
	}
	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}
	public int getQuartos() {
		return quartos;
	}
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}
	public int getSuites() {
		return suites;
	}
	public void setSuites(int suites) {
		this.suites = suites;
	}
	public int getBanheiros() {
		return banheiros;
	}
	public void setBanheiros(int bainheiros) {
		this.banheiros = bainheiros;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}	
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public void setIdAdministradorResponsavel(long idAdministradorResponsavel) {
		this.idAdministradorResponsavel = idAdministradorResponsavel;
	}

	public long getIdAdministradorResponsavel() {
		return idAdministradorResponsavel;
	}
	
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setLocation(Coordinates location) {
		this.location = location;
	}

	public Coordinates getLocation() {
		return location;
	}
	
	public String getLocationString(){
		return location.getLatitude() + " " + location.getLongitude();
	}
	
}
