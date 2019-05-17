package com.cafe24.mysite.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
// Component는 Controller Advice의 부모클래스이다
// 에러가 났을경우 spring-servlet.xml에 설정된 base-package의 경로를 찾아  @ControllerAdvice가 설정된 컨트롤러의 
// @ExceptionHandler(Exception.class)가 설정된 메소드를 실행시킨다.
public class GlobalExceptionHandler {

//	mysite2의 예외는 다여기로 들어와서 처리됨
	@ExceptionHandler(Exception.class)
	public String handleUserDaoException( HttpServletRequest request, HttpServletResponse response, Exception e) 
			throws ServletException, IOException {
		
		//1. 로깅
		/*
		 * 오버로드가 되어 있기 때문에 FileWriter 를 이용해서 오류메세지를 파일에 작성해둘 수 있음.
		 * e.printStackTrace(FileWriter);
		 */
		e.printStackTrace(); 
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		//LOGGER.error(errors.toString()); -- 로거는 화면에도 뿌리고 파일에도 남길 수 있는 기능 추후에 배움
		System.out.println(errors.toString());
		
		
		//2. 안내페이지 가기 + 정상종료(response)
		request.setAttribute("uri", request.getRequestURI());
		request.setAttribute("exception", errors.toString());
		request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);;
		
		return "error/exception";
	}

}