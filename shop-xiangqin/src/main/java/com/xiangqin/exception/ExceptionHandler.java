package com.xiangqin.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice("com.xiangqin")
public class ExceptionHandler {

	/**
	 * 全局异常处理
	 * 
	 * @param response
	 * @param e
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public void globalHandler(HttpServletResponse response, Exception e) {
		try {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			response.getOutputStream().write(("系统异常：" + out.toString()).getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
