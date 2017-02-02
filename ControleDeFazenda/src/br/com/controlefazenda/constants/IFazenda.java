package br.com.controlefazenda.constants;

public interface IFazenda {

	public static final String TABLE_NAME = "FAZENDA";

	public static final String COLUMN_CODIGO = "CODIGO_FAZENDA";
	public static final String COLUMN_DESCRICAO = "DESCRICAO_FAZENDA";
	public static final String COLUMN_PROPRIETARIO = "PROPRIETARIO_FAZENDA";
	public static final String COLUMN_QTDEAREAPRODUTIVA= "QTDEAREAPRODUTIVA_FAZENDA";
	public static final String COLUMN_LATITUDE = "LATITUDE_FAZENDA";
	public static final String COLUMN_LONGITUDE = "LONGITUDE_FAZENDA";

	public static final String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] " + 
			"( [" + COLUMN_CODIGO + "] NUMERIC NULL PRIMARY KEY, " + 
			"[" + COLUMN_DESCRICAO + "] VARCHAR(100) UNIQUE NOT NULL, " + 
			"[" + COLUMN_PROPRIETARIO + "] VARCHAR(50) NULL, " + 
			"[" + COLUMN_QTDEAREAPRODUTIVA + "] NUMERIC NULL, " + 
			"[" + COLUMN_LATITUDE + "] NUMERIC NULL, " + 
			"[" + COLUMN_LONGITUDE + "] NUMERIC NULL) ";

	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
