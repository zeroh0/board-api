package com.example.board.dto;

import com.example.board.entity.Board;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateBoardRequest {

	@NotNull
	private Long id;

	@NotNull(message = "제목을 입력해주세요.")
	private String title;

	@NotNull(message = "내용을 입력해주세요.")
	private String cont;

	public static Board toEntity(UpdateBoardRequest updateBoardRequest) {
		return Board.builder()
			.id(updateBoardRequest.getId())
			.title(updateBoardRequest.getTitle())
			.cont(updateBoardRequest.getCont())
			.build();
	}

}
