package br.com.controlefazenda.constants;

public class IInsumo {
	public static final String TABLE_NAME = "INSUMO";

	public static final String COLUMN_CODIGO = "CODIGO_INSUMO";
	public static final String COLUMN_DESCRICAO = "DESCRICAO_INSUMO";
	public static final String COLUMN_DESCRICAOABREVIADA = "DESCRICAOABREVIADA_INSUMO";
	public static final String COLUMN_UNIDADEMEDIDA  = "UNIDADEMEDIDA_INSUMO";
	public static final String COLUMN_QTDEDISPONIVEL  = "QTDEDISPONIVEL_INSUMO";
	
	public static final String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] " + 
			"( [" + COLUMN_CODIGO + "] NUMERIC NULL PRIMARY KEY, " + 
			"[" + COLUMN_DESCRICAO + "] VARCHAR(100) UNIQUE NOT NULL, " + 
			"[" + COLUMN_DESCRICAOABREVIADA + "] VARCHAR(10) NULL, " + 
			"[" + COLUMN_UNIDADEMEDIDA + "] VARCHAR(10) NULL, " + 
			"[" + COLUMN_QTDEDISPONIVEL + "] NUMERIC NULL) ";

	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
