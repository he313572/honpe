package com.honpe.exception;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.honpe.utils.SendJMail;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
	@Value("${COMPANY_EMAIL}")
	private String COMPANY_EMAIL;
	@Value("${EMAIL_PWD}")
	private String EMAIL_PWD;
	@Value("${ADMIN_EMAIL}")
	private String ADMIN_EMAIL;
	@Value("${ERROR_MESSAGE}")
	private String ERROR_MESSAGE;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exception) {
		// 异常信息打印
		Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
		// 发送邮件给运维
		try {
			SendJMail.sendMail(COMPANY_EMAIL, COMPANY_EMAIL, EMAIL_PWD, ADMIN_EMAIL, ERROR_MESSAGE + exception.toString());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/500");
		return modelAndView;
	}
}
