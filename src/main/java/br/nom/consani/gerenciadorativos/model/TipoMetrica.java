package br.nom.consani.gerenciadorativos.model;

public enum TipoMetrica {
	
	DH("Deslocamento Horizontal"), DV("Deslocamento Vertical"), T("Temperatura"), P("Pressão"), U("Umidade");

	private String nome;

	TipoMetrica(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

}
