package com.example.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_employee")
@Data
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
