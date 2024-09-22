package com.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.cms.dto.SystemContext;

/**
 * 分页管理
 * @类名	SystemContextFilter.java
 * @作者	xyn
 * @Emial	xxxx@qq.com
 * @日期 2015-3-4
 * @版本 V 1.0
 */
public class SystemContextFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try {
			int pageOffset = 0;
			try {
				pageOffset = Integer.parseInt(req.getParameter("pager.offset"));
			} catch (NumberFormatException e) {}
				SystemContext.setPageOffset(pageOffset);
				chain.doFilter(req, resp);
		} finally {
			SystemContext.removePageOffset();
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
		} catch (NumberFormatException e) {
		}
	}
}
