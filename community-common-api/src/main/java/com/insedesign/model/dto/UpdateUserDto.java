package com.insedesign.model.dto;


import lombok.Data;
/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 21:52
 * @Explain:
 */
@Data
public class UpdateUserDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 现居住地址
     */
    private String address;


    /**
     * 用户地区
     */
    private String locationCd;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 性别，0表示男孩 1表示女孩
     */
    private String sex;


}
