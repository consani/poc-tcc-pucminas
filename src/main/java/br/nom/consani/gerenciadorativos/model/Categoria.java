package br.nom.consani.gerenciadorativos.model;

public enum Categoria {
	INSUMO("Insumo"), MECANISMO("Mecanismo"), EQUIPAMENTO("Equipamento"), VEICULO("Veiculo");

	private String nome;

	Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

}
