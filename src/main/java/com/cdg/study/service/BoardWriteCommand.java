package com.cdg.study.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;


public class BoardWriteCommand implements BoardCommand {

	/*
	 * FrontController 에서 해야 할 일을 따로 뽑아옴
	 * 따라서 HttpServletRequest, HttpServletResponse 가 필요
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardDAO dao = BoardDAO.getInstance();
		int n = dao.write(dto);
	}
	
}
