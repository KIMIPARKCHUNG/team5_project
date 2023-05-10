package com.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Dept;
import com.spring.service.DeptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeptAPIController {

		final DeptService deptService;// 이것이 훨씬 안전하다.
		
		//
		@RequestMapping(value = "/api/dept/{deptno}",
				method =RequestMethod.GET)		
		public Dept getAPIDeptByDeptno(@PathVariable int deptno) throws Exception {
			Dept dept = deptService.getDeptByDeptno(deptno);
			if(dept!= null) {
				throw new Exception("이미 존재하는 부서번호 입니다.");
			}	
			return dept;
		}
		//exception handler
		
		@ExceptionHandler(value = {Exception.class})
		public ResponseEntity<String> handleException(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
