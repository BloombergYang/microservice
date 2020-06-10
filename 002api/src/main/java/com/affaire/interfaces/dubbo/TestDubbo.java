package com.affaire.interfaces.dubbo;

import java.util.List;

import com.affaire.interfaces.entity.Entity;
import com.affaire.interfaces.entity.MpUser;

public interface TestDubbo {
	public List<Entity> sayHello(Integer age);
	public List<MpUser> getUser(Integer age);
}
