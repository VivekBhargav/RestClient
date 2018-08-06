package com.task22.RestClient.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.task22.RestClient.pojo.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerCliController {

	static String URL = "http://localhost:8080/customer";

	@ModelAttribute("customer")
	public Customer construct() {
		return new Customer();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView customerPage() {
		return new ModelAndView("customer");
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer() {
		return new ModelAndView("addCustomer");
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView addedCustomer(@ModelAttribute("customer") Customer customer) {
		ModelAndView mv = new ModelAndView("error");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer);
		ResponseEntity<?> response = restTemplate.exchange(URL + "/", HttpMethod.POST, entity, Customer.class);
		if (response.getStatusCode() == HttpStatus.CREATED) {
			mv.setViewName("success");
		}
		return mv;
	}

	@RequestMapping(value = "/delCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer() {
		return new ModelAndView("/delCustomer");
	}

	@RequestMapping(value = "/delCustomer/{id}", method = RequestMethod.POST)
	public ModelAndView deletedCustomer(@RequestParam("id") int custId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + "/" + custId);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/updCustomer", method = RequestMethod.GET)
	public ModelAndView updateCustomer() {
		return new ModelAndView("updCustomer");
	}

	@RequestMapping(value = "/updCustomer", method = RequestMethod.POST)
	public ModelAndView updatedCustomer(@ModelAttribute("customer") Customer customer) {
		ModelAndView mv = new ModelAndView("error");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer);
		ResponseEntity<?> response = restTemplate.exchange(URL + "/", HttpMethod.PUT, entity, Customer.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			mv.setViewName("success");
		}
		return mv;
	}

	@RequestMapping(value = "/loadCustomer", method = RequestMethod.GET)
	public ModelAndView loadCustomer() {
		return new ModelAndView("loadCustomer");
	}

	@RequestMapping(value = "loadCustomer/{id}", method = RequestMethod.POST)
	public ModelAndView loadedCustomer(@RequestParam("id") int custId) {
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView mv = new ModelAndView("error");
		Customer cust = restTemplate.getForObject(URL + "/" + custId, Customer.class, HttpMethod.GET);
		if (cust != null) {
			mv.addObject("customer", cust);
			mv.setViewName("success");
		}
		return mv;
	}

	@RequestMapping(value = "listCustomers", method = RequestMethod.GET)
	public ModelAndView listedCustomers() {
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView mv = new ModelAndView("error");
		ResponseEntity<List<Customer>> response = restTemplate.exchange(URL + "/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		if (response != null) {
			mv.addObject("customer", response.getBody().toString());
			mv.setViewName("success");
		}
		return mv;
	}
}
