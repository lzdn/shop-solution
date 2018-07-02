package com.xiangqin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xiangqin.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
