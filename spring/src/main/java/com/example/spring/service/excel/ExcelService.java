package com.example.spring.service.excel;


import com.alibaba.excel.EasyExcel;
import com.example.spring.config.Constants;
import com.example.spring.service.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ExcelService {

    public File exportTest(){
        String fileName;
        fileName = "导出测试" + Constants.dtfd2.format(LocalDate.now()) + ".xlsx";
        //获取数据源
        List<DemoData> data = data();
        File file = new File(FileUtil.getRandomTempPath() + File.separator + fileName);
        int[] mergeColumeIndex = {0,1,2};
        // 从那一行开始合并
        int mergeRowIndex = 1;
        try {
            FileUtils.touch(file);
            OutputStream out = new FileOutputStream(file);
            EasyExcel.write(out,  DemoData.class).sheet("采购部件明细").
                    registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex)).doWrite(data);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取数据的地方
     */

    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
