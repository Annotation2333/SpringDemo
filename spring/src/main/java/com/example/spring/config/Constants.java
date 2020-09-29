package com.example.spring.config;

import java.io.File;
import java.time.format.DateTimeFormatter;

/**
 * Application constants.
 * 该常量类后续主要记录业务模块相关的常量
 * @author sakura
 * @create 2020-09-30 2:16
 */
public final class Constants {

    public static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_TIME_MINUTE_FORMAT = "yyyy/MM/dd HH:mm";

    public static final String DATE_TIME_FORMAT_MID = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_FORMAT_DAY = "yyyy/MM/dd";

    public static final String DATE_TIME_FORMAT_DAY2 = "yyyyMMdd";

    public static final String DATE_TIME_FORMAT_DAY3 = "yyyy-MM-dd";

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final DateTimeFormatter dtfm = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_MID);
    public static final DateTimeFormatter dtfd = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_DAY);
    public static final DateTimeFormatter dtfd2 = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_DAY2);
    public static final DateTimeFormatter minuteDtf = DateTimeFormatter.ofPattern(DATE_TIME_MINUTE_FORMAT);

    public  static final String FILE_DIR = "file";
    /**
     * EXCEL模板文件保存目录
     */
    public static final String TEMPLATES_EXCEL_FILE_DIR = FILE_DIR + File.separator + "excel";

    /**
     * 文件名分隔符
     */
    public static final String FILE_SEPARATOR = "_";

    /**
     * excel导出文件名后缀
     */
    public static final String EXCEL_EXPORT_FILE_NAME_SUFFIX = ".xlsx";

    //删除标志位
    public static final Integer DEL_FLAG_NOT_DELETED = 0;

    public static final Integer DEL_FLAG_DELETED = 1;

}
