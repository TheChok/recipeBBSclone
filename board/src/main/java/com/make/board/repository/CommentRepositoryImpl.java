package com.make.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.make.board.dto.CommentDTO;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
	@Autowired
	private SqlSessionTemplate sql;
	private String namepace = "Comment.";
	
	// ��� ���
	@Override
	public void save(CommentDTO commentDTO) {
		sql.insert(namepace + "save", commentDTO);
	}
	
	// ��� ��ȸ
	@Override
	public List<CommentDTO> findAll(Long boardId) {
		return sql.selectList(namepace + "findAll", boardId);
	}
	
	
	
}
