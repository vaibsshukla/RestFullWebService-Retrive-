package org.ws.tutorial.wc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.ws.tutorial.wc.model.CustomPaginated;
import org.ws.tutorial.wc.model.Employee;
import org.ws.tutorial.wc.model.PaginatedExtended;

@Controller
public class Home {
	
	@Autowired
	private PaginatedExtended page;
	
	@RequestMapping("/home")
	public String home(){
		System.out.println("Controller");
		return "index";
	}
	@RequestMapping(value="/getall")
	public ModelAndView getEmployee(){
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/first/getAllEmployee";
		String getPageUrl = "http://localhost:8080/first/getPages";
		Integer totalPage = template.getForObject(getPageUrl, Integer.class);
		List<Employee> employees = template.getForObject(url, List.class);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
//		CustomPaginated page = new CustomPaginated();
		page.setFullListSize(totalPage);
		page.setList(employees);
		page.setObjectsPerPage(100);
		page.setPageNumber(1);
		mv.addObject("page",page);

		return mv;
	}

	@RequestMapping("/getPage")
	public ModelAndView Next(@RequestParam("page") String pageno){
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:8080/first/getAllEmployee/getPage/"+pageno;
		String getPageUrl = "http://localhost:8080/first/getPages";
		Integer totalPage = template.getForObject(getPageUrl, Integer.class);
		List<Employee> employees = template.getForObject(url, List.class);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");
		
//		page.setFullListSize(totalPage);
		page.setList(employees);
//		page.setObjectsPerPage(100);
		page.setPageNumber(Integer.parseInt(pageno));
		mv.addObject("page",page);
		return mv;
	}
}
