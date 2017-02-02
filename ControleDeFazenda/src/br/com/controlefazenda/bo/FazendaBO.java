package br.com.controlefazenda.bo;

import java.util.List;

import br.com.controlefazenda.dao.FazendaDAO;
import br.com.controlefazenda.db.DatabaseHelper;
import br.com.controlefazenda.vo.FazendaVO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class FazendaBO {

	private static FazendaBO instance = null;

	private FazendaDAO dao = null;

	private FazendaBO() {
		dao = new FazendaDAO();
	}

	public static FazendaBO getInstance() {
		if (instance == null) {
			instance = new FazendaBO();
		}
		return instance;
	}

	public List<FazendaVO> selecionarTodos(Context context) throws Exception {
		List<FazendaVO> fazendas = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			fazendas = dao.selecionar(db);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return fazendas;
	}

	public FazendaVO selecionar(Context context, long codigo) throws Exception {
		FazendaVO fazenda = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			fazenda = dao.selecionar(db, codigo);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return fazenda;
	}

	public boolean inserir(Context context, FazendaVO fazenda) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.inserir(db, fazenda);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}

	public boolean alterar(Context context, FazendaVO fazenda) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.alterar(db, fazenda);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}

	public boolean remover(Context context, long codigo) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.remover(db, codigo);

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
