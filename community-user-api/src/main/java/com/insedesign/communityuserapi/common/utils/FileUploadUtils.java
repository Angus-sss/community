package com.insedesign.communityuserapi.common.utils;

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
 * @time: 2019/10/31 15:31
 * @explain: 文件上传
 */
@Component
public class FileUploadUtils {
    @Resource
    private FileInfoProperties properties;

    /**
     * /imgs/2019123121/
     * @return
     */
    public String getImageRootPath() {
        return properties.getImagePath() + File.separator + DateFormatUtils.format(new Date(), "yyyyMMdd");
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
        //  获取图片的名字
        String fileName = getFileName(properties.getPrefixImg(), multipartFile.getOriginalFilename());
        //  生成保存图片的数据库路径
        String imageFile = getImageRootPath() + File.separator + fileName;
        // 生成完成的保存图片的路径
        File file = new File(properties.getRootPath() + File.separator + imageFile);
        saveFile(multipartFile.getInputStream(), file);
        return imageFile;
    }

    public void saveFile(InputStream is, File to) throws IOException {
        //生成文件
        FileUtils.touch(to);
        // 保存到服务器
        FileUtils.copyInputStreamToFile(is, to);
    }
}
