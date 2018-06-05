package com.shop.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shop.web.Result;

@ControllerAdvice("com.shop")
public class ExceptionHandler {

	/**
	 * 全局异常处理
	 * 
	 * @param response
	 * @param e
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public void globalHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		try {
			boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			if (isAjax) {
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(JSON.toJSONString(new Result("系统异常："+out.toString(), false), SerializerFeature.WriteMapNullValue));
			} else {
				request.setAttribute("errorMessage", out.toString());
				request.getRequestDispatcher("/error").forward(request, response);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
