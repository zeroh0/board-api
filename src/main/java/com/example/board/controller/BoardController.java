package com.example.board.controller;

import com.example.board.dto.CreateBoardRequest;
import com.example.board.dto.CreateBoardResponse;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;

	/**
	 * 게시글 작성
	 * @param requestDto
	 * @return
	 */
	@PostMapping("/")
	public ResponseEntity<CreateBoardResponse> save(@Valid @RequestBody CreateBoardRequest requestDto) {
		CreateBoardResponse responseDto = boardService.save(requestDto);

		return ResponseEntity.ok(responseDto);
	}

}