package com.example.board.controller;

import com.example.board.dto.*;
import com.example.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;

	/**
	 * 게시글 목록 조회
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<List<BoardListResponse>> findAll() {
		List<BoardListResponse> responseDto = boardService.findAll();

		return ResponseEntity.ok(responseDto);
	}

	/**
	 * 게시글 작성
	 * @param requestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<CreateBoardResponse> save(@Valid @RequestBody CreateBoardRequest requestDto) {
		CreateBoardResponse responseDto = boardService.save(requestDto);

		return ResponseEntity.ok(responseDto);
	}

	/**
	 * 게시글 수정
	 * @param requestDto
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UpdateBoardResponse> update(@Valid @RequestBody UpdateBoardRequest requestDto) {
		UpdateBoardResponse responseDto = boardService.update(requestDto);

		return ResponseEntity.ok(responseDto);
	}

	/**
	 * 게시글 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
		BoardResponse responseDto = boardService.findById(id);

		return ResponseEntity.ok(responseDto);
	}

	/**
	 * 게시글 삭제
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		boardService.delete(id);
	}

}