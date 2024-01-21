package com.example.dbtest.sqlitehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "OnlySQLite.db";
	private static final int DB_VERSION = 1;
	private static SQLiteHelper instance;

	private SQLiteHelper(Context context){
		super(context, DB_NAME, null, DB_VERSION);
	}

	public static synchronized SQLiteHelper getInstance(Context context){
		if(instance == null){
			instance = new SQLiteHelper(context);
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 테이블 생성 등의 초기화 작업 수행
		db.execSQL(SQLiteTestItemDAO.SQL_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 업그레이드 로직을 수행 (필요한 경우)
	}
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 다운그레이드 로직을 수행 (필요한 경우)
	}

	public Cursor select(String tableName, String[] projection, String selection,
						 String[] selectionArg, String groupBy, String groupByArg, String sortOrder) {
		SQLiteDatabase db = getReadableDatabase();
		return db.query(tableName, projection, selection, selectionArg, groupBy, groupByArg, sortOrder);
	}
	public Cursor select(String tableName) {
		SQLiteDatabase db = getReadableDatabase();
		return db.query(tableName,null,null,null,null,null,null);
	}

	public boolean insert(String tableName, ContentValues values) {
		SQLiteDatabase db = getWritableDatabase();
		return db.insert(tableName, null, values) != -1;
	}

	public void update(String tableName, ContentValues values, String whereOption, String[] whereArg) {
		SQLiteDatabase db = getWritableDatabase();
		db.update(tableName, values, whereOption, whereArg);
	}

	public void delete(String tableName, String whereOption, String[] whereArg) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(tableName, whereOption, whereArg);
	}

}
