package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {

	private Long id;

	private String title;

	private String cont;

	private int viewCnt;

	private LocalDateTime createAt;

	public static BoardResponse fromEntity(Board board) {
		return BoardResponse.builder()
			.id(board.getId())
			.title(board.getTitle())
			.cont(board.getCont())
			.viewCnt(board.getViewCnt())
			.createAt(board.getCreateAt())
			.build();
	}

}