package br.com.controlefazenda.vo;

import java.io.Serializable;
import java.util.Date;

public class FuncionarioVO implements Serializable {

	private static final long serialVersionUID = 3202832652917698246L;

	private long matricula;
	private String nome;
	private String sexo;
	private Date dataDeNascimento;

	public FuncionarioVO() {
		super();
	}

	public FuncionarioVO(long matricula, String nome, String sexo,
			Date dataDeNascimento) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	@Override
	public String toString() {
		return nome;
	}
}