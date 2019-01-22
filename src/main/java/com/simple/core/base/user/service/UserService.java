package com.simple.core.base.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.simple.core.base.user.dao.UserInfoRepository;
import com.simple.core.base.user.dao.UserRepository;
import com.simple.core.base.user.dao.UserRoleRepository;
import com.simple.core.base.user.entity.SysRole;
import com.simple.core.base.user.entity.User;
import com.simple.core.base.user.entity.UserInfo;


@Service
public class UserService {
	private final Long DEFAULT_ROLE = 2L;
	@Autowired
	private UserRepository userDao;

	@Autowired
	private UserInfoRepository userInfoDao;
	
	@Autowired
	private UserRoleRepository userRoleDao;
	public User findById(Long id) {
    	       System.out.println("UserInfoServiceImpl.findByUsername()");
    	       return userDao.findById(id);
    }
	public User findByUsername(String username) {
	       System.out.println("UserInfoServiceImpl.findByUsername()");
	       return userDao.findByUsername(username);
   }
	public User register(User user,Long roleType) {
		if (roleType < 0){
			roleType = DEFAULT_ROLE;
		}
		ArrayList<SysRole> roleList = new ArrayList<SysRole>();
		SysRole defaultRole = userRoleDao.findById(roleType);
		roleList.add(defaultRole);
		user.setRoleList(roleList);
		User savedUser = userDao.saveAndFlush(user);
		return savedUser;
	}
	public List<User> getUsers(){
		return userDao.findAll();
	}
	public User save(User user) {
		User savedUser = userDao.saveAndFlush(user);
		return savedUser;
	}
	public int login(User user){
		User matchUser = userDao.findByIdAndPassword(user.getId(),user.getPassword());
		if (null != matchUser){
			Integer status = 1;
			matchUser.setStatus(status.byteValue());
			userDao.save(matchUser);
			return 0;
		}else{
			return -1;
		}
	}
	
	public int logout(User user){
		User matchUser = userDao.findById(user.getId());
		if (null != matchUser){
			Integer status = 0;
			matchUser.setStatus(status.byteValue());
			userDao.save(matchUser);
			return 0;
		}else{
			return -1;
		}
	}
	
	public void updateUserInfo(UserInfo info){
		userInfoDao.saveAndFlush(info);
	}
}
