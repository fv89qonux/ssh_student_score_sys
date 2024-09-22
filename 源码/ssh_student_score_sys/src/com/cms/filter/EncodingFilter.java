package com.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 编码过滤器
 * 防止乱码
 * @类名	EncodingFilter.java
 * @作者	cola
 * @Emial	xxxx@qq.com
 * @QQ	2020
 * @日期 2016-6-13
 * @版本 V 1.0
 */
public class EncodingFilter implements Filter {

	private FilterConfig config;
	private String encode;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.encode = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding(this.encode);
		res.setCharacterEncoding(this.encode);
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {

	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}
	
}
