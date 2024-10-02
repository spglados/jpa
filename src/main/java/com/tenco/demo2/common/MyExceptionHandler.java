package com.tenco.demo2.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.demo2.common.errors.Exception400;
import com.tenco.demo2.common.errors.Exception401;
import com.tenco.demo2.common.errors.Exception403;
import com.tenco.demo2.common.errors.Exception404;
import com.tenco.demo2.common.errors.Exception500;

// RuntimeException 터지면 해당 파일로 오류가 모인다. 
@RestControllerAdvice // C.A --> 뷰 에러페이, R.C.A 데이터 반환 (에러)
public class MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(Exception400.class)
	public ResponseEntity<ApiUtill<Object>> ex400(Exception400 e) {
		logger.error("400 Error: {}", e.getMessage());
		ApiUtill<Object> apiUtil = new ApiUtill<>(400, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception401.class)
	public ResponseEntity<ApiUtill<Object>> ex401(Exception401 e) {
		logger.error("401 Error: {}", e.getMessage());
		ApiUtill<Object> apiUtil = new ApiUtill<>(401, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(Exception403.class)
	public ResponseEntity<ApiUtill<Object>> ex403(Exception403 e) {
		logger.error("403 Error: {}", e.getMessage());
		ApiUtill<Object> apiUtil = new ApiUtill<>(403, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception404.class)
	public ResponseEntity<ApiUtill<Object>> ex404(Exception404 e) {
		logger.error("404 Error: {}", e.getMessage());
		ApiUtill<Object> apiUtil = new ApiUtill<>(404, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception500.class)
	public ResponseEntity<ApiUtill<Object>> ex500(Exception500 e) {
		logger.error("500 Error: {}", e.getMessage());
		ApiUtill<Object> apiUtil = new ApiUtill<>(500, e.getMessage());
		return new ResponseEntity<>(apiUtil, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
