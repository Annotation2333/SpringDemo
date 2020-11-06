package com.example.spring.web.rest.vm;

import com.example.spring.domain.Employee;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeCreateVM {

    @NotNull
    @ApiModelProperty(value = "员工id")
    private String id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "工资")
    private BigDecimal salary;

    public Employee vmToDaoDomain() {
        return Employee.builder().id(id).name(name).age(age).sex(sex).salary(salary.longValue()).build();
    }

}
