package com.shop.utils.code;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GenerateAction extends BaseCode {

	public void run() throws Exception {
		final String suffix = "Controller.java";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName() + ".controller");

		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;

		File tempFile = new File(filePath);
		 
		
		Map<String, Object> dataMap = new HashMap<>();
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
