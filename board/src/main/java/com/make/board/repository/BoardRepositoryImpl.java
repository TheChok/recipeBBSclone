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
	
	// 게시글 작성 처리
	public int save(BoardDTO boardDTO) {
		return sql.insert(namespace + "save", boardDTO);
	}
	
	// 목록 조회
	@Override
	public List<BoardDTO> findAll() {
		List<BoardDTO> list = sql.selectList(namespace + "findAll");
		return list;
	}
	
	// 조회수 증가
	@Override
	public void updateHits(Long id) {
		sql.update(namespace + "updateHits", id);
	}
	
	// 상세 페이지 조회
	@Override
	public BoardDTO findById(Long id) {
		return sql.selectOne(namespace + "findById", id);
	}
	
	// 게시글 삭제
	@Override
	public void delete(Long id) {
		sql.delete(namespace + "delete", id);
	}
	
	// 게시글 수정
	@Override
	public void update(BoardDTO boardDTO) {
		sql.update(namespace + "update", boardDTO);
	}
	
	// 페이지 게시글 조회
	@Override
	public List<BoardDTO> pageList(Map<String, Integer> params) {
		return sql.selectList(namespace + "pageList", params);
	}

	// 페이징 처리
	@Override
	public int boardCount() {
		return sql.selectOne(namespace + "boardCount");
	}
	
	
	
	
}
