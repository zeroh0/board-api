package com.example.board.service;

import com.example.board.dto.*;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.common.exception.NoDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	 * 게시글 수정
	 * @param requestDto
	 * @return
	 */
	public UpdateBoardResponse update(UpdateBoardRequest requestDto) {
		Board board = boardRepository.findById(requestDto.getId()).orElseThrow(NoDataException::new);
		board = board.toBuilder().id(board.getId()).build();

		return UpdateBoardResponse.builder()
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

	/**
	 * 게시글 목록 조회
	 * @return
	 */
	public List<BoardListResponse> findAll() {
		List<Board> boardList = boardRepository.findAll();

		return BoardListResponse.fromEntityList(boardList);
	}

	/**
	 * 게시글 삭제
	 * @param id
	 * @return
	 */
	public Long delete(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(NoDataException::new);
		boardRepository.delete(board);

		return board.getId();
	}

}