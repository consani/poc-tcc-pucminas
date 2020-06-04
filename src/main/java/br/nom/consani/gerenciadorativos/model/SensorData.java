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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="sensor_data")
public class SensorData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("id_barragem")
	private String barragem;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_coleta")
	@JsonProperty("data_hora_envio")
	private Date dataColeta;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty("tipo_metrica")
	private TipoMetrica tipoMetrica;
	
	@Column(name="valor_metrica")
	@JsonProperty("valor_metrica")
	private BigDecimal valorMetrica;

	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	public SensorData() {}
	
	public SensorData(Long id, String barragem, Date dataColeta, TipoMetrica tipoMetrica, BigDecimal valorMetrica,
			BigDecimal latitude, BigDecimal longitude) {
		super();
		this.id = id;
		this.barragem = barragem;
		this.dataColeta = dataColeta;
		this.tipoMetrica = tipoMetrica;
		this.valorMetrica = valorMetrica;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getBarragem() {
		return barragem;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public TipoMetrica getTipoMetrica() {
		return tipoMetrica;
	}

	public BigDecimal getValorMetrica() {
		return valorMetrica;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barragem == null) ? 0 : barragem.hashCode());
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
		SensorData other = (SensorData) obj;
		if (barragem == null) {
			if (other.barragem != null)
				return false;
		} else if (!barragem.equals(other.barragem))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorData [id=" + id + ", barragem=" + barragem + ", dataColeta=" + dataColeta + ", tipoMetrica="
				+ tipoMetrica + ", valorMetrica=" + valorMetrica + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	
	
	
	


}
