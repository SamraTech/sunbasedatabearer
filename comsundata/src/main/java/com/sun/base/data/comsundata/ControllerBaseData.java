package com.sun.base.data.comsundata;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping
public class ControllerBaseData {
	private static String customerlist = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
	private static String deletecustomerByUUid = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=delete&uuid=testf877622062f74377abec4fde5904a677";
	private static String createcustomer = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create";
	private static String updatecustomerByUUid = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=update&uuid=test08d1a225e01e4c7c841bebaa99466212";
	
	@Autowired
	private RestTemplate template;
	HttpHeaders headers = new HttpHeaders();

	
	@GetMapping("/token")
	public ModelAndView getCustomerList() {
		// headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		// headers.
		headers.set("Authorization", "Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> responseTC = template.exchange(customerlist, HttpMethod.GET, request, String.class);
		System.out.println(responseTC.getBody());
		String body = responseTC.getBody();
		
		ModelAndView view=new ModelAndView("customerlist");
		view.addObject("listcustomer", body)
;		return view;
	}

	@GetMapping("/delete")
	public String deleteCustomerByUUid() {
		headers.set("Authorization", "Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity responseTC = template.exchange(deletecustomerByUUid, HttpMethod.POST, request, String.class);
		System.out.println(responseTC.getBody());
		System.out.println("deleted successfully");

		return "deleted successFully";

	}

	@GetMapping("/create")
	public String createCustomer() {
		headers.set("Authorization", "Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");
		// HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("first_name", "Aisha");
		requestBody.put("last_name", "Momin");
		requestBody.put("email", "aisha@gmail.com");
		requestBody.put("title", "Hello World");

		HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

		

		ResponseEntity responseEntity = template.postForEntity(createcustomer, requestEntity, String.class);
		System.out.println(responseEntity.getBody());
		// HttpEntity<String> request = new HttpEntity<String>(headers);
		// ResponseEntity responseTC = temlate.exchange(createcustomer, HttpMethod.POST,
		// request, String.class);
		// System.out.println(responseTC.getBody());
		System.out.println("created successfully");
		// temlate.postForObject(createcustomer, HttpMethod.POST, String.class,
		// uriVariables);
		return "created customer";

	}

	@GetMapping("/update")
	public String updateCustomerByUUid() {
		headers.set("Authorization", "Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity responseTC = template.exchange(updatecustomerByUUid, HttpMethod.POST, request, String.class);
		System.out.println(responseTC.getBody());
		System.out.println("deleted successfully");

		return "Updated SuccessFully";

	}

}
