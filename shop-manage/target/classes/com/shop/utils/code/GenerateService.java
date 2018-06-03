package com.shop.utils.code;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class GenerateService extends BaseCode{

	public void run() throws Exception {
		CodeCommonUtil codeUtil = new CodeCommonUtil();
		final String suffix = "Service.java";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName() + ".service");

		final String filePath = packagepath + "/" + "I"+CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;
	
		File tempFile = new File(filePath);
		ResultSet primaryKeys = codeUtil.getPrimaryKeysResultSet(this.getTableName());
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
			primarykeysTypes+=CodeCommonUtil.getJavaType(typeName)+" "+CodeCommonUtil.lowerFirst(CodeCommonUtil.replaceUnderLineAndUpperCase(primaryKeys.getString("COLUMN_NAME")))
			+",";
		}
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("primarykeysTypes", primarykeysTypes = primarykeysTypes.substring(0,primarykeysTypes.lastIndexOf(",")));
		dataMap.put("table_name_small", this.getTableName());
		dataMap.put("table_name", CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()));
		dataMap.put("author", this.getAuthor());
		dataMap.put("date", this.getCurrentDate());
		dataMap.put("package_name", this.getPackageName());
		dataMap.put("package_last_name", this.getPackageLastName());
		dataMap.put("table_annotation", this.getTableAnnotation());
		dataMap.put("gitHub", this.getGitHub());

		CodeCommonUtil.generateFileByTemplate(this.getTemplateName(), tempFile, dataMap);
		
	}
}
