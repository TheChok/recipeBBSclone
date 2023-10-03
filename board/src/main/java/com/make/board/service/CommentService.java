package com.make.board.service;

import java.util.List;

import com.make.board.dto.CommentDTO;

public interface CommentService {
	
	// ´ñ±Û µî·Ï
	void save(CommentDTO commentDTO);
	
	// ´ñ±Û Á¶È¸
	List<CommentDTO> findAll(Long boardId);

}
