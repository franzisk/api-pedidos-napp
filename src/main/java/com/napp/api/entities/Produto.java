package com.napp.api.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 16, scale = 0)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	@Column(name = "nome", length = 80)
	private String nome;

	@Column(name = "multiplo")
	private int multiplo = 0;

	@Column(name = "preco_unitario", precision = 12, scale = 2)
	private BigDecimal precoUnitario = BigDecimal.valueOf(0.0);

	public Produto() {
	}

	public Produto(long id, String nome, BigDecimal precoUnitario, int multiplo) {
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.multiplo = multiplo;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMultiplo() {
		return multiplo;
	}

	public void setMultiplo(int multiplo) {
		this.multiplo = multiplo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + "]";
	}

}
