package com.cms.dto;

/**
 * 分页管理--页码
 * @类名	SystemContext.java
 * @作者	cola
 * @Emial	xxxx@qq.com
 * @QQ	2020
 * @日期 2016-6-13
 * @版本 V 1.0
 */
public class SystemContext {
	
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();

	public static int getPageOffset() {
		int page = pageOffset.get();
		if (page == 0){
			page++;
		}
		return page;
	}
	public static void setPageOffset(int _pageOffset) {
		pageOffset.set(_pageOffset);
	}
	public static void removePageOffset() {
		pageOffset.remove();
	}
}
