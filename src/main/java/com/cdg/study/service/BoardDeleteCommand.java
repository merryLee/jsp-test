package com.cdg.study.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdg.study.dao.BoardDAO;
import com.cdg.study.entity.BoardDTO;


public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		int n = dao.delete(num);
		
	}

}
