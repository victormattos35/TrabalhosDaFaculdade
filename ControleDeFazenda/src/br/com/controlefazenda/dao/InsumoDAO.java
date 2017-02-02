package br.com.controlefazenda.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.controlefazenda.constants.IInsumo;
import br.com.controlefazenda.vo.InsumoVO;

public class InsumoDAO {

	public boolean inserir(SQLiteDatabase db, InsumoVO insumo)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IInsumo.COLUMN_CODIGO, insumo.getCodigo());
		values.put(IInsumo.COLUMN_DESCRICAO, insumo.getDescricao());
		values.put(IInsumo.COLUMN_DESCRICAOABREVIADA, insumo.getDescricaoAbreviada());
		values.put(IInsumo.COLUMN_UNIDADEMEDIDA, insumo.getUnidadeMedida());
		values.put(IInsumo.COLUMN_QTDEDISPONIVEL, insumo.getQuantidadeDisponivel());
		db.insert(IInsumo.TABLE_NAME, null, values);

		return true;
	}

	public boolean alterar(SQLiteDatabase db, InsumoVO insumo)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IInsumo.COLUMN_DESCRICAO, insumo.getDescricao());
		values.put(IInsumo.COLUMN_DESCRICAOABREVIADA, insumo.getDescricaoAbreviada());
		values.put(IInsumo.COLUMN_UNIDADEMEDIDA, insumo.getUnidadeMedida());
		values.put(IInsumo.COLUMN_QTDEDISPONIVEL, insumo.getQuantidadeDisponivel());
		

		db.update(IInsumo.TABLE_NAME, values, IInsumo.COLUMN_CODIGO + "=?",
				new String[] { Long.toString(insumo.getCodigo()) });

		return true;
	}

	public boolean remover(SQLiteDatabase db, long codigo) throws Exception {
		db.delete(IInsumo.TABLE_NAME, IInsumo.COLUMN_CODIGO + "=?", new String[] { Long.toString(codigo) });

		return true;
	}

	public InsumoVO selecionar(SQLiteDatabase db, long codigo)
			throws Exception {
		InsumoVO insumo = null;

		Cursor cursor = db.query(IInsumo.TABLE_NAME, new String[] {
				IInsumo.COLUMN_DESCRICAO, IInsumo.COLUMN_DESCRICAOABREVIADA,
				IInsumo.COLUMN_UNIDADEMEDIDA, IInsumo.COLUMN_QTDEDISPONIVEL
				}, IInsumo.COLUMN_CODIGO + "=?",
				new String[] { Long.toString(codigo) }, null, null, null);

		if (cursor.moveToNext()) {
			String descricao = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_DESCRICAO));
			String descricaoAbreviada = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_DESCRICAOABREVIADA));

			String unidadeMedida = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_UNIDADEMEDIDA));

			long qtdeDisponivel = cursor.getLong(cursor
					.getColumnIndex(IInsumo.COLUMN_QTDEDISPONIVEL));


			insumo = new InsumoVO(codigo, descricao, descricaoAbreviada, unidadeMedida, qtdeDisponivel);
		}

		return insumo;
	}

	public List<InsumoVO> selecionar(SQLiteDatabase db) throws Exception {
		List<InsumoVO> insumos = new ArrayList<InsumoVO>();

		Cursor cursor = db.query(IInsumo.TABLE_NAME,
				new String[] { IInsumo.COLUMN_CODIGO, IInsumo.COLUMN_DESCRICAO, IInsumo.COLUMN_DESCRICAOABREVIADA,
				IInsumo.COLUMN_UNIDADEMEDIDA, IInsumo.COLUMN_QTDEDISPONIVEL }, null,
				null, null, null, IInsumo.COLUMN_DESCRICAO);

		while (cursor.moveToNext()) {
			Long codigo = cursor.getLong(cursor.getColumnIndex(IInsumo.COLUMN_CODIGO));
			String descricao = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_DESCRICAO));
			String descricaoAbreviada = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_DESCRICAOABREVIADA));

			String unidadeMedida = cursor.getString(cursor
					.getColumnIndex(IInsumo.COLUMN_UNIDADEMEDIDA));

			long qtdeDisponivel = cursor.getLong(cursor
					.getColumnIndex(IInsumo.COLUMN_QTDEDISPONIVEL));

			InsumoVO insumo = new InsumoVO(codigo, descricao, descricaoAbreviada, unidadeMedida, qtdeDisponivel);

			insumos.add(insumo);
		}

		return insumos;
	}

}
