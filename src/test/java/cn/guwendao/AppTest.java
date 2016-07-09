package cn.guwendao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.guwendao.domain.user.dao.UserDao;
import cn.guwendao.domain.user.model.User;

@ContextConfiguration(locations= {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class AppTest {
	
	@Resource
	UserDao userDao;
	
	@Test
	public void test() {
		User user = new User();
		user.setName("陈标斌");
		user.setCity("广州市");
		user.setConsultantFlag(true);
		user.setDayValue(4000);
		user.setGoodAt("CRM,Java,架构设计");
		user.setNickName("Catch");
		user.setPhoneNumber("18698564324");
		user.setPosition("开发总监");
		user.setSelfDesc("8年技术开发经验，优秀架构师");
		user.setServed("伊丽莎白，中兴通讯，华润集团，维也纳酒店，伊丽莎白美容");
		user.setTag("帅哥，酷，大宝剑");
		user.setWorkPlace("美众云计算");
		user.setWorkExperience("5~8年");
		user.setPassword("123123");
		userDao.save(user);
	}
	
}
