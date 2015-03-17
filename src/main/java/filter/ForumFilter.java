package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.zale.model.User;

public class ForumFilter implements Filter {

	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	// 1 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = { "/index.jsp",
			"/index.html", "/login.jsp", "/login/doLogin.html",
			"/register.jsp", "/register.html" };

	public void destroy() {
		// TODO Auto-generated method stub

	}

	//执行过滤
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//保证该过滤器在一次请求中只被调用一次
		if (request!=null && request.getAttribute(FILTERED_REQUEST)!=null) {
			chain.doFilter(request, response);
		}
		else {
			request.setAttribute(FILTERED_REQUEST,Boolean.TRUE);
			HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
