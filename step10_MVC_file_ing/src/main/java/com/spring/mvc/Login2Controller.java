package com.spring.mvc;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.Emp;
import com.spring.service.EmpService;

@Controller
public class Login2Controller {
	
	@Autowired
	EmpService empService;
	
//	@RequestMapping(value = "/login2", method = RequestMethod.GET)
//	public String loginForm() {
//		return "login2";
//	}
//	
}
