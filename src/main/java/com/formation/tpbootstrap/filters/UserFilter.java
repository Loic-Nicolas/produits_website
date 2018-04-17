package com.formation.tpbootstrap.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// filtre les URLs qui commencent par "/user/"
public class UserFilter implements Filter {

	public static final String ACCES_PUBLIC 	= "/login";
	public static final String ATT_SESSION_USER = "user";
	
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute(ATT_SESSION_USER) == null) {
			response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
