package com.example.spring.service;


import com.alibaba.excel.metadata.Sheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ExcelService {

    public File getExcel(){
        File file = new File("");

        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet");
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 我们开始定义一个存放表头的数据
        // 存放表头数据,直接add表头数据即可
        List<String> head = new ArrayList<>();
        //也可以多定义几个head 进行多行表头

        //将head填装到list 即可
        List<List<String>> list = new ArrayList<>();
        head.forEach(h -> list.add(Collections.singletonList(h)));
        sheet.setHead(list);
        return file;
    }


    /**
     * 设置表内数据
     */


}
