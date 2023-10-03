package com.make.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.board.dto.CommentDTO;
import com.make.board.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	// ´ñ±Û µî·Ï
	@Override
	public void save(CommentDTO commentDTO) {
		commentRepository.save(commentDTO);
	}
	
	// ´ñ±Û Á¶È¸
	@Override
	public List<CommentDTO> findAll(Long boardId) {
		return commentRepository.findAll(boardId);
	}
	
	
}
