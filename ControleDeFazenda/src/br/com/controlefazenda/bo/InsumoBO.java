package br.com.controlefazenda.bo;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.controlefazenda.dao.InsumoDAO;
import br.com.controlefazenda.db.DatabaseHelper;
import br.com.controlefazenda.vo.InsumoVO;

public class InsumoBO {

	private static InsumoBO instance = null;

	private InsumoDAO dao = null;

	private InsumoBO() {
		dao = new InsumoDAO();
	}

	public static InsumoBO getInstance() {
		if (instance == null) {
			instance = new InsumoBO();
		}
		return instance;
	}

	public List<InsumoVO> selecionarTodos(Context context) throws Exception {
		List<InsumoVO> insumos = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			insumos = dao.selecionar(db);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return insumos;
	}

	public InsumoVO selecionar(Context context, long codigo) throws Exception {
		InsumoVO insumo = null;

		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			insumo = dao.selecionar(db, codigo);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return insumo;
	}

	public boolean inserir(Context context, InsumoVO insumo) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.inserir(db, insumo);

			db.setTransactionSuccessful();
		} catch (Exception e) {
			throw e;
		} finally {
			db.endTransaction();

			helper.close();
		}

		return true;
	}

	public boolean alterar(Context context, InsumoVO insumo) throws Exception {
		DatabaseHelper helper = new DatabaseHelper(context);

		SQLiteDatabase db = helper.open();

		try {
			db.beginTransaction();

			dao.alterar(db, insumo);

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
