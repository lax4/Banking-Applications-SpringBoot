package com.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.model.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {

}
