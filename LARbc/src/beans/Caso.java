package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "casos")
public class Caso {
	
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
	private int tipoNegocio;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_administrador",
	insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Administrador inseridoPor;
	
	
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
	public int getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(int tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	public void setInseridoPor(Administrador inseridoPor) {
		this.inseridoPor = inseridoPor;
	}
	public Administrador getInseridoPor() {
		return inseridoPor;
	}	
	
}
