package com.jingyunbank.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jingyunbank.demo.springboot.service.InvestService;

@RestController
public class InvestController {

	@Autowired InvestService investService;
	
	@RequestMapping("/invest")
	public String invest(){
		return investService.invest();
	}
}
