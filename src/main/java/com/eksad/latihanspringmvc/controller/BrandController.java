package com.eksad.latihanspringmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.eksad.latihanrest.model.Product;
import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;

@Controller
@RequestMapping("/brand")
public class BrandController 
{
	@Autowired
	private BrandRepositoryDAO brandRepositoryDAO;
	
	@RequestMapping("")
	public String index(Model model)
	{
		List<Brand> list= brandRepositoryDAO.findAll();
		
		model.addAttribute("listBrand", list);
		
		return "listBrand";
	}
	
	@RequestMapping("/add")
	public String addBrand(Model model)
	{
		Brand brand = new Brand();
		
		model.addAttribute("brand", brand);
		
		return "addBrand";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save (@ModelAttribute Brand brand)
	{
		brandRepositoryDAO.save(brand);
		
		return "redirect:/brand";
	}

		
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public String editbrand(@PathVariable Long id, Model model) 
	
	{
			Brand brand =  brandRepositoryDAO.findOne(id);
			model.addAttribute("brand", brand);
			return "addBrand";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deletebrand(Brand brand) 
	{
		brandRepositoryDAO.delete(brand);
		
		return "redirect:/brand";
	}
}
