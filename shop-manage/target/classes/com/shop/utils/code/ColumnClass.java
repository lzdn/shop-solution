package com.shop.utils.code;


/**
 * 
 * @author zhanglin
 *
 */
public class ColumnClass {

	/** 数据库字段名称 **/
	private String columnName;
	/** 数据库字段类型 **/
	private String columnType;
	/** 数据库字段首字母小写且去掉下划线字符串 **/
	private String changeColumnName;
	/** 数据库字段注释 **/
	private String columnComment;

	private String primarykeysTypes;

	/** 字段是否允许为空 **/
	private boolean columnNotNull = false;

	//private List<ColumnClass> primaryKeys;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getChangeColumnName() {
		return changeColumnName;
	}

	public void setChangeColumnName(String changeColumnName) {
		this.changeColumnName = changeColumnName;
	}

	public boolean isColumnNotNull() {
		return columnNotNull;
	}

	public void setColumnNotNull(boolean columnNotNull) {
		this.columnNotNull = columnNotNull;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getPrimarykeysTypes() {
		return primarykeysTypes;
	}

	public void setPrimarykeysTypes(String primarykeysTypes) {
		this.primarykeysTypes = primarykeysTypes;
	}

/*	public List<ColumnClass> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<ColumnClass> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
*/
}
