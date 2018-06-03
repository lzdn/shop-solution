package com.shop.utils.code;

public class GeneratorCodeMain {

	public static void main(String[] args) throws Exception {
		
		String[] tables = new String[] {"dept","dict","job_log","module","resource","role","user"};
		String[] annotation = new String[] {"部门","系统字典","定时任务日志","系统模块","系统资源","角色","用户"};
		for (int i = 0;i<tables.length;i++) {

			GenerateDomain domain = new GenerateDomain();
			domain.setAuthor("张林");
			domain.setCurrentDate("20180602");
			domain.setPackageName("com.shop.manage");
			domain.setTableAnnotation(annotation[i]);
			domain.setTableName(tables[i]);
			domain.setGitHub("https://github.com/lzdn");
			domain.setTemplateName("Domain.ftl");
			CodeCommonUtil util = new CodeCommonUtil();
			domain.run(util.getResultSet(domain.getTableName()));
			
			
			GenerateDao dao = new GenerateDao();
			dao.setAuthor("张林");
			dao.setCurrentDate("20180602");
			dao.setPackageName("com.shop.manage");
			dao.setTableAnnotation(annotation[i]);
			dao.setTableName(tables[i]);
			dao.setGitHub("https://github.com/lzdn");
			dao.setTemplateName("Dao.ftl");
			dao.run();
			
			GenerateMapper mapper = new GenerateMapper();
			mapper.setAuthor("张林");
			mapper.setCurrentDate("20180602");
			mapper.setPackageName("com.shop.manage");
			mapper.setTableAnnotation(annotation[i]);
			mapper.setTableName(tables[i]);
			mapper.setGitHub("https://github.com/lzdn");
			mapper.setTemplateName("Mapper.ftl");
			mapper.run();
			
			GenerateService service = new GenerateService();
			service.setAuthor("张林");
			service.setCurrentDate("20180602");
			service.setPackageName("com.shop.manage");
			service.setTableAnnotation(annotation[i]);
			service.setTableName(tables[i]);
			service.setGitHub("https://github.com/lzdn");
			service.setTemplateName("Service.ftl");
			service.run();
			
			
			GenerateServiceImpl serviceImpl = new GenerateServiceImpl();
			serviceImpl.setAuthor("张林");
			serviceImpl.setCurrentDate("20180602");
			serviceImpl.setPackageName("com.shop.manage");
			serviceImpl.setTableAnnotation(annotation[i]);
			serviceImpl.setTableName(tables[i]);
			serviceImpl.setGitHub("https://github.com/lzdn");
			serviceImpl.setTemplateName("ServiceImpl.ftl");
			serviceImpl.run();
			
			GenerateAction action = new GenerateAction();
			action.setAuthor("张林");
			action.setCurrentDate("20180602");
			action.setPackageName("com.shop.manage");
			action.setTableAnnotation(annotation[i]);
			action.setTableName(tables[i]);
			action.setGitHub("https://github.com/lzdn");
			action.setTemplateName("Action.ftl");
			action.run();
		}

	}

}
