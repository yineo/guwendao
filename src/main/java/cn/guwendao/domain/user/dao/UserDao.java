package cn.guwendao.domain.user.dao;

import org.springframework.stereotype.Repository;

import cn.guwendao.domain.basic.dao.BasicDao;
import cn.guwendao.domain.user.model.User;

@Repository("userDao")
public class UserDao extends BasicDao<User> {

	public UserDao() {
		super(User.class);
	}
}
