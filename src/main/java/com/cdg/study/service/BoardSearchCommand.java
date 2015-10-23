package com.cdg.study.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;

/*
 * 게시판 목록 보기 비즈니스 로직 처리 클래스
 */

public class BoardSearchCommand implements BoardCommand {

	/*
	 * FrontController 에서 해야 할 일을 따로 뽑아옴
	 * 따라서 HttpServletRequest, HttpServletResponse 가 필요
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.search(searchName, searchValue);
		
		
		request.setAttribute("list", list);
		
	}
	
}
