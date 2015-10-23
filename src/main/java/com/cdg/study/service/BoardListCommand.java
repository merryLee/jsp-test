package com.cdg.study.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;

/*
 * 게시판 목록 보기 비즈니스 로직 처리 클래스
 */

public class BoardListCommand implements BoardCommand {

	/*
	 * FrontController 에서 해야 할 일을 따로 뽑아옴
	 * 따라서 HttpServletRequest, HttpServletResponse 가 필요
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.getList();
		
		// list.jsp 에서 List<BoardDTO>를 보여준다.
		// 3가지 scope 중에 선택하여 저장	.
		
		request.setAttribute("list", list);
		
	}
	
}
