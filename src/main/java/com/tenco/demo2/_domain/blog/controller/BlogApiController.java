package com.tenco.demo2._domain.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo2._domain.blog.dto.ArticleDTO;
import com.tenco.demo2._domain.blog.entity.Article;
import com.tenco.demo2._domain.blog.service.BlogService;
import com.tenco.demo2.common.ApiUtill;
import com.tenco.demo2.common.errors.Exception400;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController // @Controller + @responsebody
public class BlogApiController {

	private final BlogService blogService;
	
	// URL , 즉, 주소 설계 - http://localhost:8080/api/articles
	@PostMapping("/api/articles")
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
		// 1. 인증 검사
		// 2. 유효성 검사
		Article savedArticle = blogService.save(dto);		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
	}
	
	// URL , 즉, 주소 설계 - http://localhost:8080/api/articles
	@GetMapping(value = "/api/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiUtill<?> getAllArticles() {
		
		List<Article> articles = blogService.findAll();
		if(articles.isEmpty()) {
			// return new ApiUtill<>(new Exception400("게시글이 없습니다."));
			throw new Exception400("게시글이 없습니다.");
		}
		
		return new ApiUtill<>(articles);
	}
	
	
	// URL , 즉, 주소 설계 - http://localhost:8080/api/articles
	@GetMapping(value = "/api/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiUtill<?> getAllArticles() {
		List<Article> articles = blogService.findAll();
		if(articles.isEmpty()) {
			// return new ApiUtil<>(new Exception400("게시글이 없습니다."));
			throw new Exception400("게시글이 없습니다.");
		}
		return new ApiUtill<>(articles);
	}
	
	
	
}
	
