package com.demo.org.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.demo.org.bean.Log;
import com.demo.org.service.LogService;
import com.demo.org.service.impl.LogServiceImpl;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="logFilter",urlPatterns="/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
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
		
		//获取用户行为
		String url = hsr.getServletPath();
		
		//记录到数据库
		Log log = new Log();
		log.setAccount_id(id);
		log.setDescription("访问url:"+url);
		
		LogService ls = new LogServiceImpl();
		
		ls.addLog(log);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
