package com.insedesign.communitybuildingapi.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: NALHOUG
 * @time: 2019/10/31 15:31
 * @explain: 文件类
 */
@Component
@ConfigurationProperties("fileupload")
@Data
public class FileInfoProperties {
    private String rootPath;
    private String imagePath;
    private String pdfPath;
    private String prefixImg;
}
