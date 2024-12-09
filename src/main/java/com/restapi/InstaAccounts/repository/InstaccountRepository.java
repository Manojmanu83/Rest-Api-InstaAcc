package com.restapi.InstaAccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.InstaAccounts.dto.InstaAccount;

public interface InstaccountRepository extends JpaRepository<InstaAccount, Integer>{

}
