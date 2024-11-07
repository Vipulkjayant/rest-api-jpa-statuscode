package com.restdb.restjpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restdb.restjpa.Entitys.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

    
    
}
