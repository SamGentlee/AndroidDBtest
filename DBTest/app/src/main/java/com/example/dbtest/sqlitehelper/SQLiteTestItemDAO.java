package com.example.dbtest.sqlitehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteTestItemDAO {
	public static class ItemColumn {
		public static final String TABLE_NAME = "TEST_ITEM_TB";
		public static final String _ID = "_id";
		public static final String ITEM_ID = "ITEM_ID";
		public static final String ITEM_CD = "ITEM_CD";
		public static final String ITEM_VALUE = "ITEM_VALUE";
		public static final String REG_DATE = "REG_DATE";
		public static final String UPD_DATE = "UPD_DATE";
	}

	public static final String SQL_CREATE_TABLE =
			"CREATE TABLE " + ItemColumn.TABLE_NAME + " (" +
					ItemColumn._ID + " INTEGER PRIMARY KEY, " +
					ItemColumn.ITEM_ID + " TEXT UNIQUE NOT NULL, " +
					ItemColumn.ITEM_CD + " TEXT, " +
					ItemColumn.ITEM_VALUE + " TEXT, " +
					ItemColumn.REG_DATE + " TEXT NOT NULL, " +
					ItemColumn.UPD_DATE + " TEXT )";

	public static final String SQL_DROP_TABLE =
			"DROP TABLE IF EXISTS " + ItemColumn.TABLE_NAME;

	public void selectAll(Context context) {
		SQLiteHelper db = SQLiteHelper.getInstance(context);
		db.select(ItemColumn.TABLE_NAME);
	}

	public void insertItem(Context context, SQLiteTestItem item) {
		SQLiteHelper db = SQLiteHelper.getInstance(context);
		ContentValues values = new ContentValues();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		values.put(ItemColumn.ITEM_ID, item.get_itemId());
		values.put(ItemColumn.ITEM_CD, item.itemCd);
		values.put(ItemColumn.ITEM_VALUE, item.itemValue);
		values.put(ItemColumn.REG_DATE, df.format(new Date()));
		values.put(ItemColumn.UPD_DATE, df.format(new Date()));
		db.insert(ItemColumn.TABLE_NAME, values);
	}

	public void updateItem(Context context, SQLiteTestItem item) {
		SQLiteHelper db = SQLiteHelper.getInstance(context);
		ContentValues values = new ContentValues();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		values.put(ItemColumn.ITEM_CD, item.itemCd);
		values.put(ItemColumn.ITEM_VALUE, item.itemValue);
		values.put(ItemColumn.UPD_DATE, df.format(new Date()));
		String whereString = ItemColumn.ITEM_ID + " = ?";
		db.update(ItemColumn.TABLE_NAME, values, whereString, new String[]{item.get_itemId()});
	}

	public void deleteItem(Context context, SQLiteTestItem item) {
		SQLiteHelper db = SQLiteHelper.getInstance(context);
		String whereString = ItemColumn.ITEM_ID + " = ?";
		db.delete(ItemColumn.TABLE_NAME, whereString, new String[]{item.get_itemId()});
	}
}
