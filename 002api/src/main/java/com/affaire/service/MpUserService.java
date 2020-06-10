package com.affaire.service;

import java.util.List;

import com.affaire.interfaces.entity.MpUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MpUserService extends IService<MpUser> {
	public List<MpUser> getUser(String age);
}
