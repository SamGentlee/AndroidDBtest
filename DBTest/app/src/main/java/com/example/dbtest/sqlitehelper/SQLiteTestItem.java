package com.example.dbtest.sqlitehelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteTestItem {
	private String __id;
	private String _itemId;
	private String _regDate;
	private String _updDate;
	public String itemCd;
	public String itemValue;

	// 생성자: itemId, itemCd, itemValue를 받아와서 해당 값을 초기화
	public SQLiteTestItem(String itemId, String itemCd, String itemValue) {
		_itemId = itemId;
		this.itemCd = itemCd;
		this.itemValue = itemValue;
	}

	// 생성자: _id, _itemId, itemCd, itemValue, _regDate, _updDate를 받아와서 해당 값을 초기화
	public SQLiteTestItem(String _id, String _itemId, String itemCd, String itemValue, String _regDate, String _updDate) {
		__id = _id;
		this._itemId = _itemId;
		this.itemCd = itemCd;
		this.itemValue = itemValue;
		this._regDate = _regDate;
		this._updDate = _updDate;
	}

	// 읽기 전용 프로퍼티로 _id를 가져오는 메서드
	public String get__id() {
		return __id;
	}

	// 읽기 전용 프로퍼티로 itemId를 가져오는 메서드
	public String get_itemId() {
		return _itemId;
	}

	// 읽기 전용 프로퍼티로 regDate를 가져오는 메서드
	public String get_regDate() {
		return _regDate;
	}

	// 읽기 전용 프로퍼티로 updDate를 가져오는 메서드
	public String get_updDate() {
		return _updDate;
	}
}
