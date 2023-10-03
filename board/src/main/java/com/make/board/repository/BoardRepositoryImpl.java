package com.make.board.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.make.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
	private final SqlSessionTemplate sql;
	private String namespace = "Board.";
	
	// �Խñ� �ۼ� ó��
	public int save(BoardDTO boardDTO) {
		return sql.insert(namespace + "save", boardDTO);
	}
	
	// ��� ��ȸ
	@Override
	public List<BoardDTO> findAll() {
		List<BoardDTO> list = sql.selectList(namespace + "findAll");
		return list;
	}
	
	// ��ȸ�� ����
	@Override
	public void updateHits(Long id) {
		sql.update(namespace + "updateHits", id);
	}
	
	// �� ������ ��ȸ
	@Override
	public BoardDTO findById(Long id) {
		return sql.selectOne(namespace + "findById", id);
	}
	
	// �Խñ� ����
	@Override
	public void delete(Long id) {
		sql.delete(namespace + "delete", id);
	}
	
	// �Խñ� ����
	@Override
	public void update(BoardDTO boardDTO) {
		sql.update(namespace + "update", boardDTO);
	}
	
	// ������ �Խñ� ��ȸ
	@Override
	public List<BoardDTO> pageList(Map<String, Integer> params) {
		return sql.selectList(namespace + "pageList", params);
	}

	// ����¡ ó��
	@Override
	public int boardCount() {
		return sql.selectOne(namespace + "boardCount");
	}
	
	
	
	
}
