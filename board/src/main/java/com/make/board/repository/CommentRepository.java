package com.make.board.repository;

import java.util.List;

import com.make.board.dto.CommentDTO;

public interface CommentRepository {
	
	// ��� ���
	void save(CommentDTO commentDTO);
	
	// ��� ��ȸ
	List<CommentDTO> findAll(Long boardId);
	
}
