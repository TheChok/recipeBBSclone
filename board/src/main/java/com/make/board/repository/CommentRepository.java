package com.make.board.repository;

import java.util.List;

import com.make.board.dto.CommentDTO;

public interface CommentRepository {
	
	// ´ñ±Û µî·Ï
	void save(CommentDTO commentDTO);
	
	// ´ñ±Û Á¶È¸
	List<CommentDTO> findAll(Long boardId);
	
}
