package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id; //pk
	
	@Column(nullable = false, length = 100)
	private String title; //제목
	
	@Lob //대용량 데이터
	private String content; //내용 //섬머노트 라이브러리사용<Html>태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne (fetch = FetchType.EAGER)// Many = Board, User = One (한명의 유저는 여러가지 게시글을 쓸수 있다)//User 에 id를 참조한다
	@JoinColumn(name = "userId")
	private User user;  //DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy ="board", fetch = FetchType.EAGER)//mappedBy 연관간계의 주인이 아님(FK가 아님)DB에 컬럼을 만들기 X
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate; //게시시간
}
