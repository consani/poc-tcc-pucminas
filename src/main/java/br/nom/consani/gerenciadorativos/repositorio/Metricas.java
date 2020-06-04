package br.nom.consani.gerenciadorativos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.nom.consani.gerenciadorativos.model.SensorData;

public interface Metricas extends JpaRepository<SensorData,Long>{
	
}
