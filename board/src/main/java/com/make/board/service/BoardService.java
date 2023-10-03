package com.make.board.service;

import java.util.List;

import com.make.board.dto.BoardDTO;
import com.make.board.dto.PageDTO;

public interface BoardService {
	
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
	
	// ������ �Խù� ��ȸ
	List<BoardDTO> pageList(int page);
	
	// ����¡ ó��
	PageDTO pageParam(int page);

	
}