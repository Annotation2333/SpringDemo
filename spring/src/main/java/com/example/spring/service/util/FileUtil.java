package com.example.spring.service.util;

import com.example.spring.config.Constants;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileUtil {

    private static final String HIMP_TEMP_DIR = "himptemp";
    /**
     * 下载通用方法
     * 会删除path对应的文件
     * @param response 接口必须传入response
     * @param path     下载文件所在路径
     * @param downloadFileName 下载文件名
     * @throws IOException response 存在异常
     */
    public static void download(HttpServletResponse response, String path, String downloadFileName) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 InputStream is = new BufferedInputStream(fis);
                 OutputStream os = new BufferedOutputStream((response.getOutputStream()))) {
                handleFileStream(response, is, os, downloadFileName, file);
            } catch (IOException ex) {
                response.setStatus(400);
                throw ex;
            } finally {
                response.getOutputStream().flush();
                response.getOutputStream().close();
                FileUtils.deleteQuietly(file);
            }
        } else {
            response.setStatus(400);
            try (PrintWriter out = response.getWriter()) {
                out.print("file not found");
            }
            throw new FileNotFoundException(file.getPath() + " not exist");
        }
    }
    /**
     * 文件输出
     * @param response 输出流对象
     * @param is 文件输入流
     * @param os 文件输出流
     * @param downloadFileName 下载文件名
     * @param file 文件对象
     */
    private static  void handleFileStream(HttpServletResponse response, InputStream is, OutputStream os, String downloadFileName, File file) throws IOException {
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFileName, Constants.UTF8_ENCODING));
        response.addHeader("Content-Length", "" + file.length());
        response.setContentType("application/octet-stream");
        byte[] buffer = new byte[16 * 1024];
        int i = -1;
        while ((i = is.read(buffer)) != -1) {
            os.write(buffer, 0, i);
        }
        os.flush();
    }

    /**
     * 获取一个随机生成的临时目录
     *
     * @return 返回该随机生成的临时目录
     */
    public static String getRandomTempPath() {
        String path = FileUtils.getTempDirectoryPath() + File.separator + HIMP_TEMP_DIR + File.separator + RandomUtil.generateRandomString(8);
        FileUtils.deleteQuietly(new File(path));
        return FileUtils.getTempDirectoryPath() + File.separator + HIMP_TEMP_DIR + File.separator + RandomUtil.generateRandomString(8);
    }
}
