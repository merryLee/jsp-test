package com.cdg.study.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cdg.study.entity.BoardDTO;



public class BoardDAOTest {

	private BoardDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = BoardDAO.getInstance();
	}
	
	@Test
	public void testGetList() throws Exception {
		//When
		List<BoardDTO> actual = dao.getList();
		
		//Then
		assertNotNull(actual);
	}
	
	@Test
	public void testWrite() throws Exception {
		//Given
		BoardDTO dto = new BoardDTO();
		dto.setAuthor("홍길동");
		dto.setTitle("테스트입니다");
		dto.setContent("내용내용");

		//When
		int actual = dao.write(dto);

		//Then
		assertEquals(1, actual);
	}
	
	@Test
	public void testRetrieve() throws Exception {
		//Given
		BoardDTO dto = new BoardDTO();
		dto.setAuthor("홍길동");
		dto.setTitle("테스트입니다");
		dto.setContent("내용내용");

		//When
		BoardDTO actual = dao.retrieve("0");

		//Then
		assertNotNull(actual);
		assertEquals(dto, actual);
	}
}
