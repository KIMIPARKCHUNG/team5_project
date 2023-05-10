package com.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Emp;
import com.spring.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmpAPIController {
	final EmpService empService;
	@RequestMapping(value = "/api/emp/{empno}", method = RequestMethod.GET)
	public Emp getAPIempByEmpno(@PathVariable int empno) throws Exception {
		Emp emp = empService.getEmpByEmpno(empno);
		if(emp== null) {
			throw new Exception("존재하지 않는 부서입니다.");
		}	
		System.out.println(emp);
		return emp;
		
	}
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
