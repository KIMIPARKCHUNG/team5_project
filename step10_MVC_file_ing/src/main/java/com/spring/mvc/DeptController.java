package com.spring.mvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.AttachmentFile;
import com.spring.dto.Dept;
import com.spring.service.AttachmentFileService;
import com.spring.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class DeptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService service;
	
	@Autowired
	private AttachmentFileService  fileService;
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
	public String getDeptByDeptno(@PathVariable int deptno, 
								  Model model) {
		Dept dept = service.getDeptByDeptno(deptno);
		AttachmentFile attachmentFile = fileService.getAttachmentFileByDeptNo(deptno);
		// 해당 부서의 파일 출력 로직 추가!!!
		System.out.println(attachmentFile);
		model.addAttribute("dept", dept);
		model.addAttribute("file", attachmentFile);
		return "deptDetail";
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/api/dept/{deptno}", method = RequestMethod.GET)
//	public ResponseEntity<String> checkDeptByDeptno(@PathVariable int deptno, 
//								  Model model) {
//		Dept dept = service.getDeptByDeptno(deptno);
//	
//		if(dept != null) {
//			
//			return  new ResponseEntity<String>("이미 존재하는 부서입니다", HttpStatus.OK);
//			
//		}
//		else {
//		
//			return  new ResponseEntity<String>("새로운 부서번호로 사용할 수 있습니다.", HttpStatus.OK);
//		}
//		
//	}
	
	// http://localhost:8082/dept
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "registerDept";
	}
	
	// http://localhost:8082/dept
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public String insertDept(@ModelAttribute Dept newDept,
							 @RequestParam("file") MultipartFile file,
							 Model model) {
		String view = "error";
		
		System.out.println(newDept);
		System.out.println(file.getOriginalFilename());
		boolean fileResult = false;
		boolean deptResult = false;
		try {
			/*
			 고려사항) 논리적인 흐름 : dept 저장 + file 저장 => insertDept 한번에 같이 개발	
			 				-> 추후 발생할 수 있는 문제 : file만 저장하고 싶은데 반드시 + dept 함께 저장해야만 함
			 		=> 확장성을 고려하여 fileService 별도의 로직을 구성하는 것이 합당
			 */
			deptResult = service.insertDept(newDept);
		 fileResult =	fileService.insertAttachmentFile(file, newDept.getDeptno());
		 if(deptResult && fileResult) {
				// version 1
////			view = "main";
////			model.addAttribute("deptList", service.getAllDepts());
//			
			// version2 
			view = "redirect:/main";
			return view;
		 }
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		// service.inserDept 성공하면 -> main, 실패하면 -> error
//		boolean result = false;
//		
//		try {
//			result = service.insertDept(newDept);
//			
//			// step01 : 파일 저장 로직도 추가 생성!!!
//		
//			if(result) {
//				// version 1
////				view = "main";
////				model.addAttribute("deptList", service.getAllDepts());
//				
//				// version2 
//				view = "redirect:/main";
//				return view;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return view;
//		}
		
		return view;
	}
	
	// http://localhost:8082/modify/dept/10
	@RequestMapping(value = "/modify/dept/{deptno}", method = RequestMethod.GET)
	public String updateDeptForm(@PathVariable int deptno,
								Model model) {
		Dept dept = service.getDeptByDeptno(deptno);
		
		model.addAttribute("dept", dept);
		
		return "updateDept";
	}
	
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.PUT)
	public String updateDept(@PathVariable int deptno,
							@ModelAttribute("dname") String dname,
							@ModelAttribute("loc") String loc) {
		String view = "error";
		// dname, loc 확인 O
		// deptno로 기존 dept 객체 확인 -> 위에서 확인한 dname, loc 해당 객체 setter
		// 제대로 update가 되었다고 한다면 -> dept/{deptno} detail 페이지로 이동
		boolean result = false;
		
		Dept dept = service.getDeptByDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		
		try {
			 result = service.updateDnameAndLoc(dept);
			 
			 if(result) {
//				 view = "redirect:/dept/" + deptno;
				 return "redirect:/dept/" + deptno;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.DELETE)
	public String deleteDept(@PathVariable int deptno) {
		String view = "error";
		
		System.out.println(deptno);
		
		boolean result = false;
		
		try {
			// deleteDeptByDeptno(int deptno)
			result = service.deleteDeptByDeptno(deptno);
			
			if(result) {
				view = "redirect:/main";
				return view;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	
//	// 예외 step02 : LoginController 내부에서 발행하는 모든 NPE 처리
//	@ExceptionHandler({Exception.class})
//	public ModelAndView nullPointerExceptionHandler(Exception exception) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("exception", exception);
//		mv.setViewName("error");
//		return mv;
//	}
//	@GetMapping("/file/{filename}")
//	public ResponseEntity<Resource> loadFile(@PathVariable("attachmentFileNo") String filename){
//		// 지정 경로의 특정 파일 선택 -> resource로 변경 -> Http Header 컨텐츠의 타입 지정 후 전달 
//		
//		Path path = Paths.get("C:\\multi\\00.spring\\"+filename);
//		Resource resource = null;
//		try {
//			resource = new InputStreamResource(Files.newInputStream(path));
//		} catch (IOException e) {
//			e.printStackTrace();
////			log.error(e.getMessage());
//		}
//		
//		// 
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		headers.setContentDisposition(ContentDisposition
//													.builder("attachment")
//													.filename("filename")
//													.build());
//		
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
	
}
