package com.EurekaServer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EurekaServer.entity.UserPojo;

import org.springframework.web.bind.annotation.RequestMethod;

//@RestController是@Controller与@ResponseBody的组合
@RestController
public class ServerController {
	
	Logger log = LoggerFactory.getLogger(ServerController.class);
	
	//发起POST请求时，需要设置报文头部Content-Type=application/json，否则会报415错误
	@RequestMapping(value = "/testPost",method = RequestMethod.POST)
	public UserPojo testPost(HttpServletResponse response,HttpServletRequest request,@RequestBody UserPojo userPojo) {
		log.info("name:{},age:{}",userPojo.getName(),userPojo.getAge());
		return userPojo;
	}
	
	
	
}
