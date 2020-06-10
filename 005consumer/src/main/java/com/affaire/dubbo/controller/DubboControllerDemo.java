package com.affaire.dubbo.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.affaire.interfaces.dubbo.TestDubbo;
import com.affaire.interfaces.entity.Entity;
import com.affaire.interfaces.entity.MpUser;

@RestController
public class DubboControllerDemo {
	
	@Reference
	private TestDubbo testDubbo;
	
	@GetMapping(value="dubbodemo")
	@ResponseBody
	public List<Entity> DubboDemo(Integer age) {
		
		return testDubbo.sayHello(age);
	}
	@GetMapping(value="dubbodemomybatis")
	@ResponseBody
	public List<MpUser> dubbodemomybatis(Integer age) {
		
		return testDubbo.getUser(age);
	}

}
