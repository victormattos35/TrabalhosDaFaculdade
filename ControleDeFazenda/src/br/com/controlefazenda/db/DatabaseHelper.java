package br.com.controlefazenda.db;

import br.com.controlefazenda.constants.IFazenda;
import br.com.controlefazenda.constants.IFuncionario;
import br.com.controlefazenda.constants.IInsumo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper {

	private DBHelper helper = null;
	private SQLiteDatabase db = null;

	public DatabaseHelper(Context context) {
		helper = new DBHelper(context);
	}

	public SQLiteDatabase open() {
		return db = helper.getWritableDatabase();
	}

	public void close() {
		db.close();
	}

	public class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DatabaseConstants.DB_NAME, null, DatabaseConstants.VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			onUpgrade(db, 0, DatabaseConstants.VERSION);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			if (oldVersion + 1 > newVersion) {
				return;
			} else {
				switch (oldVersion + 1) {
					case 1:
						db.execSQL(IFazenda.CREATE_TABLE);
						db.execSQL(IInsumo.CREATE_TABLE);
						db.execSQL(IFuncionario.CREATE_TABLE);
						break;
				}

				onUpgrade(db, ++oldVersion, newVersion);
			}
		}

	}

}
