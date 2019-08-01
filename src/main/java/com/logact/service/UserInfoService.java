package com.logact.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logact.dao.UserInfoDao;
import com.logact.domain.UserInfo;


@Service("userInfoService")
@Transactional
public class UserInfoService{

	//注入Mapper接口对象
	@Resource
	private  UserInfoDao userInfoDao;
	
	public List<UserInfo> findAll() {
		return userInfoDao.listAllUserInfo();
	}

	public void save(UserInfo userInfo) {
		//判断是添加还是修改
		if(userInfo.getId()!=null){
			//修改
			userInfoDao.update(userInfo);
		}else{
			//增加
			userInfoDao.save(userInfo);
		}
	}

	public UserInfo findById(Integer id) {
		return userInfoDao.findById(id);
	}

	public void delete(Integer[] id) {
		userInfoDao.delete(id);
	}

}