package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller sebagai rooter kita

@Controller
public class HelloController
{
	
	//function requestmapping adalah untuk mapping url kita
	//responseBody itu untuk menampilkan url yang kita buat
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() 
	{
		return "Hello World";
	}
	
	@RequestMapping("/myName")
	@ResponseBody
	//Requestparam berfungdi untuk menentukan parameter dengan tanda tanya (?) untuk local host
	public String myName(@RequestParam String myName) 
	{
		return "Hello " + myName;
		// saat dirunning kemudian dibuka local host nya : http://localhost:8080/myName?myName=anggi
	}
	
	@RequestMapping("/NamaSaya/{myName}")
	@ResponseBody
	//@pathvariable memiliki fungsi yang sama dengan request param dimana variabel wajib diisi dan menampilkan sebagian dari host kita
	public String NamaSaya(@PathVariable String myName) 
	{
		return "Hello " + myName;
	
	}
	
	@RequestMapping("/toTwitter")
	@ResponseBody
	public String toTwitter() 
	{
		return "<a href = 'https://www.twitter.com' target= '_blank'> Klik disini menuju twitter </a> "
				+ "</br> </br> <a href = 'https://www.youtube.com' target= '_blank'> Klik disini menuju youtube </a>";
	
	}
	
}
