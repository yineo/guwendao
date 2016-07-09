package cn.guwendao.common.util.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.guwendao.domain.user.model.User;

public class UserUtil {

	protected final static Log log = LogFactory.getLog(UserUtil.class);
	
	/**
	 * 获取当前登录员工
	 * @return
	 */
	public static User getUser() {
		
		User user = new User();
		user.setId("0-1");
		user.setName("neo");
		user.setPhoneNumber("18688332683");
		
		/*User user = null;
		Authentication auth = null;
		try {
			SecurityContext securityContext = null;
			securityContext = SecurityContextHolder.getContext();
			
			if (securityContext == null) {
				log.debug("获取不到登录用户信息，可能是用户未登录或者Session过期");
				return null;
			}
			auth = securityContext.getAuthentication();

			if (auth == null) {
				log.debug("获取不到登录用户信息");
				return null;
			}
			
			user = (User) auth.getPrincipal();

		} catch (Exception e) {
			try {
				user = (User) auth.getDetails();
				log.debug(user);
			} catch (Exception e2) {
				log.error("获取登录用户失败", e2);
				throw new RuntimeException(e2);
			}
		}*/
		
		return user;
	}
	
}
