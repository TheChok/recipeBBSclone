package com.make.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.make.board.dto.BoardDTO;
import com.make.board.dto.CommentDTO;
import com.make.board.dto.PageDTO;
import com.make.board.service.BoardService;
import com.make.board.service.CommentService;

import lombok.RequiredArgsConstructor;


// public class BoardController
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService 	 boardService;
	private final CommentService commentService;
	
	// �Խñ� �ۼ� ������ �̵�
	@GetMapping("/save")
	public String saveForm() {
		return "saveForm";
	}
	
	// �Խñ� �ۼ� ó��
	@PostMapping("/save")
	public String save(@ModelAttribute BoardDTO boardDTO) {
		int saveResult = boardService.save(boardDTO);
		
		if(saveResult > 0) {
			return "redirect:/board/paging";
		} else {
			return "save";
		}
	}
	
	// ��� �̵�
	@GetMapping("/list")
	public String findAll(Model m) {
		List<BoardDTO> boardList = boardService.findAll();
		m.addAttribute("boardList", boardList);
		return "list";
	}
	
	// �Խñ� �� ������
	@GetMapping("/detail")
	@Transactional
	public String detail(@RequestParam("id") Long id, Model m, 
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		boardService.updateHits(id);
		BoardDTO 		 boardDTO 	= boardService.findById(id);
		List<CommentDTO> list 		= commentService.findAll(id);
		
		m.addAttribute("board", boardDTO);
		m.addAttribute("page", page);
		m.addAttribute("commentList", list);
		
		return "detail";
	}
	
	// �Խñ� ����
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/list/";
	}
	
	// �Խñ� ���� ������ �̵�
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model m) {
		BoardDTO boardDTO = boardService.findById(id);
		m.addAttribute("board", boardDTO);
		return "updateForm";
	}
	
	// �Խñ� ����
	@PostMapping("/update")
	@Transactional
	public String update(@ModelAttribute BoardDTO boardDTO, Model m) {
		boardService.update(boardDTO);
		BoardDTO board = boardService.findById(boardDTO.getId());
		m.addAttribute("board", board);
		
		return "detail";
	}
	
	// ����¡ ȭ��
	@GetMapping("/paging")
	@Transactional
	public String paging(Model m, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		PageDTO pageDTO 		= boardService.pageParam(page);
		List<BoardDTO> pageList = boardService.pageList(page);
		
		m.addAttribute("paging", pageDTO);
		m.addAttribute("boardList", pageList);
		
		return "paging";
	}
	
	
} // End - public class BoardController