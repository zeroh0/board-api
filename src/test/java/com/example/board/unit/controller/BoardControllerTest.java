package com.example.board.unit.controller;

import com.example.board.controller.BoardController;
import com.example.board.dto.CreateBoardRequest;
import com.example.board.dto.CreateBoardResponse;
import com.example.board.service.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

	@InjectMocks
	BoardController boardController;

	@Mock
	BoardService boardService;

	@Test
	@DisplayName("게시글 작성 테스트")
	void save() {
		// given
		CreateBoardRequest requestDto = CreateBoardRequest.builder()
			.title("게시글 제목 테스트")
			.cont("게시글 내용 테스트")
			.build();

		when(boardService.save(requestDto)).thenReturn(CreateBoardResponse.builder().id(1L).build());

		// when, then
		Assertions.assertThat(boardController.save(requestDto).getBody().getId()).isEqualTo(1L);
	}

	@Test
	@DisplayName("게시글 삭제 테스트")
	void delete() {
		// given
		when(boardService.delete(1L)).thenReturn(null);

		// when, then
		boardController.delete(1L);
	}

}