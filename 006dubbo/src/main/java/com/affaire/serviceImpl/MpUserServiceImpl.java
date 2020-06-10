package com.affaire.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.affaire.interfaces.entity.MpUser;
import com.affaire.mapper.MpUserMapper;
import com.affaire.service.MpUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {

	@Autowired
	private MpUserMapper mpUserMapper;

	@Override
	public List<MpUser> getUser(String age) {
		MpUser mpUser = new MpUser();
		mpUser.setOpenid(age);
		Wrapper<MpUser> queryWrapper = new QueryWrapper<MpUser>(mpUser);
		return mpUserMapper.selectList(queryWrapper);
	}
}
