package com.example.spring.service;


import com.example.spring.config.Constants;
import com.example.spring.domain.Employee;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.web.rest.vm.EmployeeCreateVM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
@Slf4j
public class EmpService {
    @Resource
    private EmployeeRepository employeeRepository;

    public Object createEmployee(EmployeeCreateVM employeeCreateVM){
        Employee employee = employeeCreateVM.vmToDaoDomain();
        employee.setDepartId("001");
        employee.setDelFlag(Constants.DEL_FLAG_NOT_DELETED);
        return employeeRepository.save(employee);
    }

}
