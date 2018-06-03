package com.shop.utils.code;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成entity和dto
 * 
 * @author zhanglin
 *
 */
public class GenerateDomain extends BaseCode {

	public void run(ResultSet resultSet) throws Exception {

		final String suffix = ".java";

		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName()+".domain");

		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName())
				+ suffix;

		File tempFile = new File(filePath);
		List<ColumnClass> columnClassList = new ArrayList<>();
		ColumnClass columnClass = null;
		while (resultSet.next()) {
			columnClass = new ColumnClass();
			// 获取字段名称
			columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
			// 获取字段类型
			columnClass.setColumnType(resultSet.getString("TYPE_NAME").toLowerCase());
			// 转换字段名称，如 sys_name 变成 SysName
			columnClass.setChangeColumnName(
					CodeCommonUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
			// NULLABLE 是否可以为空
			columnClass.setColumnNotNull(resultSet.getInt("NULLABLE") == 1 ? false : true);
			// 字段在数据库的注释
			columnClass.setColumnComment(resultSet.getString("REMARKS"));
			columnClassList.add(columnClass);
		}
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("model_column", columnClassList);
		dataMap.put("table_name_small", this.getTableName());
		dataMap.put("table_name", CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()));
		dataMap.put("author", this.getAuthor());
		dataMap.put("date",  this.getCurrentDate());
		dataMap.put("package_name", this.getPackageName());
		dataMap.put("table_annotation", this.getTableAnnotation());
		dataMap.put("gitHub", this.getGitHub());
		
		CodeCommonUtil.generateFileByTemplate(this.getTemplateName(), tempFile, dataMap);
		
		//生成DTO
		generateDomainDto(dataMap);
	}
	
	/**
	 * 生成DTO
	 * @throws Exception 
	 */
	public  void generateDomainDto(Map<String, Object> dataMap) throws Exception {
		final String suffix = "DTO.java";
		final String templateName = this.getTemplateName().substring(0,this.getTemplateName().lastIndexOf("."))+"_"+"DTO.ftl";
		String packagepath = CodeCommonUtil.packageNameToLocalPath(false,this.getPackageName()+".dto");
		final String filePath = packagepath + "/" + CodeCommonUtil.replaceUnderLineAndUpperCase(this.getTableName()) + suffix;
		File dtoFile = new File(filePath);
		CodeCommonUtil.generateFileByTemplate(templateName, dtoFile, dataMap);
	}
}
