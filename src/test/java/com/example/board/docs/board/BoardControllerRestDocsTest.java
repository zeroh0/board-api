package com.example.board.docs.board;

import com.example.board.controller.BoardController;
import com.example.board.docs.RestDocsTemplate;
import com.example.board.dto.BoardListResponse;
import com.example.board.service.BoardService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BoardControllerRestDocsTest extends RestDocsTemplate {

	private final BoardService boardService = mock(BoardService.class);

	@Override
	protected Object initController() {
		return new BoardController(boardService);
	}

	@DisplayName("전체 게시글을 조회하는 API")
	@Test
	void 전체_게시글을_조회하는_API() throws Exception {
		List<BoardListResponse> response = Lists.newArrayList(
				new BoardListResponse(1L, "제목1", 0, LocalDateTime.now()),
				new BoardListResponse(2L, "제목2", 0, LocalDateTime.now()),
				new BoardListResponse(3L, "제목3", 0, LocalDateTime.now()),
				new BoardListResponse(4L, "제목4", 0, LocalDateTime.now()),
				new BoardListResponse(5L, "제목5", 0, LocalDateTime.now())
		);

		when(boardService.findAll()).thenReturn(response);

		mockMvc.perform(get("/api/board"))
				.andExpect(status().isOk())
				.andDo(document("boards/get-all",
						preprocessResponse(prettyPrint()),
						responseFields(
								fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("게시글 ID"),
								fieldWithPath("[].title").type(JsonFieldType.STRING).description("게시글 제목"),
								fieldWithPath("[].viewCnt").type(JsonFieldType.NUMBER).description("게시글 조회수"),
								fieldWithPath("[].createAt").type(JsonFieldType.STRING).description("게시글 작성일")
						)
				));
	}

}
