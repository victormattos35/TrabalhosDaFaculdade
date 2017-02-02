package br.com.controlefazenda.constants;

public interface IFuncionario {

	public static final String TABLE_NAME = "FUNCIONARIO";

	public static final String COLUMN_MATRICULA = "CODIGO_FUNCIONARIO";
	public static final String COLUMN_NOME = "NOME_FUNCIONARIO";
	public static final String COLUMN_SEXO = "SEXO_FUNCIONARIO";
	public static final String COLUMN_DATANASCIMENTO= "DATANASCIMENTO_FUNCIONARIO";
	
	public static final String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] " + 
			"( [" + COLUMN_MATRICULA + "] NUMERIC NULL PRIMARY KEY, " + 
			"[" + COLUMN_NOME + "] VARCHAR(100) UNIQUE NOT NULL, " + 
			"[" + COLUMN_SEXO + "] VARCHAR(10) NULL, " + 
			"[" + COLUMN_DATANASCIMENTO + "] DATE NULL) ";

	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
