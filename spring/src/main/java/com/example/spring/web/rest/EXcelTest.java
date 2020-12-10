package com.example.spring.web.rest;

import com.example.spring.service.ExcelService;
import com.example.spring.web.rest.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "excel相关接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class EXcelTest {

    @Resource
    private ExcelService excelService;

    @ApiOperation(value = "不使用模板")
    @GetMapping("/excel")
    public ResultBody getExcel(){
        return ResultBody.success(excelService.getClass());
    }
}
