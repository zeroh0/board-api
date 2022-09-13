package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponse {

	private Long id;

	private String title;

	private int viewCnt;

	private LocalDateTime createAt;

	public static BoardResponse fromEntity(Board board) {
		return BoardResponse.builder()
			.id(board.getId())
			.title(board.getTitle())
			.viewCnt(board.getViewCnt())
			.createAt(board.getCreateAt())
			.build();
	}

}