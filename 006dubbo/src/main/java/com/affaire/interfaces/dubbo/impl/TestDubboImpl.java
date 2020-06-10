package com.affaire.interfaces.dubbo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.affaire.interfaces.dubbo.TestDubbo;
import com.affaire.interfaces.entity.Entity;
import com.affaire.interfaces.entity.MpUser;
import com.affaire.service.MpUserService;

@Service
public class TestDubboImpl implements TestDubbo {

	@Autowired
	private RedissonClient redissonClient;

	@Autowired
	private MpUserService mpUserService;

	public static List<Entity> entities = new ArrayList<>();

	static {
		entities.add(new Entity(1L, "天安门广场", 21, "bj"));
		entities.add(new Entity(2L, "上海迪士尼", 22, "sh"));
		entities.add(new Entity(3L, "上海迪士尼", 23, "sh"));
		entities.add(new Entity(4L, "上海迪士尼", 21, "sh"));
		entities.add(new Entity(5L, "上海迪士尼", 22, "sh"));
	}

	@Override
	public List<Entity> sayHello(Integer age) {
		System.out.println("--------------This is 1-----------------");
		RLock lock = this.redissonClient.getLock("lock"); // 只要锁的名称相同就是同一把锁
		lock.lock(10, TimeUnit.SECONDS); // 加锁
		try {
			List<Entity> newentities = new ArrayList<>();
			for (Entity ent : entities) {
				if (ent.getAge() == age) {
					newentities.add(ent);
				}
			}
			return newentities;
		} finally {
			lock.unlock();
		}

		
	}

	@Override
	public List<MpUser> getUser(Integer age) {
		return mpUserService.getUser(age + "");
	}

}
