package com;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pojo.Product;

@Controller
public class IndexController{
	
	@RequestMapping("/addProduct")
	public String add(Product product, RedirectAttributes model){
		model.addFlashAttribute("name", product.getName());
		return "redirect:/showProduct";		
	}
	
	@RequestMapping("/showProduct")
	public String show(@ModelAttribute("name") String name, Model model){	
		System.out.println(name);
		model.addAttribute("name", name);
		return "show";
	}
	
	@RequestMapping("/check")
	public String check(HttpSession session){
		Integer count = (Integer)session.getAttribute("count");
		if(count == null){
			count = 0;
		}
		count++;
		session.setAttribute("count", count);
		return "show";		
	}
}
