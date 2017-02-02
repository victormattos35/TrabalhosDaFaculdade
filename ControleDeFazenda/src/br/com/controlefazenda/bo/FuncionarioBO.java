package br.com.controlefazenda.bo;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.controlefazenda.dao.FuncionarioDAO;
import br.com.controlefazenda.db.DatabaseHelper;
import br.com.controlefazenda.vo.FuncionarioVO;

public class FuncionarioBO {

	private static FuncionarioBO instance = null;

	private FuncionarioDAO dao = null;

	private FuncionarioBO() {
		dao = new FuncionarioDAO();
	}

	public static FuncionarioBO getInstance() {
		if (instance == null) {
			instance = new FuncionarioBO();
		}
		return instance;
	}

	public List<FuncionarioVO> selecionarTodos(Context context) throws Exception {
		List<FuncionarioVO> funcionarios = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			funcionarios = dao.selecionar(db);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return funcionarios;
	}

	public FuncionarioVO selecionar(Context context, long matricula) throws Exception {
		FuncionarioVO funcionario = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			funcionario = dao.selecionar(db, matricula);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return funcionario;
	}

	public boolean inserir(Context context, FuncionarioVO funcionario) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.inserir(db, funcionario);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}

	public boolean alterar(Context context, FuncionarioVO funcionario) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.alterar(db, funcionario);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}

	public boolean remover(Context context, long matricula) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.remover(db, matricula);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}
}
