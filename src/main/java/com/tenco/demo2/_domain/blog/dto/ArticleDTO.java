package com.tenco.demo2._domain.blog.dto;

import com.tenco.demo2._domain.blog.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// 즉, 주로 계층간의 데이터 전송 목적으로 설계 된다.
public class ArticleDTO {
	
	private String title;
	private String content;
	
	// 여기서 AriticleDTO --> Article 데이터 타입을 변환 시키는
	// 메서드를 만들었다.
	public Article toEntity() {
		return Article.builder()
				.title(this.title)
				.content(this.content)
				.build();
	}

}
