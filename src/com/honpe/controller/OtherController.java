package com.honpe.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.honpe.po.TUser;
import com.honpe.service.TUserService;
import com.honpe.utils.SendJMail;

/**
 * 
 * <p>Title: OtherController</p>
 * <p>Description: 发送邮件Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class OtherController {
	@Value("${COMPANY_EMAIL}")
	private String COMPANY_EMAIL;
	@Value("${EMAIL_PWD}")
	private String EMAIL_PWD;
	@Autowired
	private TUserService tUserService;

	/**
	 * 
	 * <p>Title: backPwd</p>
	 * <p>Description:注册邮箱发送验证码 </p>
	 * @param email
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getEmailCode")
	public void backPwd(final String email, final HttpSession session, HttpServletResponse response) throws IOException {
		TUser tUser = tUserService.selectUserByEmail(email);
		if (tUser == null) {
			response.getWriter().write("2");
			return;
		}
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			String j = (int) (Math.random() * 10) + "";
			sBuffer.append(j);
		}
		String code = sBuffer.toString();
		session.setAttribute(email, code);
		String message = "<font color='gray'>验证码:" + code + "</font>";
		try {
			SendJMail.sendMail(COMPANY_EMAIL, COMPANY_EMAIL, EMAIL_PWD, email, message);
			response.getWriter().write("1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute(email);
				}
			}, 60000);
		} catch (Exception e) {
			response.getWriter().write("0");
		}
	}
}
