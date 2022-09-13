package com.example.board.service;

import com.example.board.dto.BoardResponse;
import com.example.board.dto.CreateBoardRequest;
import com.example.board.dto.CreateBoardResponse;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.common.exception.NoDataException;
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

	/**
	 * 게시글 조회
	 * @param id
	 * @return
	 */
	public BoardResponse findById(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(NoDataException::new);

		return BoardResponse.fromEntity(board);
	}
}