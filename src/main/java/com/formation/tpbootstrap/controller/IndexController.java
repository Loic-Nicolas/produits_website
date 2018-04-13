package com.formation.tpbootstrap.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String indexGet(final ModelMap pModel) {
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String indexPost(final ModelMap pModel, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "index";
	}
	
}
