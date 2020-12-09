package com.example.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.regex.Pattern;

@Entity
@Table(name = "t_employee")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Pattern pattern = Pattern.compile("^((0{1}\\.\\d{1,})|([1-9]\\d*\\.{1}\\d{1,})|([1-9]+\\d*)|0)$");

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "depart_id")
    private String departId;

    @Column(name = "del_flag")
    private Integer delFlag;


}
