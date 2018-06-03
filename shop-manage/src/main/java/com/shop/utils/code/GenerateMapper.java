package com.shop.utils.code;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateMapper extends BaseCode {

	public void run() throws Exception {
		CodeCommonUtil codeUtil = new CodeCommonUtil();
		
		final String suffix = "Mapper.xml";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName() + ".mapper");

		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;
		List<ColumnClass> primaryKeysList = new ArrayList<ColumnClass>();
	
		File tempFile = new File(filePath);
		ResultSet primaryKeys = codeUtil.getPrimaryKeysResultSet(this.getTableName());
		String primarykeysTypes = "";
		
		while(primaryKeys.next()) {
			ColumnClass primaryKey = new ColumnClass();
			String typeName = "";
			ResultSet resultSet = codeUtil.getResultSet(this.getTableName());
			while (resultSet.next()) {
				if(resultSet.getString("COLUMN_NAME").equals(primaryKeys.getString("COLUMN_NAME"))) {
					typeName = resultSet.getString("TYPE_NAME");
					break;
				}
			}
			primarykeysTypes += primaryKeys.getString("COLUMN_NAME") +",";
			
			primaryKey.setColumnType(typeName);
			primaryKey.setColumnName(primaryKeys.getString("COLUMN_NAME"));
			primaryKey.setChangeColumnName(CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(primaryKeys.getString("COLUMN_NAME"))));
			primaryKeysList.add(primaryKey);
		}
		
		List<ColumnClass> columnKeys = new ArrayList<ColumnClass>();
		ResultSet resultSet = codeUtil.getResultSet(this.getTableName());
		
		while (resultSet.next()) {
			boolean flag = false;
			for (ColumnClass columnClass : primaryKeysList) {
				if(columnClass.getColumnName().equals(resultSet.getString("COLUMN_NAME"))) {
					flag = true;
					break;
				}
			}
			if(flag)continue;
			primarykeysTypes += resultSet.getString("COLUMN_NAME") +",";
			ColumnClass columnKey = new ColumnClass();
			columnKey.setColumnType(resultSet.getString("TYPE_NAME"));
			columnKey.setColumnName(resultSet.getString("COLUMN_NAME"));
			columnKey.setChangeColumnName(CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME"))));
			columnKeys.add(columnKey);
		}
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("table_fix", CodeCommonUtil.TABLE_FIX);
		dataMap.put("columnKeys", columnKeys);
		dataMap.put("primaryKeys", primaryKeysList);
		dataMap.put("primarykeysTypes", primarykeysTypes = primarykeysTypes.substring(0,primarykeysTypes.lastIndexOf(",")));
		dataMap.put("table_name_small", this.getTableName());
		dataMap.put("table_name", CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()));
		dataMap.put("author", this.getAuthor());
		dataMap.put("date", this.getCurrentDate());
		dataMap.put("package_name", this.getPackageName());
		dataMap.put("table_annotation", this.getTableAnnotation());
		dataMap.put("gitHub", this.getGitHub());

		CodeCommonUtil.generateFileByTemplate(this.getTemplateName(), tempFile, dataMap);
		// 生成DTO
	}
}
