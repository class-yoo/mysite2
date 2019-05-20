package com.cafe24.mysite.repository.dao;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cafe24.mysite.repository.vo.UserVo;

@Repository
public class UserDao {

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;

	public Boolean insertUser(UserVo userVo) {
		return 1 == sqlSession.insert("user.insert", userVo);
	}

	public UserVo get(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}
	
	public UserVo get(String email) {

		UserVo userVo = sqlSession.selectOne("user.getByEmail", email);
		
		return userVo;
	}


	public UserVo get(Long no) {

		UserVo userVo = sqlSession.selectOne("user.getByNo", no);
		
		return userVo;
	}

	public Boolean updateUser(UserVo vo) {
		
		return 1== sqlSession.update("user.update", vo);
	}

}
