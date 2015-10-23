package com.cdg.study.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;

/*
 * 게시판 목록 보기 비즈니스 로직 처리 클래스
 */

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num = request.getParameter("num");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
	
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardDAO dao = BoardDAO.getInstance();
		int n = dao.update(dto);
		
	}

}
