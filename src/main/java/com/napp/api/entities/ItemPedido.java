package com.napp.api.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 16, scale = 0)
	private Long id;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@Column(name = "quantidade")
	private int quantidade = 0;

	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal precoUnitario;

	@Column(name = "valor_total", precision = 12, scale = 2)
	private BigDecimal valorTotal = BigDecimal.valueOf(0.0);

	// 0 = ruim
	// 1 = boa
	// 2 = otima
	@Column(name = "rentabilidade", nullable = false, columnDefinition = "SMALLINT", length = 1)
	private int rentabilidade = 0;

	@PostPersist
	public void onPrePersist() {
		// this.valorTotal = new BigDecimal(this.valorTotal.doubleValue() * this.quantidade);
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(int rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((precoUnitario == null) ? 0 : precoUnitario.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (precoUnitario == null) {
			if (other.precoUnitario != null)
				return false;
		} else if (!precoUnitario.equals(other.precoUnitario))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [produto=" + produto + ", valorTotal=" + valorTotal + "]";
	}

}
