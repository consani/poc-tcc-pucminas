package br.nom.consani.gerenciadorativos.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;



@Entity
public class Ativo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "Descrição é obrigatória!")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@NotBlank(message = "Fornecedor é obrigatório!")
	private String fornecedor;

	@NotNull(message = "Data é obrigatória!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="data_fabricacao")
	private Date dataFabricacao;

	@NotNull(message = "Valor é obrigatório!")
	@DecimalMin(value = "0.05", message = "Valor não pode ser menor que 0,05")
	@NumberFormat(pattern = "#,##0.00")
	@Column(name="valor_unitario")
	private BigDecimal valorUnitario;

	@Column(name="prazo_validade")
	private Integer prazoValidade;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getPrazoValidade() {
		return prazoValidade;
	}

	public void setPrazoValidade(Integer prazoValidade) {
		this.prazoValidade = prazoValidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Ativo other = (Ativo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ativo [codigo=" + codigo + ", descricao=" + descricao + ", categoria=" + categoria + ", fornecedor="
				+ fornecedor + ", dataFabricacao=" + dataFabricacao + ", valorUnitario=" + valorUnitario
				+ ", prazoValidade=" + prazoValidade + "]";
	}

}
