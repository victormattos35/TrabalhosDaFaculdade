package br.com.controlefazenda.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.controlefazenda.constants.IFuncionario;
import br.com.controlefazenda.util.DateUtil;
import br.com.controlefazenda.vo.FuncionarioVO;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FuncionarioDAO {

	public boolean inserir(SQLiteDatabase db, FuncionarioVO funcionario)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IFuncionario.COLUMN_MATRICULA, funcionario.getMatricula());
		values.put(IFuncionario.COLUMN_NOME, funcionario.getNome());
		values.put(IFuncionario.COLUMN_SEXO,  funcionario.getSexo());
		values.put(IFuncionario.COLUMN_DATANASCIMENTO,DateUtil.format(
				funcionario.getDataDeNascimento()));
		db.insert(IFuncionario.TABLE_NAME, null, values);

		return true;
	}

	public boolean alterar(SQLiteDatabase db, FuncionarioVO funcionario)
			throws Exception {
		ContentValues values = new ContentValues();
		values.put(IFuncionario.COLUMN_MATRICULA, funcionario.getMatricula());
		values.put(IFuncionario.COLUMN_NOME, funcionario.getNome());
		values.put(IFuncionario.COLUMN_SEXO,  funcionario.getSexo());
		values.put(IFuncionario.COLUMN_DATANASCIMENTO,DateUtil.format(
				funcionario.getDataDeNascimento()));

		db.update(IFuncionario.TABLE_NAME, values, IFuncionario.COLUMN_MATRICULA + "=?",
				new String[] { Long.toString(funcionario.getMatricula()) });

		return true;
	}

	public boolean remover(SQLiteDatabase db, long matricula) throws Exception {
		db.delete(IFuncionario.TABLE_NAME, IFuncionario.COLUMN_MATRICULA + "=?", new String[] { Long.toString(matricula) });

		return true;
	}

	public FuncionarioVO selecionar(SQLiteDatabase db, long matricula)
			throws Exception {
		FuncionarioVO funcionario = null;

		Cursor cursor = db.query(IFuncionario.TABLE_NAME, new String[] {
				IFuncionario.COLUMN_NOME, IFuncionario.COLUMN_SEXO, IFuncionario.COLUMN_DATANASCIMENTO }, IFuncionario.COLUMN_MATRICULA + "=?",
				new String[] { Long.toString(matricula) }, null, null, null);

		if (cursor.moveToNext()) {
			String nome = cursor.getString(cursor
					.getColumnIndex(IFuncionario.COLUMN_NOME));
			String sexo = cursor.getString(cursor
					.getColumnIndex(IFuncionario.COLUMN_SEXO));

			Date dataNascimento = DateUtil.parse(cursor.getString(cursor.getColumnIndex(IFuncionario.COLUMN_DATANASCIMENTO)));

			funcionario = new FuncionarioVO(matricula, nome, sexo, dataNascimento);
		}

		return funcionario;
	}

	public List<FuncionarioVO> selecionar(SQLiteDatabase db) throws Exception {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();

		Cursor cursor = db.query(IFuncionario.TABLE_NAME,
				new String[] { IFuncionario.COLUMN_MATRICULA, IFuncionario.COLUMN_NOME,
						IFuncionario.COLUMN_SEXO, IFuncionario.COLUMN_DATANASCIMENTO}, null,
				null, null, null, IFuncionario.COLUMN_NOME);

		while (cursor.moveToNext()) {
			Long matricula = cursor.getLong(cursor.getColumnIndex(IFuncionario.COLUMN_MATRICULA));
			String nome = cursor.getString(cursor
					.getColumnIndex(IFuncionario.COLUMN_NOME));
			String sexo = cursor.getString(cursor
					.getColumnIndex(IFuncionario.COLUMN_SEXO));

			Date dataNascimento = DateUtil.parse(cursor.getString(cursor.getColumnIndex(IFuncionario.COLUMN_DATANASCIMENTO)));

			FuncionarioVO funcionario = new FuncionarioVO(matricula, nome, sexo, dataNascimento);
			
			funcionarios.add(funcionario);
		}

		return funcionarios;
	}

}
