package com.restdb.restjpa;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restdb.restjpa.Entitys.Employee;
import com.restdb.restjpa.Servicess.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService es;

    @PostMapping("/addemployee")
    public ResponseEntity postMethodName(@RequestBody Employee e) {
        //TODO: process POST request
        
    boolean res= es.create(e);
     if(res==true)
     {
      ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
     }

          

        return ResponseEntity.of(Optional.of("done ji"));
    }

    @GetMapping("showemployee")
    public ResponseEntity<List<Employee>> showemployee()
    {
       List<Employee> li= es.get();
       if(li==null)
       {
        ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

       return ResponseEntity.of(Optional.of(li));
    }

    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<Employee> updateemployee(@PathVariable int id,@RequestBody Employee e)
    {

      Employee emp= es.upate(id, e);
      if(emp.equals(null))
      {
        ResponseEntity.status(HttpStatus.NOT_FOUND);
      }

      return ResponseEntity.of(Optional.of(emp));

    }

    @DeleteMapping("deleteemployee/{id}")
    public ResponseEntity deleteemployee(@PathVariable int id)
    {
       boolean res= es.deletebyid(id);
       if(false)
       {
        ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
       }

       return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/deleteallemployee")
    public ResponseEntity deleteallemployee()
    {
      boolean  res=es.deleteall();

      if(res==false)
      {
        ResponseEntity.status(HttpStatus.NOT_MODIFIED);
      }
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    

}
