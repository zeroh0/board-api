package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateBoardRequest {

	@NotNull(message = "제목을 입력해주세요.")
	private String title;

	@NotNull(message = "내용을 입력해주세요.")
	private String cont;

	public static Board toEntity(CreateBoardRequest createBoardRequest) {
		return Board.builder()
			.title(createBoardRequest.getTitle())
			.cont(createBoardRequest.getCont())
			.build();
	}

}