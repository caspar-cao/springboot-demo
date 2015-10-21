package com.jingyunbank.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jingyunbank.demo.springboot.dao.InvestRepo;

@Service("investService")
public class DefaultInvestService implements InvestService {

	@Autowired InvestRepo investRepo;
	
	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public String invest() {
		return investRepo.invest().toString();
	}

}
