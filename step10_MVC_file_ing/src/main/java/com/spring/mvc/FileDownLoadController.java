package com.spring.mvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.AttachmentFile;
import com.spring.dto.Dept;
import com.spring.dto.EmailFile;
import com.spring.service.AttachmentFileService;
import com.spring.service.EmailFileService;

@Controller
public class FileDownLoadController {
	@Autowired
	EmailFileService emailFileService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public @ResponseBody String UpLoadFile(
			 @RequestParam("file") MultipartFile file) {
		
		
		
		EmailFile emailFile= null;
		Resource resource = null;
		Path path = null;
		HttpHeaders headers =null;
		boolean fileResult = false;
		try {
			
			fileResult =	emailFileService.insertEmailFile(file, 12116);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "login";
		
		// 
		
	
		
	}

	
	@RequestMapping(value = "/download/file/{file_id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Resource> downloadEmailFile(@PathVariable("file_id") int file_id) {

		
	 
		EmailFile emailFile= null;
		Resource resource = null;
		Path path = null;
		HttpHeaders headers =null;
		try {
			emailFile = emailFileService.getEmailFileByFileId(file_id);
			
				String filePath = emailFile.getPath();
				path = Paths.get(filePath+"\\"+emailFile.getUuid());
				System.out.println(path);
				resource = new InputStreamResource(Files.newInputStream(path));
				headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDisposition(ContentDisposition
															.builder("EmailFile")
															.filename(emailFile.getFile_subject())
															.build());
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		// 
		
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		
	}
}
