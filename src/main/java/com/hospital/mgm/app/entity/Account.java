package com.hospital.mgm.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table()
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long account_number;
private String account_Holder_name;
private Double account_balance;
}
