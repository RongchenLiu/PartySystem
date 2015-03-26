package cn.edu.cqu.party.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UserController {
	@RequestMapping("/user/upload.do")
	public String upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver  = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			
			Iterator<String>  iter = multiRequest.getFileNames();
			while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile((String)iter.next());
				if(file != null){
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = "D:/" + fileName;
					
					File localFile = new File(path);
					
					file.transferTo(localFile);
				}
				
			}
			
			
			
		}
		return "/user/success";
	}
	
	@RequestMapping("/user/toUpload.do")
	public String toUpload(){
		System.out.println("---1111---");
		return "/user/upload";	}
}
