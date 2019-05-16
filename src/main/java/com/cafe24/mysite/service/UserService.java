package com.cafe24.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.dao.UserDao;
import com.cafe24.mysite.repository.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean join(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	public UserVo getUser(Long userNo) {
		return userDao.get(userNo);
	}

	public UserVo getUser(UserVo userVo) {
		return userDao.get(userVo.getEmail(), userVo.getPassword());
	}
	
	public Boolean updateUser(UserVo userVo) {
		
		return userDao.updateUser(userVo);
	}
}
