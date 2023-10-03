package com.make.board.repository;

import java.util.List;
import java.util.Map;

import com.make.board.dto.BoardDTO;

public interface BoardRepository {
	
	// �Խñ� �ۼ� ó��
	int save(BoardDTO boardDTO);

	// ��� ��ȸ
	List<BoardDTO> findAll();
	
	// ��ȸ�� ����
	void updateHits(Long id);
	
	// �� ������ ��ȸ
	BoardDTO findById(Long id);
	
	// �Խñ� ����
	void delete(Long id);
	
	// �Խñ� ����
	void update(BoardDTO boardDTO);
	
	// ������ �Խñ� ��ȸ
	List<BoardDTO> pageList(Map<String, Integer> params);
	
	// ����¡ ó��
	int boardCount();
	
	
	
}