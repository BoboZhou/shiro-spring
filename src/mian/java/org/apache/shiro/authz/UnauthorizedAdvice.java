package org.apache.shiro.authz;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnauthorizedAdvice {
	@ExceptionHandler(org.apache.shiro.authz.AuthorizationException.class)
	public String handleException(Exception exception) {
		System.out.println(exception.getCause());
		return "redirect:/unauthorized.jsp";
		
	}

}
