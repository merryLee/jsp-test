package com.cdg.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 요청필터
		// 다음 필터 또는 다음 서블릿으로 요청 // 자동으로 요청되지 않음
		//System.out.println("Encoding 요청필터");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);

		
		// 응답필터
		//System.out.println("EncodingFilter 응답필터");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
