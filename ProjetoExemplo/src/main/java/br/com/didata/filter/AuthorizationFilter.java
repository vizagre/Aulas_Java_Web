package br.com.didata.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/sistema/*")
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			HttpSession httpSession = ((HttpServletRequest) request).getSession();

			HttpServletRequest httpServletRequest = (HttpServletRequest) request;

			HttpServletResponse httpServletResponse = (HttpServletResponse) response;

			if (httpServletRequest.getRequestURI().indexOf("login.xhtml") <= -1) {

				if (httpSession.getAttribute("usuarioAutenticado") == null) {

					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");

				} else {

					chain.doFilter(request, response);
				}
			} else {

				chain.doFilter(request, response);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void destroy() {

	}
}
