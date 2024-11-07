package com.restdb.restjpa.Servicess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restdb.restjpa.DAO.EmployeeDAO;
import com.restdb.restjpa.Entitys.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO ed;


    //create
    public boolean create(Employee e)
    {
      
       ed.save(e);

       return true;
    }

    //get
    public List<Employee> get()
    {
     List<Employee> li=ed.findAll();

     return li;
    }

    //update
    public Employee upate(int id,Employee e)
    {
       Optional<Employee> o= ed.findById(id);
       Employee emp=o.get();
       emp.setId(e.getId());
       emp.setName(e.getName());
       emp.setEmail(e.getEmail());
       ed.save(emp);
       return emp;

    }

    //deletebyid
    public boolean deletebyid(int id)
    {

       Optional<Employee> o= ed.findById(id);
      Employee e= o.get();
      ed.delete(e);

      return true;
    }

    //deleteall
    public boolean deleteall()
    {
         ed.deleteAll();

         return true;
    }
    
}
