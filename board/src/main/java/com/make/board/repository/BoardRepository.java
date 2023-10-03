package com.make.board.repository;

import java.util.List;
import java.util.Map;

import com.make.board.dto.BoardDTO;

public interface BoardRepository {
	
	// 게시글 작성 처리
	int save(BoardDTO boardDTO);

	// 목록 조회
	List<BoardDTO> findAll();
	
	// 조회수 증가
	void updateHits(Long id);
	
	// 상세 페이지 조회
	BoardDTO findById(Long id);
	
	// 게시글 삭제
	void delete(Long id);
	
	// 게시글 수정
	void update(BoardDTO boardDTO);
	
	// 페이지 게시글 조회
	List<BoardDTO> pageList(Map<String, Integer> params);
	
	// 페이징 처리
	int boardCount();
	
	
	
}
