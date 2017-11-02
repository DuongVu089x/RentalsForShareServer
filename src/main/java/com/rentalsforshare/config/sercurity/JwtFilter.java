package com.rentalsforshare.config.sercurity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.config.token.HandlerToken;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtFilter.
 */
public class JwtFilter extends GenericFilterBean {

	/** The token handler. */
	@Autowired
	private HandlerToken tokenHandler;
	
	/** The list user. */
	List<HashMap<String, String>> listUser = new ArrayList<HashMap<String, String>>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		final String authHeader = request.getHeader("authorization");

		String url = request.getRequestURI();
		if (url.contains("login") || url.contains("register") || url.contains("logout") || url.contains("forgot")) {
			chain.doFilter(req, res);
		}

		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		}
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Chưa đăng nhập");
			return;
		}

		String infoUser = tokenHandler.parseUserFromToken(authHeader.substring(7));
		if (infoUser.equals(Constants.STR_BLANK)) {
			return;
		}

		chain.doFilter(req, res);
	}

	/**
	 * Creates the service.
	 *
	 * @param request
	 *            the request
	 */
	private void createService(ServletRequest request) {
	}
}
