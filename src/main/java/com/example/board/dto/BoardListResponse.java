package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardListResponse {

	private Long id;

	private String title;

	private int viewCnt;

	private LocalDateTime createAt;

	public static List<BoardListResponse> fromEntityList(List<Board> boardList) {
		return boardList.stream()
			.map(board -> BoardListResponse.builder()
				.id(board.getId())
				.title(board.getTitle())
				.viewCnt(board.getViewCnt())
				.createAt(board.getCreateAt())
				.build())
			.collect(Collectors.toList());
	}

}