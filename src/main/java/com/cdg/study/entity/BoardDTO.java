package com.cdg.study.entity;

/*
 create table board
 ( num number(4) primary key,
 author varchar2(20) not null,
 title varchar2(20) not null,
 content varchar2(4000),
 writeday date default sysdate,
 readcnt number(4) default 0 );

 create sequence board_seq;

 */

public class BoardDTO {

	private int num;
	private String author;
	private String title;
	private String content;
	private String writeday;
	private int readcnt;

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int num, String author, String title, String content, String writedate, int readcnt) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", author=" + author + ", title=" + title + ", content=" + content + ", writedate=" + writeday + ", readcnt=" + readcnt + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO)obj;
		if (num != other.num)
			return false;
		return true;
	}
}
