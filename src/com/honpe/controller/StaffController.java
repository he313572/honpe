package com.honpe.controller;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.interceptor.SameUrlData;
import com.honpe.po.TUser;
import com.honpe.po.UserRoleKey;
import com.honpe.pojo.PageBean;
import com.honpe.service.TUserService;
import com.honpe.service.UserRoleService;

/**
 * 
 * <p>Title: StaffController</p>
 * <p>Description:供应商员工管理Controller </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class StaffController {
	@Autowired
	private TUserService tUserService;
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 
	 * <p>Title: list</p>
	 * <p>Description:员工列表页面 </p>
	 * @param currentPage
	 * @param name
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/staff/list")
	public String list(Integer currentPage, String name, Model model, HttpSession session) {
		if (currentPage == null) {
			currentPage = 1;
		}
		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
		}
		TUser tUser = (TUser) session.getAttribute("user");
		String sid = tUser.getSid();
		PageBean<TUser> pageBean = tUserService.selectUsers(sid, currentPage, name, tUser.getId());
		model.addAttribute("pageBean", pageBean);
		return "supplier/person_admin";
	}

	/**
	 * 
	 * <p>Title: addStaff</p>
	 * <p>Description:添加员工 </p>
	 * @param tUser
	 * @param model
	 * @param session
	 * @return
	 */
	@SameUrlData
	@RequestMapping("/staff/add")
	public String addStaff(TUser tUser, Model model, HttpSession session) {
		boolean flag = addCheck(tUser, model);
		if (flag) {
			return "supplier/add_salesman";
		}
		TUser tUser1 = (TUser) session.getAttribute("user");
		tUser.setSid(tUser1.getSid());
		// 用户激活状态 1表示激活 0表示未激活
		tUser.setIsactive((byte) 1);
		tUser.setPassword(DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes()));
		tUserService.insertUser(tUser);
		UserRoleKey userRoleKey = new UserRoleKey();
		// 员工赋予"业务员"角色
		userRoleKey.setRoleId("002");
		userRoleKey.setUserId(tUser.getId());
		userRoleService.insertUserRole(userRoleKey);
		return "redirect:list";
	}

	/**
	 * 跳转用户信息修改页面
	 * <p>Title: goModifyStaffInfo</p>
	 * <p>Description: </p>
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/staff/goEdit")
	public String goModifyStaffInfo(String id, Model model) {
		TUser tUser = tUserService.selectUserById(id);
		model.addAttribute("tUser", tUser);
		return "supplier/editor_person";
	}
	/**
	 * 
	 * <p>Title: modifyStaffInfo</p>
	 * <p>Description:修改员工信息 </p>
	 * @param tUser
	 * @return
	 */
	@RequestMapping("/staff/edit")
	public String modifyStaffInfo(TUser tUser) {
		tUserService.updateUser(tUser);
		return "redirect:list";
	}

	/**
	 * 
	 * <p>Title: removeStaff</p>
	 * <p>Description: 删除员工</p>
	 * @param id
	 * @return
	 */
	@RequestMapping("/staff/remove")
	public String removeStaff(String id) {
		tUserService.deleteUserById(id);
		return "redirect:list";
	}
	/**
	 * 
	 * <p>Title: batchRemove</p>
	 * <p>Description:批量删除员工保存的报价信息 </p>
	 * @param ids
	 * @return
	 */
	@RequestMapping("/staff/batch")
	public @ResponseBody String batchRemove(String ids) {
		String[] idArr = ids.split(",");
		for (int i = 0; i < idArr.length; i++) {
			String id = idArr[i];
			tUserService.deleteUserById(id);
		}
		// 1表示成功
		return "1";
	}
	/**
	 * 
	 * <p>Title: addCheck</p>
	 * <p>Description:数据验证公共方法 </p>
	 * @param tUser
	 * @param model
	 * @return
	 */
	private boolean addCheck(TUser tUser, Model model) {
		TUser tUser1 = tUserService.selectTUserByInfo(tUser.getUsername(), null, null);
		if (tUser1 != null) {
			model.addAttribute("addError", "用户名已经被占用");
			return true;
		}
		TUser tUser2 = tUserService.selectTUserByInfo(null, tUser.getEmail(), null);
		if (tUser2 != null) {
			model.addAttribute("addError", "邮箱已经被占用");
			return true;
		}
		TUser tUser3 = tUserService.selectTUserByInfo(null, null, tUser.getPhone());
		if (tUser3 != null) {
			model.addAttribute("addError", "手机号已经被占用");
			return true;
		}
		return false;
	}
}
