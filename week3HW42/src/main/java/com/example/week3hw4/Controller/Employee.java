package com.example.week3hw4.Controller;

import com.example.week3hw4.Apirespons.Apirespons;
import com.example.week3hw4.model.EmployeeData;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class Employee {
    ArrayList<EmployeeData> employees=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList getdata(){
        return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmp(@Valid @RequestBody EmployeeData employeeData , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Apirespons(message));
        }
        employees.add(employeeData);
        return ResponseEntity.status(200).body(new Apirespons("data added"));
    }
    @PostMapping("/update/{index}")
    public ResponseEntity updateEmp(@Valid @RequestBody EmployeeData employeeData,@PathVariable int id,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Apirespons(message));
        }
        employees.set(id,employeeData);
        return  ResponseEntity.status(HttpStatus.OK).body(new Apirespons("message"));
    }
    @DeleteMapping ("/delete/{index}")
    public ResponseEntity deleteEmp(@RequestBody EmployeeData employeeData,@PathVariable int id,Errors errors){
        employees.remove(id);
        return null;
    }
    @GetMapping("/onLeave/{index}")
    public ResponseEntity annualLeave(@PathVariable int index){
        for (int i=0,annualLeave.size().i++ )
            if (employees.get(i).getAnnuaLeave()==5){
                return ResponseEntity.status(400).body(new Apirespons("not leave"));
            employees.get(i).setAnnuaLeave(true);
            employees.get(i).setOnLeave(ONannull);
            }}
        return ResponseEntity.status(200).body(new Apirespons("leave"));


    }
}
