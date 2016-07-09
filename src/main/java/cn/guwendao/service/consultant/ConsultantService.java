package cn.guwendao.service.consultant;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.stereotype.Service;

import cn.guwendao.domain.basic.model.RestEntity;
import cn.guwendao.domain.user.dao.UserDao;
import cn.guwendao.domain.user.model.User;

@Service("consultantService")
public class ConsultantService {

	@Resource
	UserDao userDao;
	
	/**
	 * 顾问列表
	 * @return
	 */
	@POST
	@Path("public/cst/list")
	public RestEntity<List> getConsultantList(Map<String,Object> param){
		
		Integer page = (Integer)param.get("page");
		page = page == null ? 1 : page;
		Integer pageSize = (Integer)param.get("pageSize");
		pageSize = pageSize == null ? 20 : pageSize;
		
		String sql = "select id, nickName, selfDesc from user where consultantFlag = 1";
		
		List list = userDao.queryBySql(sql, null, page, pageSize);
		return new RestEntity<List>().ok(list);
		
	}
	
	/**
	 * 获取顾问
	 * @param cstId
	 * @return
	 */
	@GET
	@Path("public/cst/{cstId}")
	public RestEntity<User> getConsultant(@PathParam("cstId")String cstId) {
		User user = userDao.get(cstId);
		return new RestEntity<User>().ok(user);
	}
	
}
