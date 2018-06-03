package com.shop.utils.code;

import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerTemplateUtils {

	private FreeMarkerTemplateUtils() {
	}

	private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

	static {
		// 这里比较重要，用来指定加载模板所在的路径
		CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/com/shop/utils/code/"));
		//CONFIGURATION.setDirectoryForTemplateLoading(new File("template/main"));
		CONFIGURATION.setDefaultEncoding("UTF-8");
		CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
	}

	public static Template getTemplate(String templateName) throws IOException {
		try {
			return CONFIGURATION.getTemplate(templateName);//,Locale.ENGLISH
		} catch (IOException e) {
			throw e;
		}
	}

	public static void clearCache() {
		CONFIGURATION.clearTemplateCache();
	}
}
