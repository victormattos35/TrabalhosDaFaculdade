package br.com.redecliente.domain;


public class Rede {
	private Long codigo;

	private String nome;

	private Long idade;

	private String dataInsercao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(String dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

}
