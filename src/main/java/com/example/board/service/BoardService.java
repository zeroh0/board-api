package com.example.board.service;

import com.example.board.dto.CreateBoardRequest;
import com.example.board.dto.CreateBoardResponse;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

	private final BoardRepository boardRepository;

	/**
	 * 게시글 작성
	 * @param requestDto
	 * @return
	 */
	public CreateBoardResponse save(CreateBoardRequest requestDto) {
		Board board = CreateBoardRequest.toEntity(requestDto);

		return CreateBoardResponse.builder()
			.id(boardRepository.save(board).getId())
			.build();
	}

}