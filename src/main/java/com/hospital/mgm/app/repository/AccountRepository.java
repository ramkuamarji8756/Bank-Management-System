package com.hospital.mgm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.mgm.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>
{
	

}
