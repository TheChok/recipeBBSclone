package com.make.board.service;

import java.util.List;

import com.make.board.dto.CommentDTO;

public interface CommentService {
	
	// ��� ���
	void save(CommentDTO commentDTO);
	
	// ��� ��ȸ
	List<CommentDTO> findAll(Long boardId);

}
