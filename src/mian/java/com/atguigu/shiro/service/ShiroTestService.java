package com.atguigu.shiro.service;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

@Service
public class ShiroTestService {
	@RequiresRoles("admin")
	public void testShiro(){
		System.out.println("----------testShiro---" + new Date());
	}

}
