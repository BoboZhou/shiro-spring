package com.atguigu.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.shiro.service.ShiroTestService;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private ShiroTestService service;

	@RequestMapping("/doLogin")
	public String doLogin(String username, String password) {
		Subject currentUserSubject = SecurityUtils.getSubject();
		if (!currentUserSubject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password, true);
			try {
				currentUserSubject.login(token);
			} catch (AuthenticationException e) {
				// 针对登录时相关的所有异常，在这处理
				log.info("****>  发生了异常：" + e.getMessage());
				e.printStackTrace();
			}
		}
		return "redirect:/success.jsp";
	}

	@RequestMapping("testAnnotation")
	public String testAnnotation() {
		service.testShiro();
		return "redirect:/success.jsp";
	}

}
