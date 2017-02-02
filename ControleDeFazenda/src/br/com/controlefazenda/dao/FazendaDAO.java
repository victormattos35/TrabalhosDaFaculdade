package br.com.controlefazenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.controlefazenda.constants.IFazenda;
import br.com.controlefazenda.vo.FazendaVO;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FazendaDAO {

	public boolean inserir(SQLiteDatabase db, FazendaVO fazenda)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IFazenda.COLUMN_CODIGO, fazenda.getCodigo());
		values.put(IFazenda.COLUMN_DESCRICAO, fazenda.getDescricao());
		values.put(IFazenda.COLUMN_PROPRIETARIO, fazenda.getProprietario());
		values.put(IFazenda.COLUMN_QTDEAREAPRODUTIVA,
				fazenda.getQtdeAreaProdutiva());
		values.put(IFazenda.COLUMN_LATITUDE, fazenda.getLatitude());
		values.put(IFazenda.COLUMN_LONGITUDE, fazenda.getLongitude());

		db.insert(IFazenda.TABLE_NAME, null, values);

		return true;
	}

	public boolean alterar(SQLiteDatabase db, FazendaVO fazenda)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IFazenda.COLUMN_DESCRICAO, fazenda.getDescricao());
		values.put(IFazenda.COLUMN_PROPRIETARIO, fazenda.getProprietario());
		values.put(IFazenda.COLUMN_QTDEAREAPRODUTIVA,
				fazenda.getQtdeAreaProdutiva());
		values.put(IFazenda.COLUMN_LATITUDE, fazenda.getLatitude());
		values.put(IFazenda.COLUMN_LONGITUDE, fazenda.getLongitude());

		db.update(IFazenda.TABLE_NAME, values, IFazenda.COLUMN_CODIGO + "=?",
				new String[] { Long.toString(fazenda.getCodigo()) });

		return true;
	}

	public boolean remover(SQLiteDatabase db, long codigo) throws Exception {
		db.delete(IFazenda.TABLE_NAME, IFazenda.COLUMN_CODIGO + "=?", new String[] { Long.toString(codigo) });

		return true;
	}

	public FazendaVO selecionar(SQLiteDatabase db, long codigo)
			throws Exception {
		FazendaVO fazenda = null;

		Cursor cursor = db.query(IFazenda.TABLE_NAME, new String[] {
				IFazenda.COLUMN_DESCRICAO, IFazenda.COLUMN_PROPRIETARIO,
				IFazenda.COLUMN_QTDEAREAPRODUTIVA, IFazenda.COLUMN_LATITUDE,
				IFazenda.COLUMN_LONGITUDE }, IFazenda.COLUMN_CODIGO + "=?",
				new String[] { Long.toString(codigo) }, null, null, null);

		if (cursor.moveToNext()) {
			String descricao = cursor.getString(cursor
					.getColumnIndex(IFazenda.COLUMN_DESCRICAO));
			String proprietario = cursor.getString(cursor
					.getColumnIndex(IFazenda.COLUMN_PROPRIETARIO));

			long qtdeAreaProdutiva = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_QTDEAREAPRODUTIVA));

			long latitude = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_LATITUDE));

			long longitude = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_LONGITUDE));

			fazenda = new FazendaVO(codigo, descricao, proprietario, qtdeAreaProdutiva,
					latitude, longitude);
		}

		return fazenda;
	}

	public List<FazendaVO> selecionar(SQLiteDatabase db) throws Exception {
		List<FazendaVO> fazendas = new ArrayList<FazendaVO>();

		Cursor cursor = db.query(IFazenda.TABLE_NAME,
				new String[] { IFazenda.COLUMN_CODIGO, IFazenda.COLUMN_DESCRICAO,
						IFazenda.COLUMN_PROPRIETARIO, IFazenda.COLUMN_QTDEAREAPRODUTIVA,
						IFazenda.COLUMN_LATITUDE, IFazenda.COLUMN_LONGITUDE }, null,
				null, null, null, IFazenda.COLUMN_DESCRICAO);

		while (cursor.moveToNext()) {
			Long codigo = cursor.getLong(cursor.getColumnIndex(IFazenda.COLUMN_CODIGO));
			String descricao = cursor.getString(cursor
					.getColumnIndex(IFazenda.COLUMN_DESCRICAO));
			String proprietario = cursor.getString(cursor
					.getColumnIndex(IFazenda.COLUMN_PROPRIETARIO));

			long qtdeAreaProdutiva = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_QTDEAREAPRODUTIVA));

			long latitude = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_LATITUDE));

			long longitude = cursor.getLong(cursor
					.getColumnIndex(IFazenda.COLUMN_LONGITUDE));

			FazendaVO fazenda = new FazendaVO(codigo, descricao, proprietario, qtdeAreaProdutiva,
					latitude, longitude);

			fazendas.add(fazenda);
		}

		return fazendas;
	}

}
