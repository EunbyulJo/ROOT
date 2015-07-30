package org.it.board.model;

import java.util.List;

public interface BoardDao {
	public abstract int createOne(BoardDto dto);
	public abstract BoardDto readOne(String num);
	public abstract List<BoardDto> readAll();
}
