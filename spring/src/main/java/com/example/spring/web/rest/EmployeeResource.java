package com.example.spring.web.rest;

import com.example.spring.service.EmpService;
import com.example.spring.web.rest.exception.ExceptionEnum;
import com.example.spring.web.rest.result.ResultBody;
import com.example.spring.web.rest.vm.EmployeeCreateVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "employee-resource 员工相关接口")
@RestController
@RequestMapping("/api")
public class EmployeeResource {

    @Resource
    private EmpService empService;


    @ApiOperation(value = "创建员工接口", notes = "返回员工实体")
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeCreateVM employeeCreateVM){

        Object result = empService.createEmployee(employeeCreateVM);
        if (result == null){
            return ResponseEntity.ok().body(ResultBody.exception(ExceptionEnum.EXCEPTION,"employee-create-failure"));
        }
        return ResponseEntity.ok().body(result);
    }

}


