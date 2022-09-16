package com.example.board.unit.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

	@InjectMocks
	BoardService boardService;

	@Mock
	BoardRepository boardRepository;

	@Test
	@DisplayName("게시글 삭제 테스트")
	void delete() {
		// given
		when(boardRepository.findById(1L)).thenReturn(Optional.ofNullable(Board.builder().id(1L).build()));

		// when
		Long deleteComment = boardService.delete(1L);

		// then
		assertThat(deleteComment).isEqualTo(1L);
	}

}