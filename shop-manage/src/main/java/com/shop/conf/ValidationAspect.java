package com.shop.conf;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.shop.annotation.Verification;
import com.shop.exception.ValidationException;

@Aspect
@Component
@Order(-1)
public class ValidationAspect {

	private static final String CLASS_FIX = "FormValidation";
	private static final String CLASS_PATH = "com.shop.validation.";

	@Before("@annotation(verify)")
	public void before(JoinPoint point, Verification verify) throws ValidationException {
		try {
			if (verify.verify()) {
				Object[] args = point.getArgs();
				Method method = ((MethodSignature) point.getSignature()).getMethod();
				String formValidationClassName = CLASS_PATH + method.getDeclaringClass().getSimpleName() + CLASS_FIX;
				Class<?> formValidationClass = Class.forName(formValidationClassName);
				Method formValidationMethod = formValidationClass.getMethod(method.getName(),
						method.getParameterTypes());
				Object obj = formValidationMethod.invoke(SpringUtil.getBean(formValidationClass), args);
				if (obj != null) {
					throw new ValidationException(JSON.toJSONString(obj));
				}
			}
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}

	}
}
