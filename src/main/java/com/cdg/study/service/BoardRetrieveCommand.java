package com.cdg.study.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;


public class BoardRetrieveCommand implements BoardCommand {

	/*
	 * FrontController 에서 해야 할 일을 따로 뽑아옴
	 * 따라서 HttpServletRequest, HttpServletResponse 가 필요
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.retrieve(num);
		
		request.setAttribute("retrieve", dto);
	}
	
}
