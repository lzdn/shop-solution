package com.shop.utils.code;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class GenerateDao extends BaseCode {

	public void run() throws Exception {
		CodeCommonUtil codeUtil = new CodeCommonUtil();
		final String suffix = "Dao.java";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName() + ".dao");

		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;

		File tempFile = new File(filePath);
		ResultSet primaryKeys = codeUtil.getPrimaryKeysResultSet(this.getTableName()); //databaseMetaData.getPrimaryKeys(null, null, this.getTableName());
		String primarykeysTypes = "";
		while(primaryKeys.next()) {
			String typeName = "";
			ResultSet resultSet = codeUtil.getResultSet(this.getTableName());
			while (resultSet.next()) {
				if(resultSet.getString("COLUMN_NAME").equals(primaryKeys.getString("COLUMN_NAME"))) {
					typeName = resultSet.getString("TYPE_NAME").toLowerCase();
					break;
				}
			}
			primarykeysTypes=primarykeysTypes+CodeCommonUtil.getJavaType(typeName)+" "+CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(primaryKeys.getString("COLUMN_NAME")))
					+",";
		}
		primarykeysTypes = primarykeysTypes.substring(0,primarykeysTypes.lastIndexOf(","));
		
	
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("primarykeysTypes", primarykeysTypes);
		dataMap.put("table_name_small", this.getTableName());
		dataMap.put("table_name", CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()));
		dataMap.put("author", this.getAuthor());
		dataMap.put("date", this.getCurrentDate());
		dataMap.put("package_name", this.getPackageName());
		dataMap.put("package_last_name", this.getPackageLastName());
		dataMap.put("table_annotation", this.getTableAnnotation());
		dataMap.put("gitHub", this.getGitHub());

		CodeCommonUtil.generateFileByTemplate(this.getTemplateName(), tempFile, dataMap);
		// 生成DTO
	}
}
