package com.example.spring.service;


import com.example.spring.web.rest.vm.EmployeeCreateVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpService {


    public Object createEmployee(EmployeeCreateVM employeeCreateVM){

        return null;
    }

}
