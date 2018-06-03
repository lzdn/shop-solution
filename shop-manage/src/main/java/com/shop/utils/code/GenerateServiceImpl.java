package com.shop.utils.code;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateServiceImpl extends BaseCode{

	public void run() throws Exception {
		CodeCommonUtil codeUtil = new CodeCommonUtil();
		
		final String suffix = "ServiceImpl.java";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName() + ".service.impl");

		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;
	
		File tempFile = new File(filePath);
		ResultSet primaryKeys = codeUtil.getPrimaryKeysResultSet(this.getTableName());
		String primarykeysTypes = "";
		String variableKeys = "";
		while(primaryKeys.next()) {
			String typeName = "";
			ResultSet resultSet = codeUtil.getResultSet(this.getTableName());
			while (resultSet.next()) {
				if(resultSet.getString("COLUMN_NAME").equals(primaryKeys.getString("COLUMN_NAME"))) {
					typeName = resultSet.getString("TYPE_NAME").toLowerCase();
					break;
				}
			}
			primarykeysTypes+=CodeCommonUtil.getJavaType(typeName)+" "+CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(primaryKeys.getString("COLUMN_NAME")))
			+",";
			variableKeys+=CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(primaryKeys.getString("COLUMN_NAME")))+",";
		}
		
		
		List<ColumnClass> columnKeys = new ArrayList<ColumnClass>();
		ResultSet resultSet = codeUtil.getResultSet(this.getTableName());
		
		while (resultSet.next()) {
			ColumnClass columnKey = new ColumnClass();
			columnKey.setColumnType(resultSet.getString("TYPE_NAME"));
			columnKey.setColumnName(resultSet.getString("COLUMN_NAME"));
			columnKey.setChangeColumnName(CodeCommonUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
			columnKeys.add(columnKey);
		}
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("columnKeys", columnKeys);
		dataMap.put("primarykeysTypes", primarykeysTypes = primarykeysTypes.substring(0,primarykeysTypes.lastIndexOf(",")));
		dataMap.put("variableKeys", variableKeys = variableKeys.substring(0,variableKeys.lastIndexOf(",")));
		dataMap.put("table_name_small", this.getTableName());
		dataMap.put("table_name", CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()));
		dataMap.put("author", this.getAuthor());
		dataMap.put("date", this.getCurrentDate());
		dataMap.put("package_name", this.getPackageName());
		dataMap.put("table_annotation", this.getTableAnnotation());
		dataMap.put("gitHub", this.getGitHub());

		CodeCommonUtil.generateFileByTemplate(this.getTemplateName(), tempFile, dataMap);
		
	}
}
