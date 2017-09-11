package com.demo.org.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.service.AuthService;
import com.demo.org.service.impl.AuthServiceImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(filterName="authFilter",urlPatterns="/*")
public class F1_AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public F1_AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//获取用户信息
		HttpServletRequest hsr = (HttpServletRequest)request;
		int id = 0;
		if(hsr.getSession().getAttribute("id") != null) {
			id = (int)hsr.getSession().getAttribute("id");
		}
		//获取用户访问的功能
		String url = hsr.getServletPath();
		//查看该用户是否有该功能的权限
			//获取用户的权限
		AuthService as = new AuthServiceImpl();
		List<String> authList = as.getAuth(id);
			//对比
		if(authList.contains(url)) {
			//如果有，继续执行
			
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {
			//如果没有，跳转到无权限提示页面
			request.getRequestDispatcher("/WEB-INF/jsp/noAuth.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
