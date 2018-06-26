package com.shop.utils.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import freemarker.template.Template;

public class CodeCommonUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/productdb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "root123";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DISKPATH = "D://autoJavaCode";
	public static final String TABLE_FIX = "t_";
	
	public static void main(String args[]) {
		packageNameToLocalPath(true, "D://javacode", "com.shop.domain.manage.entity");
	}

	public Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}

	public Connection getConnection(String driver, String url, String user, String password) throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public ResultSet getResultSet(String tableName) throws Exception {
		Connection connection = getConnection();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getColumns(null, "%", TABLE_FIX+tableName, "%");
		return resultSet;
	}
	
	public ResultSet getPrimaryKeysResultSet(String tableName) throws Exception {
		Connection connection = getConnection();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getPrimaryKeys(null, null, TABLE_FIX+tableName);
		return resultSet;
	}

	public DatabaseMetaData getDatabaseMetaData() throws Exception {
		Connection connection = getConnection();
		return connection.getMetaData();
	}

	public static void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap)
			throws Exception {
		Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
		FileOutputStream fos = new FileOutputStream(file);
		Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
		template.process(dataMap, out);
	}

	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/***
	 * 删除文件夹
	 * 
	 * @param folderPath文件夹完整绝对路径
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将包名转换成路径并创建文件夹
	 */
	public static String packageNameToLocalPath(boolean isDel, String diskPath, String packageName) {
		File file = new File(diskPath);
		if (file.exists() && isDel) {
			delFolder(diskPath);
		}
		file.mkdirs();// 重新创建
		String[] pkg = packageName.split("\\.");
		String currentPath = diskPath;
		for (String name : pkg) {
			currentPath = currentPath + "/" + name;
			File temp = new File(currentPath);
			temp.mkdirs();
		}

		return currentPath;
	}

	/**
	 * 将包名转换成路径并创建文件夹
	 */
	public static String packageNameToLocalPath(boolean flag,String packageName) {
		return packageNameToLocalPath(flag, DISKPATH, packageName);
	}

	/**
	 * 驼峰
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceUnderLineAndUpperCase(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		int count = sb.indexOf("_");
		while (count != 0) {
			int num = sb.indexOf("_", count);
			count = num + 1;
			if (num != -1) {
				char ss = sb.charAt(count);
				char ia = (char) (ss - 32);
				sb.replace(count, count + 1, ia + "");
			}
		}
		String result = sb.toString().replaceAll("_", "");
		return StringUtils.capitalize(result);
	}
	
	public static String lowerFirst(String word) {
		char[] chars = word.toCharArray();
		chars[0] +=32;
		return String.valueOf(chars);
	}

	public static String getJavaType(String columnType) {

		if ("int".equals(columnType) || "integer".equals(columnType)) {
			return "Integer";
		}
		if ("bigint".equals(columnType) ) {
			return "Long";
		}
		if( "decimal".equals(columnType)) {
			return "BigDecimal";
		}
		if ("double".equals(columnType)) {
			return "Double";
		}
		if ("datetime".equals(columnType) || "date".equals(columnType)) {
			return "Date";
		}
		if ("tinyint".equals(columnType)) {
			return "Byte";
		}
		if ("longblob".equals(columnType) || "blob".equals(columnType)) {
			return "byte[]";
		}
		if ("smallint".equals(columnType)) {
			return "Short";
		}
		if ("float".equals(columnType)) {
			return "Float";
		}
		if ("varchar".equals(columnType) || "text".equals(columnType) || "longtext".equals(columnType)
				|| "char".equals(columnType) || "enum".equals(columnType)) {
			return "String";
		}
		return "";
	}

}
