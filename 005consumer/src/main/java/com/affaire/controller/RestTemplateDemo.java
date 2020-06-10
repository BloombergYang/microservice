package com.affaire.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.affaire.commonutils.RedisUtil;
import com.affaire.entity.Entity;

@RestController
public class RestTemplateDemo {
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@GetMapping("demo")
	public String DemoPost(String year,String replaceHolder) {
		
		
		String redisKey = year +"_"+replaceHolder;
		
		
		Boolean obj = redisTemplate.hasKey(redisKey);
		if(obj) {
			//System.out.println(sendPostDataByMap("http://localhost:8090/hihi",map,"utf-8"));
			//ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8090/hi", String.class);
			Entity entity = new Entity();
			entity.setName(year);
			entity.setContent(replaceHolder);
	    	String res1 =  restTemplate.postForObject("http://localhost:8090/hihihi", entity, String.class);
	    	System.out.println(res1);
//	    	Map<String,String> map = new HashMap<String, String>();
//	    	map.put("name", year);
//	    	map.put("content", replaceHolder);
//	    	String res1 =  restTemplate.postForObject("http://localhost:8090/hihi", map, String.class);
	    	System.out.println(res1);
	    	redisTemplate.opsForValue().set(redisKey, res1, -1);
			return res1;
		}else {
			return (String)redisTemplate.opsForValue().get(redisKey);
		}
		
		
	}


}
