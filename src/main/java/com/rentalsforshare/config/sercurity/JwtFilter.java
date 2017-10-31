package com.rentalsforshare.config.sercurity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

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

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(req, res);
	}

	/**
	 * Creates the service.
	 *
	 * @param request the request
	 */
	private void createService(ServletRequest request) {
	}
}
