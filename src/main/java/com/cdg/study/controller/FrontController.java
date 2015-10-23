package com.cdg.study.controller;

/*
 * MVC의 Controller 역할 담당하는 서블릿
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.filter.EncodingFilter;
import com.cdg.study.service.BoardDeleteCommand;
import com.cdg.study.service.BoardListCommand;
import com.cdg.study.service.BoardRetrieveCommand;
import com.cdg.study.service.BoardSearchCommand;
import com.cdg.study.service.BoardUpdateCommand;
import com.cdg.study.service.BoardWriteCommand;

@WebServlet("/controller/*")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// String info = request.getPathInfo();
		// System.out.println(info);
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String com = requestURI.substring(contextPath.length()); // /controller
		String action = com.substring(servletPath.length());
		// System.out.println(action); // /list

		try {
		
			// 1. 목록보기 http://localhost:8090/BoardProject/controller?action=list
			if ("/list".equals(action.trim())) {
				BoardListCommand command = new BoardListCommand();
				command.execute(request, response);
				// http://localhost:8090/BoardProject/controller/list
				// 내부에서 요청 ===> 8090/context명/호출한Servlet/
				RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
				dis.forward(request, response);
	
			}
	
			if ("/writeui".equals(action.trim())) {
				// Clien에서 요청 => URL 입력, a 태그 ===> 8090/context명/
				// http://localhost:8090/BoardProject/writeui.jsp
				response.sendRedirect("../writeui.jsp");
				/*
				 * RequestDispatcher dis =
				 * request.getRequestDispatcher("/writeui.jsp");
				 * dis.forward(request, response);
				 */
			}
	
			if ("/write".equals(action.trim())) {
	
				BoardWriteCommand command = new BoardWriteCommand();
				command.execute(request, response);
	
				// 바로 list.jsp 로 가면 DB를 들르지 않음
				response.sendRedirect("/BoardProject/controller/list");
				// response.sendRedirect("../list");
	
			}
	
			if ("/retrieve".equals(action.trim())) {
	
				BoardRetrieveCommand command = new BoardRetrieveCommand();
				command.execute(request, response);
				
				// 값을 넘겨줘야 하므로 forward
				RequestDispatcher dis = request.getRequestDispatcher("/retrieve.jsp");
				dis.forward(request, response);
				
			}
			
			if ("/update".equals(action.trim())) {
	
				BoardUpdateCommand command = new BoardUpdateCommand();
				command.execute(request, response);
				
				response.sendRedirect("/BoardProject/controller/list");
				
			}
			
			if ("/delete".equals(action.trim())) {
	
				BoardDeleteCommand command = new BoardDeleteCommand();
				command.execute(request, response);
				
				response.sendRedirect("/BoardProject/controller/list");
				
			}
			
			if("/search".equals(action.trim())) {
				BoardSearchCommand command = new BoardSearchCommand();
				command.execute(request, response);
				
				RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
				dis.forward(request, response);
			}
	
			// 2. 글쓰기 http://localhost:8090/BoardProject/controller?action=write
			// http://localhost:8090/BoardProject/controller/write
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
