package com.example.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "제목을 입력해주세요.")
	@Column(name = "title", nullable = false)
	private String title;

	@NotBlank(message = "내용을 입력해주세요.")
	@Column(name = "cont", nullable = false, columnDefinition = "TEXT")
	private String cont;

	@Column(name = "view_cnt", columnDefinition = "integer default 0")
	private int viewCnt;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createAt;

	@UpdateTimestamp
	@Column(name = "update_at", nullable = false)
	private LocalDateTime updateAt;

	@Builder
	public Board(Long id, String title, String cont, int viewCnt, LocalDateTime createAt, LocalDateTime updateAt) {
		this.id = id;
		this.title = title;
		this.cont = cont;
		this.viewCnt = viewCnt;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Board board = (Board) o;
		return id.equals(board.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}