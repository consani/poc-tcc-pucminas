package br.nom.consani.gerenciadorativos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.nom.consani.gerenciadorativos.model.Ativo;

public interface Ativos extends JpaRepository<Ativo,Long>{
	
	//comentario
	public List<Ativo> findByDescricaoContainingIgnoreCase(String descricao);
}
