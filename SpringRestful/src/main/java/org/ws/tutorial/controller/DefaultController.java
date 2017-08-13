package org.ws.tutorial.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.ws.tutorial.model.Employee;
import org.ws.tutorial.services.ListEmployeeService;
import org.ws.tutorial.utility.sort.JsonObjectConverter;
import org.ws.tutorial.utility.sort.SortByType;
import org.ws.tutorial.utility.sort.SortByType.SortByName;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class DefaultController {
	
	private static final Logger logger = Logger.getLogger(DefaultController.class);
	@Autowired
	private ListEmployeeService service;
	
	@RequestMapping(value="/getAllEmployee",produces={"application/json"})
	@ResponseBody
	@GET
	public String getAllEmployees() throws JsonProcessingException
	{
		List<Employee> list = service.getAllEmployees(0, 100);
		return JsonObjectConverter.mapToJson(list);
	}
	
	@RequestMapping(value="/getAllEmployee/sortbyname",produces=MediaType.APPLICATION_JSON,consumes=MediaType.APPLICATION_JSON)
	@ResponseBody
	@POST
	public String sortByName(@RequestBody String json) throws JsonMappingException, IOException{
		List<Employee> list = JsonObjectConverter.mapFromJson(json.toString(), new TypeReference<List<Employee>>() {});
		list.sort(new SortByType.SortByName());
		return JsonObjectConverter.mapToJson(list);
	}

	@RequestMapping(value="/getAllEmployee/sortbyHireDate",produces=MediaType.APPLICATION_JSON,consumes=MediaType.APPLICATION_JSON)
	@ResponseBody
	@POST
	public String sortByHireDate(@RequestBody String json) throws JsonMappingException, IOException{
		List<Employee> list = JsonObjectConverter.mapFromJson(json.toString(), new TypeReference<List<Employee>>() {});
		list.sort(new SortByType.SortByHiringDate());
		return JsonObjectConverter.mapToJson(list);
	}

	@RequestMapping(value="/getPages",produces={"application/json"})
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	@GET
	public Long getTotalPage(){
	//	Long total = Long.parseLong(service.getTotalPages().toString());
		Long total = 300024L;
		total = (total/100)+1;
		return total;
	}

	@RequestMapping(value="/getAllEmployee/getPage/{page}",produces={"application/json"})
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	@GET
	public List<Employee> getNextEmployees(@PathVariable("page") String val)
	{
		logger.debug(val);
		int startIndex = (Integer.parseInt(val) * 100);
			return service.getAllEmployees(startIndex, 100);
	}
	
	@RequestMapping(value="/{id}", headers="Accept=application/json",produces={"application/json"})
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	@GET
	public Employee searchEmployee(@PathVariable("id") int id)
	{
		return service.getEmployee(id);
	}
}
