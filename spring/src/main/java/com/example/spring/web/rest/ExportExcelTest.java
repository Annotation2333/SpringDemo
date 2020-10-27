package com.example.spring.web.rest;

import com.example.spring.service.excel.ExcelService;
import com.example.spring.service.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@Api(tags = "EasyExcel使用")
@RequestMapping("/api")
public class ExportExcelTest {
    @Resource
    private ExcelService excelService;

    @ApiOperation(value = "使用easyExcel导出表格", notes = "返回单元格合并后的表格")
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        File file = excelService.exportTest();
        if (file != null) {
            FileUtil.download(response, file.getPath(), file.getName());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
