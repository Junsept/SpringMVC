package com;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@SuppressWarnings("deprecation")
public class TestInterceptorController extends MultiActionController {

	public String show(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("date", new Date());
		return "show";
	}
}
