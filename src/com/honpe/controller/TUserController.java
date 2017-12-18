package com.honpe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.interceptor.SameUrlData;
import com.honpe.po.AuthFunction;
import com.honpe.po.Supplier;
import com.honpe.po.TUser;
import com.honpe.po.UserRoleKey;
import com.honpe.service.AuthFunctionService;
import com.honpe.service.SupplierService;
import com.honpe.service.TUserService;
import com.honpe.service.UserRoleService;
import com.honpe.utils.CookieUtils;
import org.springframework.util.DigestUtils;

/**
 * 
 * <p>Title: TUserController</p>
 * <p>Description:用户管理Controller </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class TUserController {
	@Autowired
	private TUserService tUserService;
	@Autowired
	private AuthFunctionService authFunctionService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private UserRoleService userRoleService;
	@Value("${COOKIE_EXPIRE}")
	private String COOKIE_EXPIRE;

	/**
	 * 
	 * <p>Title: login</p>
	 * <p>Description:用户登录 </p>
	 * @param username
	 * @param password
	 * @param code
	 * @param request
	 * @param response
	 * @param session
	 * @param rememberMe
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tuser/login", method = RequestMethod.POST)
	public String login(String username, String password, String code, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, String rememberMe, Model model) {
		String code1 = (String) session.getAttribute("key");
		if (StringUtils.isNotBlank("code") && StringUtils.isNotBlank(code1) && code1.equals(code)) {

			if (!activeUser(model, username)) {
				model.addAttribute("loginError", "公司信息正在审核中");
				return "login";
			}
			password = DigestUtils.md5DigestAsHex(password.getBytes());
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {

				subject.login(token);
			} catch (Exception e) {
				model.addAttribute("loginError", "用户名或密码不正确");
				return "login";
			}
			if (!subject.isAuthenticated()) {
				model.addAttribute("loginError", "公司信息正在审核中");
				return "login";
			}
			TUser tUser = (TUser) subject.getPrincipal();
			session.setAttribute("user", tUser);
			if (StringUtils.isNotBlank(rememberMe)) {
				CookieUtils.setCookie(request, response, "RememberMe", username + "," + password,
						Integer.parseInt(COOKIE_EXPIRE));
			}
			if (subject.isPermitted("admin")) {
				return "admin/admin";
			} else {
				// 是否生成菜单0表示不生成菜单1表示生成菜单
				List<AuthFunction> userMenu = authFunctionService.findUserMenu(tUser.getId(), "1");
				session.setAttribute("userMenu", userMenu);
				return "redirect:/demand/list";
			}
		} else {
			model.addAttribute("username", username);
			model.addAttribute("loginError", "验证码输入有误");
			return "login";
		}
	}

	/**
	 * 
	 * <p>Title: revisePwd</p>
	 * <p>Description:用户登录后修改密码 </p>
	 * @param password
	 * @param out
	 * @param newpassword
	 * @param code
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/tuser/revisePwd", method = RequestMethod.POST)
	public String revisePwd(String password, PrintWriter out, String newpassword, String code,
			HttpSession session, Model model) throws IOException {
		TUser user = (TUser) session.getAttribute("user");
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		String password2 = user.getPassword();
		if (!password2.equals(password)) {
			model.addAttribute("reviseError", "原始密码输入有误");
			return "update_pwd";
		}
		user.setPassword(DigestUtils.md5DigestAsHex(newpassword.getBytes()));
		tUserService.updatePossword(user);
		return "login";
	}

	/**
	 * 
	 * <p>Title: revisePassword</p>
	 * <p>Description:本公司网站管理员修改密码 </p>
	 * @param password
	 * @param newpassword
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/tuser/revisePassword", method = RequestMethod.POST)
	public @ResponseBody String revisePassword(String password, String newpassword,
			HttpSession session) {
		TUser user = (TUser) session.getAttribute("user");
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		String password2 = user.getPassword();
		if (!password2.equals(password))
			// 0表示失败
			return "0";
		user.setPassword(DigestUtils.md5DigestAsHex(newpassword.getBytes()));
		tUserService.updatePossword(user);
		// 1表示成功
		return "1";
	}

	/**
	 * 
	 * <p>Title: signOut</p>
	 * <p>Description:退出登录 </p>
	 * @param session
	 * @return
	 */
	@RequestMapping("/tuser/signOut")
	public String signOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * 
	 * <p>Title: register</p>
	 * <p>Description:用户注册 </p>
	 * @param tUser
	 * @param supplier
	 * @param confirm_password
	 * @param model
	 * @param session
	 * @return
	 */
	@SameUrlData
	@RequestMapping(value = "/tuser/register", method = RequestMethod.POST)
	public String userRegister(TUser tUser, Supplier supplier, String confirm_password, Model model,
			HttpSession session) {
		boolean flag = registCheck(tUser, model);
		if (flag) {
			model.addAttribute("confirm_password", confirm_password);
			model.addAttribute("tuser", tUser);
			model.addAttribute("supplier", supplier);
			return "register";
		}
		if (supplierService.selectSupplierById(supplier.getCompany()) != null) {
			model.addAttribute("confirm_password", confirm_password);
			model.addAttribute("tuser", tUser);
			model.addAttribute("supplier", supplier);
			model.addAttribute("registerError", "此公司已经注册");
			return "register";
		}
		try {
			supplierService.createSupplier(supplier);
			tUser.setName(supplier.getCompany());
			tUser.setSid(supplier.getSid());
			tUser.setPassword(DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes()));
			tUserService.createUser(tUser);
			UserRoleKey userRoleKey = new UserRoleKey();
			// 供应商注册授予"供应商"角色
			userRoleKey.setRoleId("001");
			userRoleKey.setUserId(tUser.getId());
			userRoleService.insertUserRole(userRoleKey);
		} catch (Exception e) {
			model.addAttribute("registerError", e.getMessage());
			return "register";
		}
		return "resuccess";
	}

	/**
	 * 
	 * <p>Title: goSetPwd</p>
	 * <p>Description:通过邮箱找回密码 </p>
	 * @param email
	 * @param code
	 * @param password
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/tuser/setPwd")
	public String goSetPwd(String email, String code, String password, HttpSession session,
			Model model) {
		String key = (String) session.getAttribute(email);
		if (StringUtils.isNotBlank(code)) {
			if (code.equals(key)) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());
				tUserService.updatePosswordByEmail(password, email);
			} else {
				model.addAttribute("getbackError", "验证码输入有误或已过期");
				return "getback";
			}
			return "gesuccess";
		} else {
			return "getback";
		}
	}

	/**
	 * 
	 * <p>Title: registCheck</p>
	 * <p>Description: 数据验证公共方法</p>
	 * @param tUser
	 * @param model
	 * @return
	 */
	private boolean registCheck(TUser tUser, Model model) {
		TUser tUser1 = tUserService.selectTUserByInfo(tUser.getUsername(), null, null);
		if (tUser1 != null) {
			model.addAttribute("registerError", "用户名已经被占用");
			return true;
		}
		TUser tUser2 = tUserService.selectTUserByInfo(null, tUser.getEmail(), null);
		if (tUser2 != null) {
			model.addAttribute("registerError", "邮箱已经被占用");
			return true;
		}
		TUser tUser3 = tUserService.selectTUserByInfo(null, null, tUser.getPhone());
		if (tUser3 != null) {
			model.addAttribute("registerError", "手机号已经被占用");
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>Title: activeUser</p>
	 * <p>Description:供应商审核通过首次登录激活帐号 </p>
	 * @param model
	 * @param username
	 * @return
	 */
	public boolean activeUser(Model model, String username) {
		TUser tUser = tUserService.selectUserByUsername(username);
		if (tUser != null && tUser.getIsactive() == 0) {
			Supplier supplier = supplierService.selectSupplierById(tUser.getSid());
			if ("1".equals(supplier.getNullify())) {
				tUser.setIsactive((byte) 1);
				tUserService.updateUser(tUser);
			} else {
				return false;
			}
		}
		return true;
	}
}
