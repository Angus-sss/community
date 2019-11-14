package com.insedesign.communityadmin.common.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author: NALHOUG
 * @time: 2019/10/31 20:31
 * @explain: 文件上传工具
 */
@Component
public class UploadUtils {
    @Resource
    private FileInfoProperties properties;

    /**
     * @explain
     */
    public String getImageRootPath() {
        return properties.getRootPath() + File.separator + properties.getImagePath() + File.separator + DateFormatUtils.format(new Date(), "yyyyMMdd");
    }

    /**
     * @param prefix      文件的前缀
     * @param oldFileName 旧文件的名字
     * @return 新文件的名称
     */
    public String getFileName(String prefix, String oldFileName) {
        //  .png  或者.jpg
        String suffixName = oldFileName.substring(oldFileName.indexOf("."));
        //IMG_201910311717.png
        return prefix + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + suffixName;
    }

    public String saveImageFile(MultipartFile multipartFile) throws IOException {
        String imageRootPath = getImageRootPath();
        String fileName = getFileName(properties.getPrefixImg(), multipartFile.getOriginalFilename());
        File file = new File(imageRootPath + File.separator + fileName);
        saveFile(multipartFile.getInputStream(), file);
        return "";
    }

    public void saveFile(InputStream is, File to) throws IOException {
        FileUtils.touch(to);
        FileUtils.copyInputStreamToFile(is, to);
    }
}

