package com.make.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.make.board.dto.BoardDTO;
import com.make.board.dto.PageDTO;
import com.make.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	int pageLimit  = 10;
	int blockLimit = 5;
	
	// �Խñ� �ۼ� ó��
	@Override
	public int save(BoardDTO boardDTO) {
		return boardRepository.save(boardDTO);
	}
	
	// ��� ��ȸ
	@Override
	public List<BoardDTO> findAll() {
		return boardRepository.findAll();
	}
	
	// ��ȸ�� ����
	@Override
	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}
	
	// �� ������ ��ȸ
	@Override
	public BoardDTO findById(Long id) {
		return boardRepository.findById(id);
	}
	
	// �Խñ� ����
	@Override
	public void delete(Long id) {
		boardRepository.delete(id);
	}
	
	// �Խñ� ����
	@Override
	public void update(BoardDTO boardDTO) {
		boardRepository.update(boardDTO);
	}
	
	// ������ �Խù� ��ȸ 
	@Override
	public List<BoardDTO> pageList(int page) {
		int pageStart = ((page-1) * pageLimit);
		
		Map<String, Integer> params = new HashMap<>();
		params.put("start", pageStart);
		params.put("limit", pageLimit);
		
		List<BoardDTO> list = boardRepository.pageList(params);
		
		return list;
	}
	
	// ����¡ ó��
	@Override
	public PageDTO pageParam(int page) {
        int boardCount  = boardRepository.boardCount();
        int maxPage 	= (int) (Math.ceil((double) boardCount / pageLimit));
        int startPage 	= (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        int endPage 	= startPage + blockLimit - 1;

        if (endPage > maxPage)	endPage = maxPage;
        
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStart(startPage);
        pageDTO.setEnd(endPage);
        
        return pageDTO;
	}
	
	
}