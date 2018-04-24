package br.com.loja.jdbc.modelo;

public class Produto {
	
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}

	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return String.format("[Produto: %d %s %s]", id, nome, descricao );
	}
	
}
