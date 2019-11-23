package br.com.didata.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@NotEmpty
	@Column(length = 2, nullable = false)
	private String unidade;
	
	@Column(precision = 10, scale = 2, nullable = false)
	@DecimalMin("0")
	private BigDecimal preco;
	
	@Column(precision = 8, scale = 3, nullable = false)
	@DecimalMin("0")
	private Double qtdEstoque;
	
	@ManyToOne(optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "fornecedor_id", referencedColumnName="id")
	private Fornecedor fornecedor = new Fornecedor();
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Double getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
