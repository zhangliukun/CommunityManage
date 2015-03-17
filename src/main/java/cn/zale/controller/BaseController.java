package cn.zale.controller;

import javax.servlet.http.HttpServletRequest;

import cn.zale.cons.CommonConstant;
import cn.zale.model.User;

public class BaseController {

	protected static final String ERROR_MSG_KEY = "errorMsg";

	// 获取保存在Session中的用户对象
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}

	// 将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}

}
