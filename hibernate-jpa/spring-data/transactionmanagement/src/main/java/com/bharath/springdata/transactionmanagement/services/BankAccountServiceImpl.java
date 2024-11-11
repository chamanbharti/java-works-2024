package com.bharath.springdata.transactionmanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.springdata.transactionmanagement.entities.BankAccount;
import com.bharath.springdata.transactionmanagement.repos.BankAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transfer(int amount) {
		Optional<BankAccount> obamasAccountOpt = repository.findById(1);
		if (obamasAccountOpt.isPresent()) {
			BankAccount obamasAccount = obamasAccountOpt.get();
			obamasAccount.setBal(obamasAccount.getBal() - amount);
			repository.save(obamasAccount);
		}

		if (true) {
			throw new RuntimeException();
		}
		Optional<BankAccount> trumpsAccountOpt = repository.findById(2);
		if (trumpsAccountOpt.isPresent()) {
			BankAccount trumpsAccount = trumpsAccountOpt.get();
			trumpsAccount.setBal(trumpsAccount.getBal() + amount);
			repository.save(trumpsAccount);
		}
	}

}
