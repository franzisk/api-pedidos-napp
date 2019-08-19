package com.napp.api.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.napp.api.serializer.MoedaDeserializer;
import com.napp.api.serializer.MoedaSerializer;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 16, scale = 0)
	private Long id;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "pedido_itens", joinColumns = { @JoinColumn(name = "id_pedido") }, inverseJoinColumns = { @JoinColumn(name = "id_item_pedido") })
	private List<ItemPedido> itens = new ArrayList<>();

	@Transient
	@JsonSerialize(using = MoedaSerializer.class)
	@JsonDeserialize(using = MoedaDeserializer.class)
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public BigDecimal getValorTotal() {
		valorTotal = BigDecimal.ZERO;
		if (!this.itens.isEmpty()) {
			itens.forEach(item -> {
				this.valorTotal = new BigDecimal(this.valorTotal.doubleValue() + (item.getPrecoUnitario().doubleValue() * item.getQuantidade()));
			});
		}
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + "]";
	}

}
